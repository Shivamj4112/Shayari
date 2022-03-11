package com.example.shayari;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    Context context;
    public Database(@Nullable Context context) {
        super(context, "Mydata.db", null, 1);

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String que = "CREATE TABLE student(INTEGER id PRIMARY KEY AUTOINCREMENT,TEXT name,TEXT surname)";
        db.execSQL(que);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
