package com.example.cookingapp.model;

public class NguyenLieu {
    private String manguyenlieu;
    private String tennguyenlieu;
    private String anhnguyenlieu;

    public NguyenLieu(String manguyenlieu, String tennguyenlieu, String anhnguyenlieu) {
        this.manguyenlieu = manguyenlieu;
        this.tennguyenlieu = tennguyenlieu;
        this.anhnguyenlieu = anhnguyenlieu;
    }

    public String getManguyenlieu() {
        return manguyenlieu;
    }

    public void setManguyenlieu(String manguyenlieu) {
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
