package com.example.cookingapp.model;

public class ThongBao {
    private String username;
    private String noidungthongbao;

    public ThongBao(String username, String noidungthongbao) {
        this.username = username;
        this.noidungthongbao = noidungthongbao;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNoidungthongbao() {
        return noidungthongbao;
    }

    public void setNoidungthongbao(String noidungthongbao) {
        this.noidungthongbao = noidungthongbao;
    }
}
