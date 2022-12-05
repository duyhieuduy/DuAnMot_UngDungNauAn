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

    public boolean insertCONGTHUCNGUYENLIEU(int idctnl,int mamon,String tennguyenlieu,String khoiluong){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idctnl", idctnl);
        contentValues.put("mamon", mamon);
        contentValues.put("tennguyenlieu", tennguyenlieu);
        contentValues.put("khoiluong", khoiluong);

        long check = database.insert("CONGTHUCNGUYENLIEU", null, contentValues);
        if (check == -1){
            return false;
        }
        return true;
    }
    public boolean insertBINHLUAN(int idBl,int mamon,String tendangnhap,String noidungbl){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idBl", idBl);
        contentValues.put("mamon", mamon);
        contentValues.put("tendangnhap", tendangnhap);
        contentValues.put("noidungbl", noidungbl);

        long check = database.insert("BINHLUAN", null, contentValues);
        if (check == -1){
            return false;
        }
        return true;
    }


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

    public boolean insertANHMONAN(int idAma,int mamon,String anhmon){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idAma", idAma);
        contentValues.put("mamon", mamon);
        contentValues.put("anhmon", anhmon);

        long check = database.insert("ANHMONAN", null, contentValues);
        if (check == -1){
            return false;
        }
        return true;
    }

    public boolean insertLOAIMON(int maloai,String tenloai){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maloai", maloai);
        contentValues.put("tenloai", tenloai);


        long check = database.insert("LOAIMON", null, contentValues);
        if (check == -1){
            return false;
        }
        return true;
    }

    public boolean insertMON(int mamon,int maloai,String tenmon,
                             String congthuclam,String tgnau
                            ,String dokho,String anhmonlvo,
                             String cachlam){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mamon", mamon);
        contentValues.put("maloai", maloai);
        contentValues.put("tenmon", tenmon);
        contentValues.put("congthuclam", congthuclam);
        contentValues.put("tgnau", tgnau);
        contentValues.put("dokho", dokho);
        contentValues.put("anhmonlvo", anhmonlvo);
        contentValues.put("cachlam", cachlam);


        long check = database.insert("MON", null, contentValues);
        if (check == -1){
            return false;
        }
        return true;
    }
    public boolean insertNGUOIDUNG(String tendangnhap,
                             String matkhau,int sdt
                            ,String email,String diachi,
                             int tuoi){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tendangnhap", tendangnhap);
        contentValues.put("matkhau", matkhau);
        contentValues.put("sdt", sdt);
        contentValues.put("email", email);
        contentValues.put("diachi", diachi);
        contentValues.put("tuoi", tuoi);


        long check = database.insert("NGUOIDUNG", null, contentValues);
        if (check == -1){
            return false;
        }
        return true;
    }

    public boolean insertNGUOIDUNGDB(int idndb,int mamon,String tennguoidung){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idndb", idndb);
        contentValues.put("mamon", mamon);
        contentValues.put("tennguoidung", tennguoidung);

        long check = database.insert("NGUOIDUNGDB", null, contentValues);
        if (check == -1){
            return false;
        }
        return true;
    }

    public boolean insertNGUOIDUNGSAVE(int idnds,int mamon,String tennguoidung){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idnds", idnds);
        contentValues.put("mamon", mamon);
        contentValues.put("tennguoidung", tennguoidung);

        long check = database.insert("NGUOIDUNGSAVE", null, contentValues);
        if (check == -1){
            return false;
        }
        return true;
    }






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

            sqLiteDatabase.delete("NGUOIDUNGDB", null, null);
            sqLiteDatabase.execSQL("delete  from " + "NGUOIDUNGDB");

            sqLiteDatabase.close();
        }
    }

