package com.example.cookingapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context){
        super(context, "DANGBAI", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String dbDangBai = "CREATE TABLE DANGBAI(tenmon text, loaimon text, thoigiannau text, dokho text, nguyenlieu1 text, khoiluong1 text, nguyenlieu2 text, khoiluong2 text, nguyenlieu3 text, khoiluong3 text, nguyenlieu4 text, khoiluong4 text, cachlam text)";
        db.execSQL(dbDangBai);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1){
            db.execSQL("DROP TABLE IF EXISTS DANGBAI");
            onCreate(db);
        }
    }
}
