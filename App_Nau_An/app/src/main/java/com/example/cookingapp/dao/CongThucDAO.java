package com.example.cookingapp.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cookingapp.SQLite.Sqlite;
import com.example.cookingapp.model.CongThuc;
import com.example.cookingapp.model.LoaiMon;

import java.util.ArrayList;

public class CongThucDAO {
    Sqlite sqlite;
    public CongThucDAO(Context context){
        sqlite = new Sqlite(context);
    }
    public ArrayList<CongThuc> getDSCongThuc(){
        ArrayList<CongThuc> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sqlite.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM CONGTHUCNGUYENLIEU", null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();

            do {
                list.add(new CongThuc(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            }while (cursor.moveToNext());
        }
        return list;
    }
}
