package com.example.cookingapp.model;

import java.util.ArrayList;

public class FooddetailModel {
    int mamon;
    String anhmon,tenmon,congthuclam,cachlam;
    ArrayList<AnhMonAn> list;
    ArrayList<BinhLuan> lista;
    ArrayList<NguyenLieu> listb;



    public FooddetailModel(int mamon, String anhmon, String tenmon, String congthuclam, String cachlam, ArrayList<AnhMonAn> list, ArrayList<BinhLuan> lista, ArrayList<NguyenLieu> listb) {
        this.mamon = mamon;
        this.anhmon = anhmon;
        this.tenmon = tenmon;
        this.congthuclam = congthuclam;
        this.cachlam = cachlam;
        this.list = list;
        this.lista = lista;
        this.listb = listb;
    }

    public FooddetailModel() {

    }

    public int getMamon() {
        return mamon;
    }

    public void setMamon(int mamon) {
        this.mamon = mamon;
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

    public String getCongthuclam() {
        return congthuclam;
    }

    public void setCongthuclam(String congthuclam) {
        this.congthuclam = congthuclam;
    }

    public String getCachlam() {
        return cachlam;
    }

    public void setCachlam(String cachlam) {
        this.cachlam = cachlam;
    }

    public ArrayList<AnhMonAn> getList() {
        return list;
    }

    public void setList(ArrayList<AnhMonAn> list) {
        this.list = list;
    }

    public ArrayList<BinhLuan> getLista() {
        return lista;
    }

    public void setLista(ArrayList<BinhLuan> lista) {
        this.lista = lista;
    }

    public ArrayList<NguyenLieu> getListb() {
        return listb;
    }

    public void setListb(ArrayList<NguyenLieu> listb) {
        this.listb = listb;
    }
}
