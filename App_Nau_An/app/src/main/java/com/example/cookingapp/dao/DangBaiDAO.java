package com.example.cookingapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cookingapp.database.DB;
import com.example.cookingapp.model.DangBai;

import java.util.ArrayList;

public class DangBaiDAO {
    DB dbHelper;
    public DangBaiDAO(Context context){
        dbHelper = new DB(context);
    }
    public ArrayList<DangBai> getDSMon(){
        ArrayList<DangBai> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM DANGBAI", null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new DangBai(cursor.getString(0), cursor.getString(1), cursor.getString(2),cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9),cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15), cursor.getString(16) ));

            }while (cursor.moveToNext());
        }
        return list;
    }
    public boolean themMonMoi(String anhmon, String tenmon, String loaimon, String thoigiannau, String dokho, String nguyenlieu1, String khoiluong1, String nguyenlieu2, String khoiluong2, String nguyenlieu3, String khoiluong3, String nguyenlieu4, String khoiluong4, String cachlam, String anhcachlam1, String anhcachlam2, String anhcachlam3){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("anhmon", anhmon);
        contentValues.put("tenmon", tenmon);
        contentValues.put("loaimon", loaimon);
        contentValues.put("thoigiannau", thoigiannau);
        contentValues.put("dokho", dokho);
        contentValues.put("nguyenlieu1", nguyenlieu1);
        contentValues.put("khoiluong1", khoiluong1);
        contentValues.put("nguyenlieu2", nguyenlieu2);
        contentValues.put("khoiluong2", khoiluong2);
        contentValues.put("nguyenlieu3", nguyenlieu3);
        contentValues.put("khoiluong3", khoiluong3);
        contentValues.put("nguyenlieu4", nguyenlieu4);
        contentValues.put("khoiluong4", khoiluong4);
        contentValues.put("tenmon", tenmon);
        contentValues.put("anhcachlam1", anhcachlam1);
        contentValues.put("anhcachlam2", anhcachlam2);
        contentValues.put("anhcachlam3", anhcachlam3);

        long check = sqLiteDatabase.insert("DANGBAI", null, contentValues);
        if (check == -1 ){
            return false;
        }
        return true;
    }
}
