package com.example.cookingapp.model;

public class UserSave {
    private String tendangnhap;
    private int mamon;

    public UserSave(String tendangnhap, int mamon) {
        this.tendangnhap = tendangnhap;
        this.mamon = mamon;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public int getMamon() {
        return mamon;
    }

    public void setMamon(int mamon) {
        this.mamon = mamon;
    }
}
