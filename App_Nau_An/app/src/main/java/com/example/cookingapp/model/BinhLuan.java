package com.example.cookingapp.model;

import android.widget.TextView;

public class BinhLuan {
    int mamon,idbinhluan;
    String tendangnhap,noidungbinhluan;

    public BinhLuan(int mamon, int idbinhluan, String tendangnhap, String noidungbinhluan) {
        this.mamon = mamon;
        this.idbinhluan = idbinhluan;
        this.tendangnhap = tendangnhap;
        this.noidungbinhluan = noidungbinhluan;
    }

    public int getMamon() {
        return mamon;
    }

    public void setMamon(int mamon) {
        this.mamon = mamon;
    }

    public int getIdbinhluan() {
        return idbinhluan;
    }

    public void setIdbinhluan(int idbinhluan) {
        this.idbinhluan = idbinhluan;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getNoidungbinhluan() {
        return noidungbinhluan;
    }

    public void setNoidungbinhluan(String noidungbinhluan) {
        this.noidungbinhluan = noidungbinhluan;
    }
}
