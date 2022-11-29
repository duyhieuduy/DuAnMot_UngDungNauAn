package com.example.cookingapp.model;

public class DangBai {
    private String anhmon;
    private String tenmon;
    private String anhcachlam1;
    private String anhcachlam2;
    private String anhcachlam3;

    public DangBai(String anhmon, String tenmon, String anhcachlam1, String anhcachlam2, String anhcachlam3) {
        this.anhmon = anhmon;
        this.tenmon = tenmon;
        this.anhcachlam1 = anhcachlam1;
        this.anhcachlam2 = anhcachlam2;
        this.anhcachlam3 = anhcachlam3;
    }

    public String getAnhmon() {
        return anhmon;
    }

    public void setAnhmon(String anhmon) {
        this.anhmon = anhmon;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public String getAnhcachlam1() {
        return anhcachlam1;
    }

    public void setAnhcachlam1(String anhcachlam1) {
        this.anhcachlam1 = anhcachlam1;
    }

    public String getAnhcachlam2() {
        return anhcachlam2;
    }

    public void setAnhcachlam2(String anhcachlam2) {
        this.anhcachlam2 = anhcachlam2;
    }

    public String getAnhcachlam3() {
        return anhcachlam3;
    }

    public void setAnhcachlam3(String anhcachlam3) {
        this.anhcachlam3 = anhcachlam3;
    }
}
