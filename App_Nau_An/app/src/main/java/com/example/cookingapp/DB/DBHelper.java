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
                "idctnl Integer primary key autoincrement," +
                "mamon INTEGER, " +
                "manguyenlieu INTEGER, " +
                "khoiluong TEXT, " +
                "tennguyenlieu TEXT)";
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
                "tendangnhap TEXT PRIMARY KEY ," +
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


        String dbThongBao = "CREATE TABLE THONGBAO (" +
                "id_tb INTEGER PRIMARY KEY autoincrement," +
                "tendangnhap TEXT," +
                "noidungthongbao TEXT   )";
        sqLiteDatabase.execSQL(dbThongBao);

        sqLiteDatabase.execSQL("INSERT INTO MON VALUES (" +
                "1 ,7 ,'M???c ???ng X??o M??ng Tr??c', 'M???c ???ng X??o M??ng Tr??c', '40 ph??t', 'D???','https://res.cloudinary.com/doluugxhe/image/upload/v1669553276/Cooking%20app/mucongxaomangtruc_o2lfxb.jpg','cachlam')," +
                "(2, 7, '???ch X??o Hoa H???', '???ch X??o Hoa H???', '40 ph??t', 'D???','https://res.cloudinary.com/doluugxhe/image/upload/v1669553276/Cooking%20app/mucongxaomangtruc_o2lfxb.jpg','cachlam')");

        sqLiteDatabase.execSQL("INSERT INTO LOAIMON VALUES (" +
                "4 ,'kh??c'), " +
                "(15, 'M??n b??nh'), " +
                "(20, 'M??n b??n'), " +
                "(10, 'M??n canh'), " +
                "(11, 'M??n chay'), " +
                "(9, 'M??n chi??n'), " +
                "(14, 'M??n ch??o'), " +
                "(17, 'M??n ch??'), " +
                "(13, 'M??n cu???n'), " +
                "(12, 'M??n c??m'), " +
                "(6, 'M??n g???i'), " +
                "(18, 'M??n h???p'), " +
                "(8, 'M??n h???m'), " +
                "(2, 'M??n khai v???'), " +
                "(3, 'M??n kho'), " +
                "(21, 'M??n lu???c'), " +
                "(22, 'M??n l???u'), " +
                "(5, 'M??n n?????ng'), " +
                "(19, 'M??n rang'), " +
                "(7, 'M??n x??o'), " +
                "(1, 'Sinh t??? & gi???i kh??t'), " +
                "(16, 'Th???p c???m')");
        sqLiteDatabase.execSQL("INSERT INTO CONGTHUCNGUYENLIEU VALUES " +
                "(1,1,1,'1 con','M???c ???ng'), " +
                "(2,1,18,'100gram','M??ng Tr??c')," +
                "(3,2,2,'1 con','???ch'), " +
                "(4,2,19,'300gram','Hoa H???')");

        sqLiteDatabase.execSQL("INSERT INTO BINHLUAN VALUES(1,1,'bao','naudoqua')");
        sqLiteDatabase.execSQL("INSERT INTO NGUOIDUNG VALUES('bao','123')");
        sqLiteDatabase.execSQL("INSERT INTO ANHMONAN VALUES(1,1,'https://res.cloudinary.com/doluugxhe/image/upload/v1669565429/Cooking%20app/mucong_b8pjx0.jpg')");
        sqLiteDatabase.execSQL("INSERT INTO NGUOIDUNGDB VALUES(1,1,'bao') ");
        sqLiteDatabase.execSQL("INSERT INTO NGUOIDUNGSAVE VALUES(1,1,'bao')");

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
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS THONGBAO");
            onCreate(sqLiteDatabase);
        }
    }

}



