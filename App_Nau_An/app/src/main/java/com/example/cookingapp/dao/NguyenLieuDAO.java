package com.example.cookingapp.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cookingapp.SQLite.Sqlite;
import com.example.cookingapp.model.LoaiMon;
import com.example.cookingapp.model.NguyenLieu;

import java.util.ArrayList;

public class NguyenLieuDAO {
    Sqlite sqlite;
    public NguyenLieuDAO(Context context){
        sqlite = new Sqlite(context);
    }
    public ArrayList<NguyenLieu> getDSNguyenLieu(){
        ArrayList<NguyenLieu> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sqlite.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM NGUYENLIEU", null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();

            do {
                list.add(new NguyenLieu(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            }while (cursor.moveToNext());
        }
        return list;
    }
}
