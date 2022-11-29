package com.example.cookingapp.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cookingapp.model.Tennguyenlieu;
import com.example.cookingapp.DB.DBHelper;
import com.example.cookingapp.model.FoodInFor;

import java.util.ArrayList;

public class CongThucNguyenLieuDAO {
    public DBHelper dbHelper;
    public CongThucNguyenLieuDAO(Context context){
        dbHelper = new DBHelper(context);
    }

    public ArrayList<FoodInFor> getAll(){
        ArrayList<FoodInFor> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select m.mamon,m.tenmon,m.dokho,m.thoigiannau,m.anhmon,lm.tenloai" +
                " from MON as m, LOAIMON as lm" +
                " where lm.maloai = m.maloai",null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new FoodInFor(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        gettennltheoidmon(cursor.getInt(0))));
            }while (cursor.moveToNext());
        }
        return list;
    }
    public ArrayList<Tennguyenlieu> gettennltheoidmon(int idmon){
        ArrayList<Tennguyenlieu> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select nl.tennguyenlieu" +
                " from CONGTHUCNGUYENLIEU as ctnl, NGUYENLIEU as nl, MON as m " +
                " where m.mamon = ctnl.mamon and  ctnl.manguyenlieu = nl.manguyenlieu" +
                " and m.mamon = ?",new String[]{String.valueOf(idmon)});
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new Tennguyenlieu(cursor.getString(0)));
            }while (cursor.moveToNext());
        }
        return list;
    }





}
