package com.example.cookingapp.model;

public class UserSave {
    private int mamon;
    private String tendangnhap;

    public UserSave(int mamon, String tendangnhap) {
        this.mamon = mamon;
        this.tendangnhap = tendangnhap;
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
