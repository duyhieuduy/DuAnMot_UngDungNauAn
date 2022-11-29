package com.example.cookingapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cookingapp.DB.DBHelper;
import com.example.cookingapp.model.DangBai;

import java.util.ArrayList;

public class DangBaiDao {
    DBHelper dbHelper;
    public DangBaiDao(Context context){
        dbHelper = new DBHelper(context);
    }

    public boolean insertDangMon(String anhmon, String tenmon, String anhcachlam1, String anhcachlam2, String anhcachlam3){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maloai", anhmon);
        contentValues.put("tenmon", tenmon);
        contentValues.put("congthuclam", anhcachlam1);
        contentValues.put("thoigiannau", anhcachlam2);
        contentValues.put("dokho", anhcachlam3);
        contentValues.put("anhmon", anhcachlam3);
        contentValues.put("cachlam", anhcachlam3);
        long check = database.insert("MON", null, contentValues);
        if (check == -1){
            return false;
        }
        return true;

    }
}
