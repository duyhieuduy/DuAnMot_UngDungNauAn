package com.example.cookingapp.model;

public class NguyenLieu {
    int manguyenlieu;
    String tennguyenlieu;
    String anhnguyenlieu;


    public NguyenLieu(int manguyenlieu, String tennguyenlieu, String anhnguyenlieu) {
        this.manguyenlieu = manguyenlieu;
        this.tennguyenlieu = tennguyenlieu;
        this.anhnguyenlieu = anhnguyenlieu;
    }

    public int getManguyenlieu() {
        return manguyenlieu;
    }

    public void setManguyenlieu(int manguyenlieu) {
        this.manguyenlieu = manguyenlieu;
    }

    public String getTennguyenlieu() {
        return tennguyenlieu;
    }

    public void setTennguyenlieu(String tennguyenlieu) {
        this.tennguyenlieu = tennguyenlieu;
    }

    public String getAnhnguyenlieu() {
        return anhnguyenlieu;
    }

    public void setAnhnguyenlieu(String anhnguyenlieu) {
        this.anhnguyenlieu = anhnguyenlieu;
    }

}
