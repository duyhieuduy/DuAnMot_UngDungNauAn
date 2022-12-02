package com.example.cookingapp.model;

public class CTNL {
    private int mamon;
    private int manguyenlieu;
    private String khoiluong;

    public CTNL(int mamon, int manguyenlieu, String khoiluong) {
        this.mamon = mamon;
        this.manguyenlieu = manguyenlieu;
        this.khoiluong = khoiluong;
    }

    public int getMamon() {
        return mamon;
    }

    public void setMamon(int mamon) {
        this.mamon = mamon;
    }

    public int getManguyenlieu() {
        return manguyenlieu;
    }

    public void setManguyenlieu(int manguyenlieu) {
        this.manguyenlieu = manguyenlieu;
    }

    public String getKhoiluong() {
        return khoiluong;
    }

    public void setKhoiluong(String khoiluong) {
        this.khoiluong = khoiluong;
    }
}
