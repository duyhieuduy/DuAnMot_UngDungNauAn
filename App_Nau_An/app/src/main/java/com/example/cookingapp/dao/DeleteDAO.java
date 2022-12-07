package com.example.cookingapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.cookingapp.DB.DBHelper;

public class DeleteDAO {
    public DBHelper dbHelper;
    public DeleteDAO(Context context){
        dbHelper = new DBHelper(context);
    }

    public boolean xoaMonLuu(int mamon){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        int row = database.delete("CONGTHUCNGUYENLIEU, MON", "mamon = ?", new String[]{String.valueOf(mamon)});
        return (row>0);
    }
}
