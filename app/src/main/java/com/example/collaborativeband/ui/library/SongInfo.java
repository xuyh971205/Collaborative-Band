package com.example.collaborativeband.ui.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.collaborativeband.R;
import com.example.collaborativeband.database.CommonDatabase;
import com.example.collaborativeband.ui.SongRecognizing;
import com.example.collaborativeband.ui.addanewsong.addanewsongActivity;
import com.example.collaborativeband.ui.addanewsong.editthesongActivity;

public class SongInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_info);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_songinfo);
        toolbar.inflateMenu(R.menu.toolbar_menu_edit);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SongInfo.this.finish(); // Realize closing but not returning.
            }
        });


        // get data passed from the last activity by intent.
        Intent intent = getIntent();

        final TextView singer = (TextView)findViewById(R.id.activity_song_info_singer);
        final TextView time = (TextView)findViewById(R.id.activity_song_info_time);
        final TextView style = (TextView)findViewById(R.id.activity_song_info_style);
        final TextView language = (TextView)findViewById(R.id.activity_song_info_language);
        TextView song_key = (TextView)findViewById(R.id.activity_song_info_key);
        final TextView instruments = (TextView)findViewById(R.id.activity_song_info_instruments);
        final TextView note = (TextView)findViewById(R.id.activity_song_info_note);
        TextView prof = (TextView)findViewById(R.id.activity_song_info_practiced_times);

        final String mname, msinger, mstyle, mlanguage, mtime, mkey, minstruments, mnote;
        int practiced_times;

        // get data from intent
        mname = intent.getStringExtra("name");
        toolbar.setTitle(mname);

        msinger = intent.getStringExtra("singer");
        singer.setText(msinger);

        mtime = intent.getStringExtra("time");
        time.setText(mtime);

        mstyle = intent.getStringExtra("style");
        style.setText(mstyle);

        mlanguage = intent.getStringExtra("language");
        language.setText(mlanguage);

        mkey = intent.getStringExtra("song_key");
        song_key.setText(mkey);

        minstruments = intent.getStringExtra("instruments");
        instruments.setText(minstruments);

        mnote = intent.getStringExtra("note");
        note.setText(mnote);

        practiced_times = intent.getIntExtra("practiced", 0);
        prof.setText(String.valueOf(practiced_times));


        // Click on edit or delete in the toolbar menu.
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_edit:
                        //Toast.makeText(SongInfo.this, "action_edit", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SongInfo.this, editthesongActivity.class);

                        Bundle bundle = new Bundle();
                        bundle.putString("name", mname);
                        bundle.putString("singer", msinger);
                        bundle.putString("style", mstyle);
                        bundle.putString("language", mlanguage);
                        bundle.putString("time", mtime);
                        bundle.putString("song_key", mkey);
                        bundle.putString("instruments", minstruments);
                        bundle.putString("note", mnote);
                        intent.putExtras(bundle);

                        startActivity(intent);
                        break;

                    case R.id.action_delete:
                        //Toast.makeText(SongInfo.this, "action_delete", Toast.LENGTH_LONG).show();
                        final SQLiteDatabase db = CommonDatabase.getSqliteObject(SongInfo.this, "SongLibrary");

                        AlertDialog alertDialog2 = new AlertDialog.Builder(SongInfo.this)
                                .setTitle("Delete this song?")
                                //.setMessage("有多个按钮")
                                //.setIcon(R.mipmap.ic_launcher)
                                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        db.delete("Song", "name = ?", new String[] { mname });
                                        Toast.makeText(SongInfo.this, "Deleted.", Toast.LENGTH_SHORT).show();
                                        SongInfo.this.finish();
                                    }
                                })

                                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {//添加取消
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                })
                                .create();

                        alertDialog2.show();

                        break;

                    default:
                        break;
                }
                return true;

            }
        });


    }
}
