package com.example.cookingapp.model;

public class HinhAnh {
    private String anhmon;
    private String mamon;

    public HinhAnh(String anhmon, String mamon) {
        this.anhmon = anhmon;
        this.mamon = mamon;
    }

    public String getAnhmon() {
        return anhmon;
    }

    public void setAnhmon(String anhmon) {
        this.anhmon = anhmon;
    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }
}
