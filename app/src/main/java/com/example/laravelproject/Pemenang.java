package com.example.laravelproject;

import com.google.gson.annotations.SerializedName;

public class Pemenang {
    @SerializedName("id_peserta")
    int id_peserta;
    @SerializedName("id_acara")
    int id_acara;
    @SerializedName("status")
    String status;

    public Pemenang(int id_peserta, int id_acara, String status) {
        this.id_peserta = id_peserta;
        this.id_acara = id_acara;
        this.status = status;
    }

    public int getId_peserta() {
        return id_peserta;
    }

    public void setId_peserta(int id_peserta) {
        this.id_peserta = id_peserta;
    }

    public int getId_acara() {
        return id_acara;
    }

    public void setId_acara(int id_acara) {
        this.id_acara = id_acara;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
