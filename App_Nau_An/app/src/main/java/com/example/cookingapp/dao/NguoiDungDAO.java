package com.example.cookingapp.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cookingapp.DB.DBHelper;

public class NguoiDungDAO {
    DBHelper dbHelper;
    public NguoiDungDAO(Context context){
        dbHelper = new DBHelper(context);

    }
    public boolean checkDangNhap(String tendangnhap, String matkhau){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE tendangnhap=? AND matkhau=?", new String[]{tendangnhap, matkhau});
        if (cursor.getCount() != 0){
            return  true;
        }else {
            return false;
        }
    }
}
