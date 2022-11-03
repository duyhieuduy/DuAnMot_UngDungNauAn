package com.example.cookingapp.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Sqlite extends SQLiteOpenHelper {
    public static final String DB_NAME = "NAUANDB";
    public static final int VERSION = 1;
    public static final String CREATTABLE_LOAIMON = "create table LOAIMON" +
            "(maloai text primary key," +
            "tenloai text)";
    public static final String CREATTABLE_MON = "create table MON" +
            "(mamon text primary key," +
            "tenmon text ," +
            "maloai text ," +
            "congthuclam text)";
    public static final String CREATTABLE_ANHMONAN = "create table ANHMONAN" +
            "(anhmon text primary key," +
            "mamon text)";
    public static final String CREATTABLE_USER = "create table USER" +
            "(username text primary key ," +
            "password text)";

    public static final String CREATTABLE_THONGBAO = "create table THONGBAO" +
            "(username text  ," +
            "noidungtb text)";

    public static final String CREATTABLE_BINHLUAN = "create table BINHLUAN" +
            "(username text," +
            "mamon text," +
            "noidungbl text)";

    public static final String CREATTABLE_SAVE = "create table SAVE" +
            "(username text ," +
            "mamon text)";

    public static final String CREATTABLE_NGUYENLIEU = "create table NGUYENLIEU" +
            "(manguyenlieu text primary key ," +
            "tennguyenlieu text," +
            "anhnguyenlieu text)";
    public static final String CREATTABLE_CONGTHUCNGUYENLIEU = "create table CONGTHUCNGUYENLIEU" +
            "(mamon text ," +
            "manguyenlieu text," +
            "khoiluong text)";


    public static final String INSERT_LOAIMON ="insert into LOAIMON values" +
            "('maloaimon01','monchien')," +
            "('maloaimon02','monxao')," +
            "('maloaimon03','monluoc')";
    public static final String INSERT_MON ="insert into MON VALUES" +
            " ('mamon01','trung chien','maloaimon01','congthuclam01')," +
            "('mamon02','thit chien','maloaimon01','congthuclam02')," +
            "('mamon03','trung luoc','maloaimon03','congthuclam03')," +
            "('mamon04','thit xao','maloaimon02','congthuclam04')";
    public static final String INSERT_ANHMONAN ="insert into ANHMONAN VALUES" +
            "('anhmon01','mamon01')," +
            "('anhmon02','mamon01')," +
            "('anhmon03','mamon01')," +
            "('anhmon04','mamon01')," +
            "('anhmon05','mamon01')," +
            "('anhmon06','mamon02')," +
            "('anhmon07','mamon02')," +
            "('anhmon08','mamon02')," +
            "('anhmon09','mamon02')," +
            "('anhmon10','mamon02')," +
            "('anhmon11','mamon03')," +
            "('anhmon12','mamon03')," +
            "('anhmon13','mamon03')," +
            "('anhmon14','mamon03')," +
            "('anhmon15','mamon03')," +
            "('anhmon16','mamon04')," +
            "('anhmon17','mamon04')," +
            "('anhmon18','mamon04')," +
            "('anhmon19','mamon04')," +
            "('anhmon20','mamon04')";
    public static final String INSERT_USER ="insert into USER VALUES" +
            "('1','1')," +
            "('2','2')," +
            "('3','3')";
    public static final String INSERT_BINHLUAN ="insert into BINHLUAN VALUES" +
            "('1','mamon01','binh luan cua user 1 mamon01')," +
            "('2','mamon01','binh luan cua user 2 mamon01')," +
            "('3','mamon01','binh luan cua user 3 mamon01')," +
            "('1','mamon02','binh luan cua user 1 mamon02')" +
            "('2','mamon02','binh luan cua user 2 mamon02')," +
            "('3','mamon02','binh luan cua user 3 mamon02')," +
            "('1','mamon03','binh luan cua user 1 mamon03')," +
            "('2','mamon03','binh luan cua user 2 mamon03')," +
            "('3','mamon03','binh luan cua user 3 mamon03')";
    public static final String INSERT_THONGBAO ="insert into THONGBAO VALUES" +
            "('1','noidung1')," +
            "('2','noidung1')," +
            "('3','noidung1')";
    public static final String INSERT_SAVE ="insert into SAVE VALUES" +
            "('1','mamon01')," +
            "('2','mamon01')," +
            "('3','mamon01')";

    public static final String INSERT_NGUYENLIEU ="insert into NGUYENLIEU VALUES" +
            "('nguyenlieu01','trung',anhnguyenlieu01)," +
            "('nguyenlieu02','thit',anhnguyenlieu02)," +
            "('nguyenlieu03','rau',anhnguyenlieu03)";
    public static final String INSERT_CONGTHUCNGUYENLIEU ="insert into CONGTHUCNGUYENLIEU VALUES" +
            "('mamon01','manguyenlieu01')," +
            "('mamon01','manguyenlieu03')," +
            "('mamon02','manguyenlieu02')" +
            "('mamon02',manguyenlieu03)";
    public Sqlite(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATTABLE_LOAIMON);
        db.execSQL(CREATTABLE_MON);
        db.execSQL(CREATTABLE_ANHMONAN);
        db.execSQL(CREATTABLE_USER);
        db.execSQL(CREATTABLE_THONGBAO);
        db.execSQL(CREATTABLE_BINHLUAN);
        db.execSQL(CREATTABLE_SAVE);
        db.execSQL(CREATTABLE_NGUYENLIEU);
        db.execSQL(CREATTABLE_CONGTHUCNGUYENLIEU);

        db.execSQL(INSERT_LOAIMON);
        db.execSQL(INSERT_MON);
        db.execSQL(INSERT_ANHMONAN);
        db.execSQL(INSERT_USER);
        db.execSQL(INSERT_BINHLUAN);
        db.execSQL(INSERT_THONGBAO);
        db.execSQL(INSERT_SAVE);
        db.execSQL(INSERT_NGUYENLIEU);
        db.execSQL(INSERT_CONGTHUCNGUYENLIEU);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists LOAIMON");
        db.execSQL("drop table if exists MON");
        db.execSQL("drop table if exists ANHMONAN");
        db.execSQL("drop table if exists THONGBAO");
        db.execSQL("drop table if exists BINHLUAN");
        db.execSQL("drop table if exists NGUYENLIEU");
        db.execSQL("drop table if exists CONGTHUCNGUYENLIEU");
    }
}
