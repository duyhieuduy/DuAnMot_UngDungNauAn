package com.example.cookingapp.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context){
        super(context, "MONANVIETNAM", null, 2);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String dbAnhMonAN = "CREATE TABLE ANHMONAN ( " +
                "id_anhmonan INTEGER PRIMARY KEY," +
                "mamon INTEGER,anhmon BLOB)";
        db.execSQL(dbAnhMonAN);

        String dbBinhLuan = "CREATE TABLE BINHLUAN (" +
                "id_binhluan INTEGER PRIMARY KEY,  " +
                "mamon INTEGER, tendangnhap TEXT, " +
                "noidungbinhluan TEXT)";
        db.execSQL(dbBinhLuan);

        String dbCongThucNguyenLieu = "CREATE TABLE CONGTHUCNGUYENLIEU (" +
                "id_congthucnguyenlieu INTEGER PRIMARY KEY, " +
                "mamon INTEGER, " +
                "manguyenlieu INTEGER, " +
                "khoiluong TEXT)";
        db.execSQL(dbCongThucNguyenLieu);

        String dbLoaiMon = "CREATE TABLE LOAIMON (" +
                "maloai INTEGER PRIMARY KEY," +
                "tenloai TEXT)";
        db.execSQL(dbLoaiMon);

        db.execSQL("INSERT INTO LOAIMON VALUES (" +
                "4 ,'khác'), " +
                "(15, 'Món bánh'), " +
                "(20, 'Món bún'), " +
                "(10, 'Món canh'), " +
                "(11, 'Món chay'), " +
                "(9, 'Món chiên'), " +
                "(14, 'Món cháo'), " +
                "(17, 'Món chè'), " +
                "(13, 'Món cuốn'), " +
                "(12, 'Món cơm'), " +
                "(6, 'Món gỏi'), " +
                "(18, 'Món hấp'), " +
                "(8, 'Món hầm'), " +
                "(2, 'Món khai vị'), " +
                "(3, 'Món kho'), " +
                "(21, 'Món luộc'), " +
                "(22, 'Món lẩu'), " +
                "(5, 'Món nướng'), " +
                "(19, 'Món rang'), " +
                "(7, 'Món xào'), " +
                "(1, 'Sinh tố & giải khát'), " +
                "(16, 'Thập cẩm')");


        String dbMon = "CREATE TABLE MON (" +
                "mamon INTEGER PRIMARY KEY," +
                "maloai INTEGER," +
                "tenmon TEXT," +
                "congthuclam TEXT," +
                "thoigiannau TEXT," +
                "dokho TEXT)";
        db.execSQL(dbMon);

        db.execSQL("INSERT INTO MON VALUES (" +
                "1 ,7 ,'Mực Ống Xào Măng Trúc', 'Mực Ống Xào Măng Trúc', '40 phút', 'dễ')," +
                "(2, 7, 'Ếch Xào Hoa Hẹ', 'Ếch Xào Hoa Hẹ', '40 phút', 'dễ'),(3, 4, 'abc', 'acb', 'adad', 'adacac')");

        String dbNguoiDung = "CREATE TABLE NGUOIDUNG (" +
                "tendangnhap TEXT PRIMARY KEY," +
                "matkhau TEXT)";
        db.execSQL(dbNguoiDung);

        String dbNguoiDungDB = "CREATE TABLE NGUOIDUNGDB (" +
                "id_nguoidungdb INTEGER PRIMARY KEY, " +
                "mamon INTEGER," +
                "tendangnhap TEXT)";
        db.execSQL(dbNguoiDungDB);

        String dbNguoiDungSave = "CREATE TABLE NGUOIDUNGSAVE (" +
                "id_nguoidungsave INTEGER PRIMARY KEY," +
                "mamon  INTEGER," +
                "tendangnhap TEXT, " +
                "trangthai TEXT)";
        db.execSQL(dbNguoiDungSave);

        String dbNguyenLieu = "CREATE TABLE NGUYENLIEU ( " +
                "manguyenlieu  INTEGER PRIMARY KEY, " +
                "tennguyenlieu TEXT," +
                "anhnguyenlieu BLOB)";
        db.execSQL(dbNguyenLieu);

        String dbThongBao = "CREATE TABLE THONGBAO (" +
                "id_tb INTEGER PRIMARY KEY," +
                "tendangnhap TEXT," +
                "noidungthongbao TEXT   )";
        db.execSQL(dbThongBao);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1){
            db.execSQL("DROP TABLE IF EXISTS ANHMONAN");
            db.execSQL("DROP TABLE IF EXISTS BINHLUAN");
            db.execSQL("DROP TABLE IF EXISTS CONGTHUCNGUYENLIEU");
            db.execSQL("DROP TABLE IF EXISTS LOAIMON");
            db.execSQL("DROP TABLE IF EXISTS MON");
            db.execSQL("DROP TABLE IF EXISTS NGUOIDUNG");
            db.execSQL("DROP TABLE IF EXISTS NGUOIDUNGDB");
            db.execSQL("DROP TABLE IF EXISTS NGUOIDUNGSAVE");
            db.execSQL("DROP TABLE IF EXISTS NGUYENLIEU");
            db.execSQL("DROP TABLE IF EXISTS THONGBAO");
        }
    }
}
