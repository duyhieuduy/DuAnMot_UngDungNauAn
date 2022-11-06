package com.example.cookingapp.model;

public class ThongBao {
    private String username;
    private String noidung;

    public ThongBao(String username, String noidung) {
        this.username = username;
        this.noidung = noidung;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
}
