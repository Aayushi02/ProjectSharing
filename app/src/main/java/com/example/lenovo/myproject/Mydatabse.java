package com.example.lenovo.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lenovo on 24-06-2017.
 */
public class Mydatabse extends SQLiteOpenHelper {
    public static final String Name = "Project.db";
    public static String Table_name =new String();
    // public static final String col1 = "Project_id";
    public static final String col2 = "Project_name";
    public static final String col3 = "Project_desc";

    public Mydatabse(Context context, String table_name) {
        super(context,table_name , null, 1);
        Table_name = table_name;
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table " + Table_name + " (Project_name TEXT UNIQUE ,Project_desc Text) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + Table_name);
        onCreate(db);

    }
    public boolean insert_data(String name,String desc){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col2, name);
        cv.put(col3, desc);

        long result = db.insertWithOnConflict(Table_name,null,cv,SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res= db.rawQuery("select * from "+Table_name,null);
        return  res;
    }
}
