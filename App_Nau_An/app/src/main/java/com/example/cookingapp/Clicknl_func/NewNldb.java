package com.example.cookingapp.Clicknl_func;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class NewNldb extends SQLiteOpenHelper {
    public NewNldb(Context context){super(context,"bd",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String newNL = "create table newNL( tennl text)";
        sqLiteDatabase.execSQL(newNL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists newNL");
        onCreate(sqLiteDatabase);
    }
}
