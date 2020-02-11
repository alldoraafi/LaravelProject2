package com.example.laravelproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PemenangAdapter extends RecyclerView.Adapter<PemenangViewHolder> {
    private Context context;
    private ArrayList<Pemenang> pemenangs;

    public PemenangAdapter(Context context, ArrayList<Pemenang> pemenangs) {
        this.context = context;
        this.pemenangs = pemenangs;
    }

    @NonNull
    @Override
    public PemenangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view_pemenang, parent, false);
        return new PemenangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PemenangViewHolder holder, int position) {
        Pemenang pemenang = pemenangs.get(position);
        holder.setTv_id(pemenang.getId_peserta());
        holder.setTv_jenis(pemenang.getStatus());
    }

    @Override
    public int getItemCount() {
        if (pemenangs!=null) {
            return pemenangs.size();
        } else {
            return 0;
        }
    }
}
