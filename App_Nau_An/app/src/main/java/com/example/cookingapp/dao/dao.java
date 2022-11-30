package com.example.cookingapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cookingapp.model.NewNguyenLieu;
import com.example.cookingapp.DB.db;

import java.util.ArrayList;

public class dao {
    public db dbHelper;
    public dao(Context context){
        dbHelper = new db(context);
    }
    public ArrayList<NewNguyenLieu> getall(){
        ArrayList<NewNguyenLieu> list = new ArrayList<>();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM newNL", null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new NewNguyenLieu(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            }while (cursor.moveToNext());
        }
        return list;
    }

    public boolean insert(int manl, String tennl, String anhnl){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("manl", manl);
        contentValues.put("tennl", tennl);
        contentValues.put("anhnl", anhnl);
        long check = database.insert("newNL", null, contentValues);
        if (check == -1){
            return false;
        }
        return true;

    }
    public boolean xoaNguyenLieu(int id){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
//        Cursor cursor  = sqLiteDatabase.rawQuery("SELECT*FROM newNL WHERE manl=?",new String[]{String.valueOf(id)});
//        if (cursor.getCount() !=0){
//            return -1;
//        }
        long check = sqLiteDatabase.delete("newNL","manl=?",new String[]{String.valueOf(id)});
        if (check == -1)
            return false;
        return true;
    }

}
