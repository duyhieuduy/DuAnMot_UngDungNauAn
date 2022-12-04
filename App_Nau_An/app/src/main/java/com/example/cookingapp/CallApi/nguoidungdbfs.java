package com.example.cookingapp.CallApi;

public class nguoidungdbfs {
    int idndb;
    int mamon;
    String tennguoidung;

    public nguoidungdbfs(int idndb, int mamon, String tennguoidung) {
        this.idndb = idndb;
        this.mamon = mamon;
        this.tennguoidung = tennguoidung;
    }

    public int getIdndb() {
        return idndb;
    }

    public void setIdndb(int idndb) {
        this.idndb = idndb;
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
