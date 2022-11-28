package com.example.cookingapp.model;

import java.util.ArrayList;

public class FoodInFor {
    int mamon;
    String tenmon,dokho,tgnau,anhmonlv0,tenloai;
    ArrayList<Tennguyenlieu> listnl;

    public FoodInFor(ArrayList<Tennguyenlieu> listnl) {
        this.listnl = listnl;
    }

    public FoodInFor(int mamon, String tenmon, String dokho, String tgnau, String anhmonlv0, String tenloai, ArrayList<Tennguyenlieu> listnl) {
        this.mamon = mamon;
        this.tenmon = tenmon;
        this.dokho = dokho;
        this.tgnau = tgnau;
        this.anhmonlv0 = anhmonlv0;
        this.tenloai = tenloai;
        this.listnl = listnl;
    }

    public int getMamon() {
        return mamon;
    }

    public void setMamon(int mamon) {
        this.mamon = mamon;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public String getDokho() {
        return dokho;
    }

    public void setDokho(String dokho) {
        this.dokho = dokho;
    }

    public String getTgnau() {
        return tgnau;
    }

    public void setTgnau(String tgnau) {
        this.tgnau = tgnau;
    }

    public String getAnhmonlv0() {
        return anhmonlv0;
    }

    public void setAnhmonlv0(String anhmonlv0) {
        this.anhmonlv0 = anhmonlv0;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public ArrayList<Tennguyenlieu> getListnl() {
        return listnl;
    }

    public void setListnl(ArrayList<Tennguyenlieu> listnl) {
        this.listnl = listnl;
    }
}
