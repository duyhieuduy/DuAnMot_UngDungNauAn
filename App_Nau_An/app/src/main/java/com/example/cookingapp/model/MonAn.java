package com.example.cookingapp.model;

public class MonAn {
    public int mamon;
    public int maloai;
    public String tenmon;
    public String congthuclam;
    public String thoigiannau;
    public String dokho;

    public MonAn(int mamon, int maloai, String tenmon, String congthuclam, String thoigiannau, String dokho) {
        this.mamon = mamon;
        this.maloai = maloai;
        this.tenmon = tenmon;
        this.congthuclam = congthuclam;
        this.thoigiannau = thoigiannau;
        this.dokho = dokho;
    }

    public int getMamon() {
        return mamon;
    }

    public void setMamon(int mamon) {
        this.mamon = mamon;
    }

    public int getMaloai() {
        return maloai;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public String getCongthuclam() {
        return congthuclam;
    }

    public void setCongthuclam(String congthuclam) {
        this.congthuclam = congthuclam;
    }

    public String getThoigiannau() {
        return thoigiannau;
    }

    public void setThoigiannau(String thoigiannau) {
        this.thoigiannau = thoigiannau;
    }

    public String getDokho() {
        return dokho;
    }

    public void setDokho(String dokho) {
        this.dokho = dokho;
    }
}
