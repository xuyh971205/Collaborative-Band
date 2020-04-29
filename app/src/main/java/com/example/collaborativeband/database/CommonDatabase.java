package com.example.collaborativeband.database;

/**
 *  A common dbHelper allowing all activities to use the same database.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class CommonDatabase {

    public static SQLiteDatabase getSqliteObject(Context context, String db_name){
        //private DBHelper dbHelper;
        MyDatabaseHelper dbHelper;
        SQLiteDatabase sqlite;

        dbHelper = new MyDatabaseHelper(context, db_name,null,1);
        sqlite = dbHelper.getWritableDatabase();
        return sqlite;
    }

}
