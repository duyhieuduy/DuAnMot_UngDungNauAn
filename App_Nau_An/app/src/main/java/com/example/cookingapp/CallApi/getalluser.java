package com.example.cookingapp.CallApi;

public class getalluser {

    String tendangnhap,matkhau;
    int sdt;
    String email,diachi;
    int tuoi;

    public getalluser(String tendangnhap, String matkhau, int sdt, String email, String diachi, int tuoi) {
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.sdt = sdt;
        this.email = email;
        this.diachi = diachi;
        this.tuoi = tuoi;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
}
