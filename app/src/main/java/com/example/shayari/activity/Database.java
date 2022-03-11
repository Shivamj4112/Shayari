package com.example.shayari.activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.shayari.Database1_Model;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    Context context;
    public Database(@Nullable Context context) {
        super(context, "Database1.db", null, 1);

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String que = "CREATE TABLE student(id INTEGER PRIMARY KEY AUTOINCREMENT,fullname TEXT ,contacts TEXT ,email TEXT ,course TEXT ,fees TEXT )";
        sqLiteDatabase.execSQL(que);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }
    public void InsertData(String fullname, String contacts, String email, String course, String fees){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("fullname",fullname);
        values.put("contacts",contacts);
        values.put("email",email);
        values.put("course",course);
        values.put("fees",fees);

        long data = db.insert("student",null,values);
        if (data == -1){
            Toast.makeText(context, "Data not inserted", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Data inserted", Toast.LENGTH_SHORT).show();
        }

    }

    List<Database1_Model> RetriveData(){

        List<Database1_Model> datalist = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        String que = "SELECT * FROM student";

        Cursor cursor = db.rawQuery(que,null);
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {

            int id = cursor.getInt(0);
            String fullname = cursor.getString(1);
            String contacts = cursor.getString(2);
            String email = cursor.getString(3);
            String course = cursor.getString(4);
            String fees = cursor.getString(5);

            Database1_Model data = new Database1_Model(id,fullname,contacts,email,course,fees);
            datalist.add(data);
            cursor.moveToNext();
        }

        return datalist;
    }

    void UpdateData(int id, String fullname, String contacts, String email, String course, String fees){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("fullname",fullname);
        values.put("contacts",contacts);
        values.put("email",email);
        values.put("course",course);
        values.put("fees",fees);

        long update = db.update("student",values,"id="+id,null);

        if (update == -1){
            Toast.makeText(context, "Data is not Updated", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Data Updated", Toast.LENGTH_SHORT).show();
        }

    }
    void DeleteData(int id){

        SQLiteDatabase db = getWritableDatabase();

        long update = db.delete("student","id="+id,null);

        if (update == -1){
            Toast.makeText(context, "Data is not Deleted", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Data Deleted", Toast.LENGTH_SHORT).show();
        }

    }

}
