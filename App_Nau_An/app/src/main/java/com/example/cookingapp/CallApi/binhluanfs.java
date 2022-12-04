package com.example.cookingapp.CallApi;

public class binhluanfs {
    private int idBl;
    private int mamon;
    private String tendangnhap;
    private String noidungbl;

    public binhluanfs(int idBl, int mamon, String tendangnhap, String noidungbl) {
        this.idBl = idBl;
        this.mamon = mamon;
        this.tendangnhap = tendangnhap;
        this.noidungbl = noidungbl;
    }

    public int getIdBl() {
        return idBl;
    }

    public void setIdBl(int idBl) {
        this.idBl = idBl;
    }

    public int getMamon() {
        return mamon;
    }

    public void setMamon(int mamon) {
        this.mamon = mamon;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getNoidungbl() {
        return noidungbl;
    }

    public void setNoidungbl(String noidungbl) {
        this.noidungbl = noidungbl;
    }
}
