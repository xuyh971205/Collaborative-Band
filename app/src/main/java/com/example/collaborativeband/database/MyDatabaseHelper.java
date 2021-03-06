package com.example.collaborativeband.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_LIBRARY = "create table Song ("
            + "id integer primary key autoincrement, "
            + "name text, "
            + "singer text,"
            + "style text, "
            + "language text, "
            + "time text, "
            + "song_key text, "
            + "instruments text, "
            + "note text,"
            + "practiced number, "
            + "full_path text)";

    public static final String CREATE_PLAYLISTS = "create table Playlists("
            + "id integer primary key autoincrement, "
            + "name text, "
            + "date date, "
            + "start_at time, "
            + "end_at time, "
            + "location text, "
            + "note text, "
            + "songs text)";


    private Context mContext;
    public MyDatabaseHelper(Context context, String name,
                            SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_LIBRARY);
        Toast.makeText(mContext, "Create library succeeded", Toast.LENGTH_SHORT).show();

        db.execSQL(CREATE_PLAYLISTS);
        Toast.makeText(mContext, "Create library succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


}
