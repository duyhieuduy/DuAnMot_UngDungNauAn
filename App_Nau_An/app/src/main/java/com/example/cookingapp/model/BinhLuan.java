package com.example.cookingapp.model;

import android.widget.TextView;

public class BinhLuan {
    int mamon;
    String textIDND,binhluan;

    public BinhLuan(int mamon, String textIDND, String binhluan) {
        this.mamon = mamon;
        this.textIDND = textIDND;
        this.binhluan = binhluan;
    }

    public int getMamon() {
        return mamon;
    }

    public void setMamon(int mamon) {
        this.mamon = mamon;
    }

    public String getTextIDND() {
        return textIDND;
    }

    public void setTextIDND(String textIDND) {
        this.textIDND = textIDND;
    }

    public String getBinhluan() {
        return binhluan;
    }

    public void setBinhluan(String binhluan) {
        this.binhluan = binhluan;
    }
}
