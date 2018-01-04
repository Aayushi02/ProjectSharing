package com.example.lenovo.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Lenovo on 19-06-2017.
 */


public class Database_projects extends SQLiteOpenHelper {
    public static final String Name = "Project.db";
    public static final String Table_name = "Project_Info";
    public static final String col1 = "Project_name";
    public static final String col2 = "Project_desc";
    public Database_projects(Context context) {
        super(context, Table_name, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table " + Table_name + " (Project_name TEXT PRIMARY KEY,Project_desc Text) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + Table_name);
        onCreate(db);

    }
    public boolean insert_data(String name, String desc) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col1, name);
        cv.put(col2, desc);
        long result = db.insert(Table_name,null,cv);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
   /* public ArrayList<String> ViewProjectName(){
        ArrayList<String> name = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select Project_name from " + Table_name;
        Cursor r = db.rawQuery(query, null);
        if (r.moveToFirst()) {
            do {
               name.add(r.getString(0));


            } while (r.moveToNext());
        }
        return name;
    }
    public ArrayList<String> ViewProjectInfo(){
        ArrayList<String> desc = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select Project_desc from " + Table_name;
        Cursor r = db.rawQuery(query, null);
        if (r.moveToFirst()) {
            do {
                desc.add(r.getString(0));


            } while (r.moveToNext());
        }
        return desc;
    }*/
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res= db.rawQuery("select * from "+Table_name,null);
        return  res;
    }
}

