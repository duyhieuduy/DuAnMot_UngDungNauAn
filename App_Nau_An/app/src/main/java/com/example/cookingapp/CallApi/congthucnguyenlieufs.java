package com.example.cookingapp.CallApi;

public class congthucnguyenlieufs {
    private int idctnl;
    private int mamon;
    private String tennguyenlieu;
    private String khoiluong;

    public congthucnguyenlieufs(int idctnl, int mamon, String tennguyenlieu, String khoiluong) {
        this.idctnl = idctnl;
        this.mamon = mamon;
        this.tennguyenlieu = tennguyenlieu;
        this.khoiluong = khoiluong;
    }

    public int getIdctnl() {
        return idctnl;
    }

    public void setIdctnl(int idctnl) {
        this.idctnl = idctnl;
    }

    public int getMamon() {
        return mamon;
    }

    public void setMamon(int mamon) {
        this.mamon = mamon;
    }

    public String getTennguyenlieu() {
        return tennguyenlieu;
    }

    public void setTennguyenlieu(String tennguyenlieu) {
        this.tennguyenlieu = tennguyenlieu;
    }

    public String getKhoiluong() {
        return khoiluong;
    }

    public void setKhoiluong(String khoiluong) {
        this.khoiluong = khoiluong;
    }
}
