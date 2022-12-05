package com.example.cookingapp.CallApi;

import java.util.List;

public class Food {
    private int mamon;
    private int maloai;
    private String tenloai;
    private String tenmon;
    private String congthuclam;
    private String tgnau;
    private String dokho;
    private String anhmonlvo;
    private String cachlam;
    private List<anhmonanfs> anhmonanfs;
    private List<binhluanfs> binhluanfs;
    private List<congthucnguyenlieufs> congthucnguyenlieufs;
    private List<nguoidungsavefs> nguoidungsavefs;
    private List<nguoidungdbfs> nguoidungdbfs;

    public Food(int mamon, int maloai, String tenloai, String tenmon, String congthuclam, String tgnau, String dokho, String anhmonlvo, String cachlam, List<com.example.cookingapp.CallApi.anhmonanfs> anhmonanfs, List<com.example.cookingapp.CallApi.binhluanfs> binhluanfs, List<com.example.cookingapp.CallApi.congthucnguyenlieufs> congthucnguyenlieufs, List<com.example.cookingapp.CallApi.nguoidungsavefs> nguoidungsavefs, List<com.example.cookingapp.CallApi.nguoidungdbfs> nguoidungdbfs) {
        this.mamon = mamon;
        this.maloai = maloai;
        this.tenloai = tenloai;
        this.tenmon = tenmon;
        this.congthuclam = congthuclam;
        this.tgnau = tgnau;
        this.dokho = dokho;
        this.anhmonlvo = anhmonlvo;
        this.cachlam = cachlam;
        this.anhmonanfs = anhmonanfs;
        this.binhluanfs = binhluanfs;
        this.congthucnguyenlieufs = congthucnguyenlieufs;
        this.nguoidungsavefs = nguoidungsavefs;
        this.nguoidungdbfs = nguoidungdbfs;
    }

    public int getMamon() {
        return mamon;
    }

    public void setMamon(int mamon) {
        this.mamon = mamon;
    }

    public int getMaloai() {
        return maloai;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public String getCongthuclam() {
        return congthuclam;
    }

    public void setCongthuclam(String congthuclam) {
        this.congthuclam = congthuclam;
    }

    public String getTgnau() {
        return tgnau;
    }

    public void setTgnau(String tgnau) {
        this.tgnau = tgnau;
    }

    public String getDokho() {
        return dokho;
    }

    public void setDokho(String dokho) {
        this.dokho = dokho;
    }

    public String getAnhmonlvo() {
        return anhmonlvo;
    }

    public void setAnhmonlvo(String anhmonlvo) {
        this.anhmonlvo = anhmonlvo;
    }

    public String getCachlam() {
        return cachlam;
    }

    public void setCachlam(String cachlam) {
        this.cachlam = cachlam;
    }

    public List<com.example.cookingapp.CallApi.anhmonanfs> getAnhmonanfs() {
        return anhmonanfs;
    }

    public void setAnhmonanfs(List<com.example.cookingapp.CallApi.anhmonanfs> anhmonanfs) {
        this.anhmonanfs = anhmonanfs;
    }

    public List<com.example.cookingapp.CallApi.binhluanfs> getBinhluanfs() {
        return binhluanfs;
    }

    public void setBinhluanfs(List<com.example.cookingapp.CallApi.binhluanfs> binhluanfs) {
        this.binhluanfs = binhluanfs;
    }

    public List<com.example.cookingapp.CallApi.congthucnguyenlieufs> getCongthucnguyenlieufs() {
        return congthucnguyenlieufs;
    }

    public void setCongthucnguyenlieufs(List<com.example.cookingapp.CallApi.congthucnguyenlieufs> congthucnguyenlieufs) {
        this.congthucnguyenlieufs = congthucnguyenlieufs;
    }

    public List<com.example.cookingapp.CallApi.nguoidungsavefs> getNguoidungsavefs() {
        return nguoidungsavefs;
    }

    public void setNguoidungsavefs(List<com.example.cookingapp.CallApi.nguoidungsavefs> nguoidungsavefs) {
        this.nguoidungsavefs = nguoidungsavefs;
    }

    public List<com.example.cookingapp.CallApi.nguoidungdbfs> getNguoidungdbfs() {
        return nguoidungdbfs;
    }

    public void setNguoidungdbfs(List<com.example.cookingapp.CallApi.nguoidungdbfs> nguoidungdbfs) {
        this.nguoidungdbfs = nguoidungdbfs;
    }
}

