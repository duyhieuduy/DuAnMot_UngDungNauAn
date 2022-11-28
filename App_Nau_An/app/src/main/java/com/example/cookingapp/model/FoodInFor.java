package com.example.cookingapp.model;

public class FoodInFor {
    int mamon;
    String imgfood,TenDs,tennl1,tennl2,dok,thoigiannau,edtbl;

    public FoodInFor(int mamon, String imgfood, String tenDs, String tennl1, String tennl2, String dok, String thoigiannau, String edtbl) {
        this.mamon = mamon;
        this.imgfood = imgfood;
        this.TenDs = tenDs;
        this.tennl1 = tennl1;
        this.tennl2 = tennl2;
        this.dok = dok;
        this.thoigiannau = thoigiannau;
        this.edtbl = edtbl;
    }

    public int getMamon() {
        return mamon;
    }

    public void setMamon(int mamon) {
        this.mamon = mamon;
    }

    public String getImgfood() {
        return imgfood;
    }

    public void setImgfood(String imgfood) {
        this.imgfood = imgfood;
    }

    public String getTenDs() {
        return TenDs;
    }

    public void setTenDs(String tenDs) {
        TenDs = tenDs;
    }

    public String getTennl1() {
        return tennl1;
    }

    public void setTennl1(String tennl1) {
        this.tennl1 = tennl1;
    }

    public String getTennl2() {
        return tennl2;
    }

    public void setTennl2(String tennl2) {
        this.tennl2 = tennl2;
    }

    public String getDok() {
        return dok;
    }

    public void setDok(String dok) {
        this.dok = dok;
    }

    public String getThoigiannau() {
        return thoigiannau;
    }

    public void setThoigiannau(String thoigiannau) {
        this.thoigiannau = thoigiannau;
    }

    public String getEdtbl() {
        return edtbl;
    }

    public void setEdtbl(String edtbl) {
        this.edtbl = edtbl;
    }
}
