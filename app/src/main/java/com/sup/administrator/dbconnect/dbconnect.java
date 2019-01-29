package com.sup.administrator.dbconnect;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 1/29/2019.
 */
public class dbconnect extends SQLiteOpenHelper {
    public static final String dbname = "mydb.db";
    public static final String tablename = "studreg";
    public static final String col1 = "id";
    public static final String col2 = "name";
    public static final String col3 = "rollno";
    public static final String col4 = "adno";
    public static final String col5 = "college";

    public dbconnect(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table " +tablename+"("+col1+ " integer primary key autoincrement, "+col2+ " text, "+col3+ " text, "+col4+ " text, "+col5+ " text)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "drop table if exists " +tablename;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);

    }

    public boolean insert(String name, String rollno, String adno, String college) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2, name);
        contentValues.put(col3, rollno);
        contentValues.put(col4, adno);
        contentValues.put(col5, college);
        long status = sqLiteDatabase.insert(tablename, null, contentValues);
        if(status == -1) {
            return false;

        } else {
            return true;
        }
    }
}