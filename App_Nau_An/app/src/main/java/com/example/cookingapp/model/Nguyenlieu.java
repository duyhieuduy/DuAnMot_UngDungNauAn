package com.example.cookingapp.model;

public class Nguyenlieu {
    int manguyenlieu;
    String tenNL;
    String anhnguyenlieu;

    public Nguyenlieu(int manguyenlieu, String tenNL, String anhnguyenlieu) {
        this.manguyenlieu = manguyenlieu;
        this.tenNL = tenNL;
        this.anhnguyenlieu = anhnguyenlieu;
    }

    public int getManguyenlieu() {
        return manguyenlieu;
    }

    public void setManguyenlieu(int manguyenlieu) {
        this.manguyenlieu = manguyenlieu;
    }

    public String getTenNL() {
        return tenNL;
    }

    public void setTenNL(String tenNL) {
        this.tenNL = tenNL;
    }

    public String getAnhnguyenlieu() {
        return anhnguyenlieu;
    }

    public void setAnhnguyenlieu(String anhnguyenlieu) {
        this.anhnguyenlieu = anhnguyenlieu;
    }
}
