package com.example.cookingapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cookingapp.SQLite.DBHelper;
import com.example.cookingapp.SQLite.Sqlite;
import com.example.cookingapp.model.MonAn;

import java.util.ArrayList;

public class MonAnDAO {
    DBHelper dbHelper;
    public MonAnDAO(Context context){
        dbHelper = new DBHelper(context);
    }
    public ArrayList<MonAn> getDSMonAn(){
        ArrayList<MonAn> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM MON", null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new MonAn(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)));
            }while (cursor.moveToNext());
        }
        return list;
    }


}
