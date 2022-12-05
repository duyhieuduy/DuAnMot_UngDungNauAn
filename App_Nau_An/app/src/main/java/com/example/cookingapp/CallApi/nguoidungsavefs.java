package com.example.cookingapp.CallApi;

public class nguoidungsavefs {

    int idnds;
    int mamon;
    String tennguoidung;
    public nguoidungsavefs(int idnds, int mamon, String tennguoidung) {
        this.idnds = idnds;
        this.mamon = mamon;
        this.tennguoidung = tennguoidung;
    }

    public int getIdnds() {
        return idnds;
    }

    public void setIdnds(int idnds) {
        this.idnds = idnds;
    }

    public int getMamon() {
        return mamon;
    }

    public void setMamon(int mamon) {
        this.mamon = mamon;
    }

    public String getTennguoidung() {
        return tennguoidung;
    }

    public void setTennguoidung(String tennguoidung) {
        this.tennguoidung = tennguoidung;
    }
}
