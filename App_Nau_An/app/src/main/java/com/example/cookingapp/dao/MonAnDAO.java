package com.example.cookingapp.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cookingapp.SQLite.Sqlite;
import com.example.cookingapp.model.MonAn;

import java.util.ArrayList;

public class MonAnDAO {
    Sqlite sqlite;
    public MonAnDAO(Context context){
        sqlite = new Sqlite(context);
    }
    public ArrayList<MonAn> getDSMonAn(){
        ArrayList<MonAn> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sqlite.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM MONAN", null);
        if (cursor.getCount() != 0){
            do {
                list.add(new MonAn(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            }while (cursor.moveToNext());
        }
        return list;
    }



}
