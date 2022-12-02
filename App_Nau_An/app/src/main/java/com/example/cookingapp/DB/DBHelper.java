package com.example.cookingapp.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "MONANVIETNAM", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String dbAnhMonAN = "CREATE TABLE ANHMONAN ( " +
                "idanhmonan INTEGER PRIMARY KEY," +
                "mamon INTEGER,anhmon Text)";
        sqLiteDatabase.execSQL(dbAnhMonAN);

        String dbBinhLuan = "CREATE TABLE BINHLUAN (" +
                "idbinhluan INTEGER PRIMARY KEY,  " +
                "mamon INTEGER, tendangnhap TEXT, " +
                "noidungbinhluan TEXT)";
        sqLiteDatabase.execSQL(dbBinhLuan);

        String dbCongThucNguyenLieu = "CREATE TABLE CONGTHUCNGUYENLIEU (" +
                "mamon INTEGER, " +
                "manguyenlieu INTEGER, " +
                "khoiluong TEXT)";
        sqLiteDatabase.execSQL(dbCongThucNguyenLieu);

        String dbLoaiMon = "CREATE TABLE LOAIMON (" +
                "maloai INTEGER PRIMARY KEY autoincrement," +
                "tenloai TEXT)";
        sqLiteDatabase.execSQL(dbLoaiMon);

        String dbMon = "CREATE TABLE MON (" +
                "mamon INTEGER PRIMARY KEY autoincrement," +
                "maloai INTEGER," +
                "tenmon TEXT," +
                "congthuclam TEXT," +
                "thoigiannau TEXT," +
                "dokho TEXT," +
                "anhmon TEXT," +
                "cachlam Text)";
        sqLiteDatabase.execSQL(dbMon);

        String dbNguoiDung = "CREATE TABLE NGUOIDUNG (" +
                "tendangnhap TEXT PRIMARY KEY autoincrement," +
                "matkhau TEXT)";
        sqLiteDatabase.execSQL(dbNguoiDung);

        String dbNguoiDungDB = "CREATE TABLE NGUOIDUNGDB (" +
                "idnguoidungdb INTEGER PRIMARY KEY, " +
                "mamon INTEGER," +
                "tendangnhap TEXT)";
        sqLiteDatabase.execSQL(dbNguoiDungDB);

        String dbNguoiDungSave = "CREATE TABLE NGUOIDUNGSAVE (" +
                "idnguoidungsave INTEGER PRIMARY KEY," +
                "mamon  INTEGER," +
                "tendangnhap TEXT)";
        sqLiteDatabase.execSQL(dbNguoiDungSave);

        String dbNguyenLieu = "CREATE TABLE NGUYENLIEU ( " +
                "manguyenlieu  INTEGER PRIMARY KEY autoincrement, " +
                "tennguyenlieu TEXT," +
                "anhnguyenlieu TEXT)";
        sqLiteDatabase.execSQL(dbNguyenLieu);

        String dbThongBao = "CREATE TABLE THONGBAO (" +
                "id_tb INTEGER PRIMARY KEY autoincrement," +
                "tendangnhap TEXT," +
                "noidungthongbao TEXT   )";
        sqLiteDatabase.execSQL(dbThongBao);

        sqLiteDatabase.execSQL("INSERT INTO MON VALUES (" +
                "1 ,7 ,'Mực Ống Xào Măng Trúc', 'Mực Ống Xào Măng Trúc', '40 phút', 'dễ','https://res.cloudinary.com/doluugxhe/image/upload/v1669553276/Cooking%20app/mucongxaomangtruc_o2lfxb.jpg','cachlam')," +
                "(2, 7, 'Ếch Xào Hoa Hẹ', 'Ếch Xào Hoa Hẹ', '40 phút', 'dễ','https://res.cloudinary.com/doluugxhe/image/upload/v1669553276/Cooking%20app/mucongxaomangtruc_o2lfxb.jpg','cachlam')");

        sqLiteDatabase.execSQL("INSERT INTO LOAIMON VALUES (" +
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
        sqLiteDatabase.execSQL("INSERT INTO CONGTHUCNGUYENLIEU VALUES " +
                "(1,1,'1 con'), " +
                "(1,18,'100gram')," +
                "(2,2,'1 con'), " +
                "(2,19,'300gram')");
        sqLiteDatabase.execSQL("INSERT INTO NGUYENLIEU VALUES " +
                "(1,'muc ong','https://res.cloudinary.com/doluugxhe/image/upload/v1669565429/Cooking%20app/mucong_b8pjx0.jpg'), " +
                "(18,'mang truc','https://res.cloudinary.com/doluugxhe/image/upload/v1669565974/Cooking%20app/mangtruc_fz2b5n.jpg')," +
                "(2,'ech','https://res.cloudinary.com/doluugxhe/image/upload/v1669565476/Cooking%20app/ech_zv2f4v.jpg'), " +
                "(19,'hoa he','https://res.cloudinary.com/doluugxhe/image/upload/v1669566138/Cooking%20app/hoahe_okuzyg.jpg')");

        sqLiteDatabase.execSQL("INSERT INTO BINHLUAN VALUES(1,1,'bao','naudoqua')");
        sqLiteDatabase.execSQL("INSERT INTO NGUOIDUNG VALUES('bao','123')");
        sqLiteDatabase.execSQL("INSERT INTO ANHMONAN VALUES(1,1,'https://res.cloudinary.com/doluugxhe/image/upload/v1669565429/Cooking%20app/mucong_b8pjx0.jpg')");
        sqLiteDatabase.execSQL("INSERT INTO NGUOIDUNGDB VALUES(1,1,'bao') ");
        sqLiteDatabase.execSQL("INSERT INTO NGUOIDUNGSAVE VALUES(1,1,'bao','đã lưu')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i != i1){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ANHMONAN");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS BINHLUAN");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS CONGTHUCNGUYENLIEU");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LOAIMON");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS MON");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS NGUOIDUNG");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS NGUOIDUNGDB");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS NGUOIDUNGSAVE");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS NGUYENLIEU");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS THONGBAO");
            onCreate(sqLiteDatabase);
        }
    }

}



