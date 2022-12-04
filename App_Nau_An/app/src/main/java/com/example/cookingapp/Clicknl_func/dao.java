package com.example.cookingapp.Clicknl_func;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class dao {
    public NewNldb dbHelper;
    public dao(Context context){
        dbHelper = new NewNldb(context);
    }
    public ArrayList<NewNguyenLieu> getall(){
        ArrayList<NewNguyenLieu> list = new ArrayList<>();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM newNL", null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new NewNguyenLieu(cursor.getString(0)));
            }while (cursor.moveToNext());
        }
        return list;
    }

    public boolean insert(String tennl){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tennl", tennl);
        long check = database.insert("newNL", null, contentValues);
        if (check == -1){
            return false;
        }
        return true;

    }
    public boolean xoaNguyenLieu(String id){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        long check = sqLiteDatabase.delete("newNL","tennl=?",new String[]{String.valueOf(id)});
        if (check == -1)
            return false;
        return true;
    }

}
