package com.example.cookingapp.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class db extends SQLiteOpenHelper {
    public db(Context context){super(context,"bd",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String newNL = "create table newNL(manl integer, tennl text,anhnl text)";
        sqLiteDatabase.execSQL(newNL);

        sqLiteDatabase.execSQL("insert into newNL values (1,'hieupro','https://res.cloudinary.com/doluugxhe/image/upload/v1668265730/Cooking%20app/1_rjnyq8.jpg')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists newNL");
        onCreate(sqLiteDatabase);
    }
}
