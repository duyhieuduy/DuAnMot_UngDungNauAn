package com.example.cookingapp.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cookingapp.model.BinhLuan;
import com.example.cookingapp.model.CLAnhMonAn;
import com.example.cookingapp.model.CTNL;
import com.example.cookingapp.model.FooddetailModel;
import com.example.cookingapp.model.NguyenLieu;
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


    public  ArrayList<FooddetailModel> getClickItemIDmon(int idmamon){
        ArrayList<FooddetailModel> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase  = dbHelper.getReadableDatabase();
       Cursor cursor = sqLiteDatabase.rawQuery("select MON.mamon,MON.anhmon,MON.tenmon, MON.congthuclam, MON.cachlam " +
               "from  MON  " +
               "where mamon = ?"
               ,new String[]{String.valueOf(idmamon)});
       if (cursor.getCount() !=0){
           cursor.moveToFirst();
           do{
               list.add(new FooddetailModel(cursor.getInt(0),
                       cursor.getString(1),
                       cursor.getString(2),
                       cursor.getString(3),
                       cursor.getString(4),
                       getClickItemanh(cursor.getInt(0)),
                       getClickItembinhuan(cursor.getInt(0)),
                       getClickItemngl(cursor.getInt(0))
                       ));
           }while (cursor.moveToNext());

       }
       return list;
    }
    public ArrayList<CLAnhMonAn>getClickItemanh(int idmamon){
        ArrayList<CLAnhMonAn> list = new ArrayList<>();
       SQLiteDatabase sqLiteDatabase  = dbHelper.getReadableDatabase();
       Cursor cursor = sqLiteDatabase.rawQuery("select ama.idanhmonan,ama.mamon, ama.anhmon from  ANHMONAN as ama, MON as m " +
               "where m.mamon = ama.mamon  " +
               "and m.mamon = ?"
               ,new String[]{String.valueOf(idmamon)});
       if (cursor.getCount() !=0){
           cursor.moveToFirst();
           do{
               list.add(new CLAnhMonAn(cursor.getInt(0),
                       cursor.getInt(1),
                       cursor.getString(2)));
           }while (cursor.moveToNext());

       }
       return list;
    }
    public ArrayList<NguyenLieu>getClickItemngl(int idmamon){
        ArrayList<NguyenLieu> list = new ArrayList<>();
       SQLiteDatabase sqLiteDatabase  = dbHelper.getReadableDatabase();
       Cursor cursor = sqLiteDatabase.rawQuery("select nl.manguyenlieu,nl.tennguyenlieu,nl.anhnguyenlieu " +
               "from  NGUYENLIEU as nl, MON as m,CONGTHUCNGUYENLIEU as ct " +
               "where m.mamon = ct.mamon and ct.manguyenlieu = nl.manguyenlieu " +
               "and m.mamon = ?"
               ,new String[]{String.valueOf(idmamon)});
       if (cursor.getCount() !=0){
           cursor.moveToFirst();
           do{
               list.add(new NguyenLieu(cursor.getInt(0),
                       cursor.getString(1),
                       cursor.getString(2)));
           }while (cursor.moveToNext());

       }
       return list;
    }

    public ArrayList<BinhLuan>getClickItembinhuan(int idmamon){
        ArrayList<BinhLuan> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase  = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select bl.idbinhluan ,bl.mamon,bl.tendangnhap,bl.noidungbinhluan " +
                        "from  BINHLUAN as bl, MON as m,NGUOIDUNG as nd " +
                        "where m.mamon = bl.mamon and nd.tendangnhap = bl.tendangnhap " +
                        "and m.mamon = ? "
                        ,new String[]{String.valueOf(idmamon)});
        if (cursor.getCount() !=0){
            cursor.moveToFirst();
            do{
              list.add(new BinhLuan(cursor.getInt(0),
                      cursor.getInt(1),
                      cursor.getString(2),
                      cursor.getString(3)));
            }while (cursor.moveToNext());

        }
        return list;
    }




}
