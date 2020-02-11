package com.example.laravelproject;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PemenangViewHolder extends RecyclerView.ViewHolder {
    TextView tv_id, tv_jenis;
    public PemenangViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_id = itemView.findViewById(R.id.tv_id);
        tv_jenis = itemView.findViewById(R.id.tv_jenis);

    }

    public void setTv_id(int id) {
        this.tv_id.setText(String.valueOf(id));
    }

    public void setTv_jenis(String jenis) {
        this.tv_jenis.setText(jenis);
    }
}
