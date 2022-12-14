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
                "idAma INTEGER ," +
                "mamon INTEGER," +
                "anhmon Text)";
        sqLiteDatabase.execSQL(dbAnhMonAN);

        String dbBinhLuan = "CREATE TABLE BINHLUAN (" +
                "idBl INTEGER ,  " +
                "mamon INTEGER, " +
                "tendangnhap TEXT, " +
                "noidungbl TEXT)";
        sqLiteDatabase.execSQL(dbBinhLuan);

        String dbCongThucNguyenLieu = "CREATE TABLE CONGTHUCNGUYENLIEU (" +
                "idctnl Integer  ," +
                "mamon INTEGER, " +
                "tennguyenlieu TEXT, " +
                "khoiluong TEXT)";
        sqLiteDatabase.execSQL(dbCongThucNguyenLieu);

        String dbLoaiMon = "CREATE TABLE LOAIMON (" +
                "maloai INTEGER  ," +
                "tenloai TEXT)";
        sqLiteDatabase.execSQL(dbLoaiMon);

        String dbMon = "CREATE TABLE MON (" +
                "mamon INTEGER  ," +
                "maloai INTEGER," +
                "tenmon TEXT," +
                "congthuclam TEXT," +
                "tgnau TEXT," +
                "dokho TEXT," +
                "anhmonlvo TEXT," +
                "cachlam Text)";
        sqLiteDatabase.execSQL(dbMon);

        String dbNguoiDung = "CREATE TABLE NGUOIDUNG (" +
                "tendangnhap TEXT  ," +
                "matkhau TEXT," +
                "sdt integer," +
                "email text," +
                "diachi text," +
                "tuoi integer)";
        sqLiteDatabase.execSQL(dbNguoiDung);
        sqLiteDatabase.execSQL("INSERT INTO NGUOIDUNG VALUES " +
                "('1', 'hieup',123123, 'hieup', 'hieup',100)," +
                "('2', 'test2',2, 'test2', 'test2',2)," +
                "('3', '3',3, '3', '3',3)," +
                "('4', '4',4, '4', '4',4)," +
                "('a', '1',1, '1', '1',1)," +
                "('abc', '123',113, 'phong113@gmail.com', 'q1',22)," +
                "('fas', '123',113, 'phong113@gmail.com', 'q1',22)," +
                "('hdidndb', '1',1, '1', '1','1')," +
                "('Hieupham', '1',348476512, 'hieu01648476512@gmail.com', 'TPHCM',23)," +
                "('jdbejdin', '1',1, '1', '1',1)," +
                "('Phong123', '1',865353251, 'phonghack02041999@gmail.com', 'tp.hcm',22)");

        String dbNguoiDungDB = "CREATE TABLE NGUOIDUNGDB (" +
                "idndb INTEGER , " +
                "mamon INTEGER," +
                "tennguoidung TEXT)";
        sqLiteDatabase.execSQL(dbNguoiDungDB);


        String dbNguoiDungSave = "CREATE TABLE NGUOIDUNGSAVE (" +
                "idnds INTEGER  ," +
                "mamon  INTEGER," +
                "tennguoidung TEXT)";
        sqLiteDatabase.execSQL(dbNguoiDungSave);


        String dbThongBao = "CREATE TABLE THONGBAO (" +
                "id_tb INTEGER ," +
                "tendangnhap TEXT," +
                "noidungthongbao TEXT   )";
        sqLiteDatabase.execSQL(dbThongBao);

        sqLiteDatabase.execSQL("INSERT INTO MON VALUES (" +
                "1 ,7 ,'Mực Ống Xào Măng Trúc', 'Mực Ống Xào Măng Trúc', '40 phút', 'Dễ','https://res.cloudinary.com/doluugxhe/image/upload/v1669553276/Cooking%20app/mucongxaomangtruc_o2lfxb.jpg','cachlam')," +
                "(2, 7, 'Ếch Xào Hoa Hẹ', 'Ếch Xào Hoa Hẹ', '40 phút', 'Dễ','https://res.cloudinary.com/doluugxhe/image/upload/v1669553276/Cooking%20app/mucongxaomangtruc_o2lfxb.jpg','cachlam')");

        sqLiteDatabase.execSQL("INSERT INTO LOAIMON VALUES (" +
                "4 ,'Khác'), " +
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
                "(134,1,'Mực ống','1 con'), " +
                "(135,1,'Măng Trúc','100gram')," +
                "(136,2,'Ếch','1 con'), " +
                "(137,2,'Hoa Hẹ','300gram')," +
                "(140,4, 'Đậu hũ', '1 miếng')," +
                "(143,5, 'Dưa chua', '600g')," +
                "(144, 6, 'Thạch', '700g'), " +
                "(146, 7, 'Kem', '900g')");

        sqLiteDatabase.execSQL("INSERT INTO BINHLUAN VALUES(1,1,'bao','naudoqua')");
//        sqLiteDatabase.execSQL("INSERT INTO NGUOIDUNG VALUES('bao','123',1,'','',1)");
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



