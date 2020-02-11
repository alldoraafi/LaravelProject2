package com.example.laravelproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    PemenangAdapter pemenangAdapter;
    ArrayList<Pemenang> pemenangArrayList;
    Spinner spinner;
    SpinnerAdapter spinnerAdapter;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.acara_array, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jenis = spinner.getSelectedItem().toString();
                switch (jenis){
                    case "Gerak Jalan": jenis = "pesertaGJ"; break;
                    case "Dies Natalis": jenis = "pesertaDN"; break;
                    case "Kemerdekaan": jenis = "pesertaKM"; break;
                }
                reqPemenang(jenis);
            }
        });


//        Log.d("armot", String.valueOf(pemenangArrayList.get(0).getId_peserta()));

    }

    private void reqPemenang(String jenis){
        APIInterface retrofitClient = RetrofitClient.getRetrofitInstance().create(APIInterface.class);

        Call<List<Pemenang>> call = retrofitClient.getPemenang(new RequestPemenang(jenis));
        call.enqueue(new Callback<List<Pemenang>>() {
            @Override
            public void onResponse(Call<List<Pemenang>> call, Response<List<Pemenang>> response) {
                pemenangArrayList = new ArrayList<Pemenang>(response.body());
                pemenangAdapter = new PemenangAdapter(MainActivity.this, pemenangArrayList);
                recyclerView.setAdapter(pemenangAdapter);
                pemenangAdapter.notifyDataSetChanged();
                Log.d("armot", String.valueOf(pemenangArrayList.get(0).getId_peserta()));
            }

            @Override
            public void onFailure(Call<List<Pemenang>> call, Throwable t) {

            }
        });

    }

}

