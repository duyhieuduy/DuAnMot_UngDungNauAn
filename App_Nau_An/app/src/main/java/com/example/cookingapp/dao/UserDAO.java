package com.example.cookingapp.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cookingapp.SQLite.Sqlite;
import com.example.cookingapp.model.LoaiMon;
import com.example.cookingapp.model.User;

import java.util.ArrayList;

public class UserDAO {
    Sqlite sqlite;
    public UserDAO(Context context){
        sqlite = new Sqlite(context);
    }
    public ArrayList<User> getDSUser(){
        ArrayList<User> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sqlite.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM USER", null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();

            do {
                list.add(new User(cursor.getString(0), cursor.getString(1)));
            }while (cursor.moveToNext());
        }
        return list;
    }
}
