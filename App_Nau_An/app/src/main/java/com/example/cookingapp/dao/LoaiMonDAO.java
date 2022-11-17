package com.example.cookingapp.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cookingapp.SQLite.DBHelper;
import com.example.cookingapp.SQLite.Sqlite;
import com.example.cookingapp.model.LoaiMon;

import java.util.ArrayList;

public class LoaiMonDAO {
    DBHelper dbHelper;
    public LoaiMonDAO(Context context){
        dbHelper = new DBHelper(context);
    }
    public ArrayList<LoaiMon> getDSLoaiMon(){
        ArrayList<LoaiMon> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM LOAIMON", null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();

            do {
                list.add(new LoaiMon(cursor.getInt(0), cursor.getString(1)));
            }while (cursor.moveToNext());
        }
        return list;
    }
}
