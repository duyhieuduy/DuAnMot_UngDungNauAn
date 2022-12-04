package com.example.cookingapp.Clicknl_func;

import android.app.Application;

public class NewNguyenLieu extends Application {
    String tennguyenlieu;

    public NewNguyenLieu( String tennguyenlieu) {
        this.tennguyenlieu = tennguyenlieu;
    }



    public String getTennguyenlieu() {
        return tennguyenlieu;
    }

    public void setTennguyenlieu(String tennguyenlieu) {
        this.tennguyenlieu = tennguyenlieu;
    }

}
