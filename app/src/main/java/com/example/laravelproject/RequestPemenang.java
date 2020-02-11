package com.example.laravelproject;

import com.google.gson.annotations.SerializedName;

public class RequestPemenang {
    @SerializedName("acara")
    String acara;

    public RequestPemenang(String acara) {
        this.acara = acara;
    }

    public String getAcara() {
        return acara;
    }

    public void setAcara(String acara) {
        this.acara = acara;
    }
}
