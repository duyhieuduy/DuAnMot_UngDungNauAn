package com.example.cookingapp.model;

public class CongThuc {
    private String mamon;
    private String manguyenlieu;
    private String khoiluong;

    public CongThuc(String mamon, String manguyenlieu, String khoiluong) {
        this.mamon = mamon;
        this.manguyenlieu = manguyenlieu;
        this.khoiluong = khoiluong;
    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    public String getManguyenlieu() {
        return manguyenlieu;
    }

    public void setManguyenlieu(String manguyenlieu) {
        this.manguyenlieu = manguyenlieu;
    }

    public String getKhoiluong() {
        return khoiluong;
    }

    public void setKhoiluong(String khoiluong) {
        this.khoiluong = khoiluong;
    }
}
