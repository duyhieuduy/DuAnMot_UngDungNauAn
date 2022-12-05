package com.example.cookingapp.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cookingapp.model.BinhLuan;
import com.example.cookingapp.model.CLAnhMonAn;
import com.example.cookingapp.model.FooddetailModel;
import com.example.cookingapp.model.LOAIMONmodel;
import com.example.cookingapp.model.NguyenLieu;
import com.example.cookingapp.model.Tennguyenlieu;
import com.example.cookingapp.DB.DBHelper;
import com.example.cookingapp.model.FoodInFor;

import java.util.ArrayList;

public class GetAllDAO {
    public DBHelper dbHelper;
    public GetAllDAO(Context context){
        dbHelper = new DBHelper(context);
    }

    public ArrayList<FoodInFor> getAll(){
        ArrayList<FoodInFor> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select m.mamon,m.tenmon,m.dokho,m.tgnau,m.anhmonlvo" +
                " from MON as m",null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new FoodInFor(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        gettennltheoidmon(cursor.getInt(0))));
            }while (cursor.moveToNext());
        }
        return list;
    }
    public ArrayList<Tennguyenlieu> gettennltheoidmon(int idmon){
        ArrayList<Tennguyenlieu> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select ctnl.tennguyenlieu" +
                " from CONGTHUCNGUYENLIEU as ctnl, MON as m " +
                " where m.mamon = ctnl.mamon" +
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
       Cursor cursor = sqLiteDatabase.rawQuery("select MON.mamon,MON.anhmonlvo,MON.tenmon,Mon.tgnau, MON.congthuclam, MON.cachlam " +
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
                       cursor.getString(5),
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
       Cursor cursor = sqLiteDatabase.rawQuery("select ama.idAma,ama.mamon, ama.anhmon from  ANHMONAN as ama, MON as m " +
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
       Cursor cursor = sqLiteDatabase.rawQuery("select nl.tennguyenlieu " +
               "from   MON as m,CONGTHUCNGUYENLIEU as nl " +
               "where m.mamon = nl.mamon " +
               "and m.mamon = ?"
               ,new String[]{String.valueOf(idmamon)});
       if (cursor.getCount() !=0){
           cursor.moveToFirst();
           do{
               list.add(new NguyenLieu(cursor.getString(0)));
           }while (cursor.moveToNext());

       }
       return list;
    }

    public ArrayList<BinhLuan>getClickItembinhuan(int idmamon){
        ArrayList<BinhLuan> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase  = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select bl.idBl ,bl.mamon,bl.tendangnhap,bl.noidungbl " +
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
//
//    public ArrayList<>getNGUOIDUNGSAVE(int idmonan){
//        ArrayList<> list = new ArrayList();
//        SQLiteDatabase sqLiteDatabase  = dbHelper.getReadableDatabase();
//        Cursor cursor = sqLiteDatabase.rawQuery();
//    }
//

    public ArrayList<LOAIMONmodel> getAlllm(){
        ArrayList<LOAIMONmodel> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select Distinct maloai,tenloai from loaimon",null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new LOAIMONmodel(cursor.getInt(0),
                        cursor.getString(1)));
            }while (cursor.moveToNext());
        }
        return list;
    }


    public ArrayList<NguyenLieu> getAllnl(){
        ArrayList<NguyenLieu> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select DISTINCT tennguyenlieu from CONGTHUCNGUYENLIEU",null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new NguyenLieu(cursor.getString(0)));
            }while (cursor.moveToNext());
        }
        return list;
    }





}