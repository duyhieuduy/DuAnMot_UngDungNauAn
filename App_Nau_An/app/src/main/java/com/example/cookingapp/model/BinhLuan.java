package com.example.cookingapp.model;

public class BinhLuan {
    private String username;
    private String mamon;
    private String noidungbinhluan;


    public BinhLuan(String username, String mamon, String noidungbinhluan) {
        this.username = username;
        this.mamon = mamon;
        this.noidungbinhluan = noidungbinhluan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    public String getNoidungbinhluan() {
        return noidungbinhluan;
    }

    public void setNoidungbinhluan(String noidungbinhluan) {
        this.noidungbinhluan = noidungbinhluan;
    }
}
