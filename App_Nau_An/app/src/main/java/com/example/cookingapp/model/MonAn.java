package com.example.cookingapp.model;

public class MonAn {
    public String mamon;
    public String tenmon;
    public String maloai;
    public String congthuc;

    public MonAn(String mamon, String tenmon, String maloai, String congthuc) {
        this.mamon = mamon;
        this.tenmon = tenmon;
        this.maloai = maloai;
        this.congthuc = congthuc;
    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public String getCongthuc() {
        return congthuc;
    }

    public void setCongthuc(String congthuc) {
        this.congthuc = congthuc;
    }
}
