package com.example.cookingapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {
    public DB(Context context){
        super(context, "DANGBAI", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String dbDangBai = "CREATE TABLE DANGBAI(anhmon text, tenmon text, loaimon text, thoigiannau text, dokho text, nguyenlieu1 text, khoiluong1 text, nguyenlieu2 text, khoiluong2 text, nguyenlieu3 text, khoiluong3 text, nguyenlieu4 text, khoiluong4 text, cachlam text, anhcachlam1 text, anhcachlam2 text, anhcachlam3 text)";
        db.execSQL(dbDangBai);

        db.execSQL("INSERT INTO DANGBAI VALUES ('https://res.cloudinary.com/doluugxhe/image/upload/v1669553276/Cooking%20app/mucongxaomangtruc_o2lfxb.jpg','Mực Ống Xào Măng Trúc', 'Mon Xao', '40 phut', 'De', 'muc ong', '300g', 'mang truc', '400g','hanh la', '50g', 'muoi, duong, bot ngot', '1 muong ca phe','https://res.cloudinary.com/doluugxhe/image/upload/v1669553277/Cooking%20app/mucongxaomangtruc1_gc2obx.png' ,'https://res.cloudinary.com/doluugxhe/image/upload/v1669553277/Cooking%20app/mucongxaomangtruc2_oydrsz.png','https://res.cloudinary.com/doluugxhe/image/upload/v1669553276/Cooking%20app/mucongxaomangtruc_o2lfxb.jpg'),('https://res.cloudinary.com/doluugxhe/image/upload/v1669553276/Cooking%20app/mucongxaomangtruc_o2lfxb.jpg','Mực Ống Xào Măng Trúc', 'Mon Xao', '40 phut', 'De', 'muc ong', '300g', 'mang truc', '400g','hanh la', '50g', 'muoi, duong, bot ngot', '1 muong ca phe','https://res.cloudinary.com/doluugxhe/image/upload/v1669553277/Cooking%20app/mucongxaomangtruc1_gc2obx.png' ,'https://res.cloudinary.com/doluugxhe/image/upload/v1669553277/Cooking%20app/mucongxaomangtruc2_oydrsz.png','https://res.cloudinary.com/doluugxhe/image/upload/v1669553276/Cooking%20app/mucongxaomangtruc_o2lfxb.jpg'),('https://res.cloudinary.com/doluugxhe/image/upload/v1669553276/Cooking%20app/mucongxaomangtruc_o2lfxb.jpg','Mực Ống Xào Măng Trúc', 'Mon Xao', '40 phut', 'De', 'muc ong', '300g', 'mang truc', '400g','hanh la', '50g', 'muoi, duong, bot ngot', '1 muong ca phe','https://res.cloudinary.com/doluugxhe/image/upload/v1669553277/Cooking%20app/mucongxaomangtruc1_gc2obx.png' ,'https://res.cloudinary.com/doluugxhe/image/upload/v1669553277/Cooking%20app/mucongxaomangtruc2_oydrsz.png','https://res.cloudinary.com/doluugxhe/image/upload/v1669553276/Cooking%20app/mucongxaomangtruc_o2lfxb.jpg')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1){
            db.execSQL("DROP TABLE IF EXISTS DANGBAI");
            onCreate(db);
        }
    }
}
