package com.example.cookingapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cookingapp.DB.DBHelper;
import com.example.cookingapp.model.NguyenLieu;

import java.util.ArrayList;

public class InsertDao {
    public DBHelper dbHelper;
    public InsertDao(Context context) {
        dbHelper = new DBHelper(context);
    }
//    public ArrayList<NguyenLieu> InsertNguyenLieu(int manguyenlieu,String tennguyenlieu,String anhnguyenlieu){
////        ArrayList<NguyenLieu> list = new ArrayList<>();
//        SQLiteDatabase sqLiteDatabase  = dbHelper.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("manguyenlieu",manguyenlieu);
//        contentValues.put("tennguyenlieu",tennguyenlieu);
//        contentValues.put("anhnguyenlieu",anhnguyenlieu);
//        sqLiteDatabase.insert("NGUYENLIEU",null,contentValues);
//       return ;
//    }

    public boolean InsertNguyenLieu(int manguyenlieu, String tennguyenlieu, String anhnguyenlieu) {
     //   ArrayList<NguyenLieu> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("manguyenlieu", manguyenlieu);
        contentValues.put("tennguyenlieu", tennguyenlieu);
        contentValues.put("anhnguyenlieu", anhnguyenlieu);
        long check = sqLiteDatabase.insert("NGUYENLIEU", null, contentValues);
        if (check == -1)
            return false;
        return true;
    }

<<<<<<< HEAD
//        public ArrayList<NguyenLieu> InsertMon () {
//            //ArrayList<NguyenLieu> list = new ArrayList<>();
//            SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
//            Cursor cursor = sqLiteDatabase.insert()
//        }
//        public ArrayList<NguyenLieu> InsertCongThucNguyenLieu () {
//            ArrayList<NguyenLieu> list = new ArrayList<>();
//            SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
//            Cursor cursor = sqLiteDatabase.insert()
//        }
//        public ArrayList<NguyenLieu> InsertLoaiMon () {
//            ArrayList<NguyenLieu> list = new ArrayList<>();
//            SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
//            Cursor cursor = sqLiteDatabase.insert()
//        }
//        public ArrayList<NguyenLieu> InsertBinhLuan () {
//            ArrayList<NguyenLieu> list = new ArrayList<>();
//            SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
//            Cursor cursor = sqLiteDatabase.insert()
//        }
//        public ArrayList<NguyenLieu> InsertAnhMonAn () {
//            ArrayList<NguyenLieu> list = new ArrayList<>();
//            SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
//            Cursor cursor = sqLiteDatabase.insert()
//        }
=======
        public ArrayList<NguyenLieu> InsertMon () {
            //ArrayList<NguyenLieu> list = new ArrayList<>();
            SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.insert()
        }
        public ArrayList<NguyenLieu> InsertCongThucNguyenLieu () {
            ArrayList<NguyenLieu> list = new ArrayList<>();
            SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.insert()
        }
        public ArrayList<NguyenLieu> InsertLoaiMon () {
            ArrayList<NguyenLieu> list = new ArrayList<>();
            SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.insert()
        }
        public ArrayList<NguyenLieu> InsertBinhLuan () {
            ArrayList<NguyenLieu> list = new ArrayList<>();
            SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.insert()
        }
        public ArrayList<NguyenLieu> InsertAnhMonAn () {
            ArrayList<NguyenLieu> list = new ArrayList<>();
            SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.insert()
        }
>>>>>>> parent of 7c2a5be (a)

//    public void deleteAll(){
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        db.delete(ANHMONAN,null,null);
//        db.execSQL("delete * from "+ ANHMONAN);
//        db.execSQL("ANHMONAN table" + ANHMONAN);
//        db.close();
//    }
        public void deleteAll () {
            SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
            sqLiteDatabase.delete("ANHMONAN", null, null);
            sqLiteDatabase.execSQL("delete  from " + "ANHMONAN");

            sqLiteDatabase.delete("BINHLUAN", null, null);
            sqLiteDatabase.execSQL("delete  from " + "BINHLUAN");

            sqLiteDatabase.delete("CONGTHUCNGUYENLIEU", null, null);
            sqLiteDatabase.execSQL("delete  from " + "CONGTHUCNGUYENLIEU");

            sqLiteDatabase.delete("LOAIMON", null, null);
            sqLiteDatabase.execSQL("delete  from " + "LOAIMON");

            sqLiteDatabase.delete("MON", null, null);
            sqLiteDatabase.execSQL("delete  from " + "MON");

            sqLiteDatabase.delete("NGUOIDUNGSAVE", null, null);
            sqLiteDatabase.execSQL("delete  from " + "NGUOIDUNGSAVE");

            sqLiteDatabase.delete("NGUYENLIEU", null, null);
            sqLiteDatabase.execSQL("delete  from " + "NGUYENLIEU");
            sqLiteDatabase.close();
        }
    }

