package com.example.cookingapp.model;

public class Save {
    private String username;
    private String mamon;

    public Save(String username, String mamon) {
        this.username = username;
        this.mamon = mamon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }
}
