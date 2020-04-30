package com.example.collaborativeband.ui.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.collaborativeband.R;
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

        // Click on edit or delete in the toolbar menu.
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_edit:
                        //Toast.makeText(SongInfo.this, "action_edit", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SongInfo.this, editthesongActivity.class);
                        startActivity(intent);

                        break;

                    case R.id.action_delete:
                        //Toast.makeText(SongInfo.this, "action_delete", Toast.LENGTH_LONG).show();


                        break;

                    default:
                        break;
                }
                return true;

            }
        });


        // get data passed from the last activity by intent.
        Intent intent = getIntent();

        TextView singer = (TextView)findViewById(R.id.activity_song_info_singer);
        TextView time = (TextView)findViewById(R.id.activity_song_info_time);
        TextView style = (TextView)findViewById(R.id.activity_song_info_style);
        TextView language = (TextView)findViewById(R.id.activity_song_info_language);
        TextView song_key = (TextView)findViewById(R.id.activity_song_info_key);
        TextView instruments = (TextView)findViewById(R.id.activity_song_info_instruments);
        TextView note = (TextView)findViewById(R.id.activity_song_info_note);
        TextView prof = (TextView)findViewById(R.id.activity_song_info_practiced_times);

        String data;
        data = intent.getStringExtra("name");
        toolbar.setTitle(data);
        data = intent.getStringExtra("singer");
        singer.setText(data);
        data = intent.getStringExtra("time");
        time.setText(data);
        data = intent.getStringExtra("style");
        style.setText(data);
        data = intent.getStringExtra("language");
        language.setText(data);
        data = intent.getStringExtra("song_key");
        song_key.setText(data);
        data = intent.getStringExtra("instruments");
        instruments.setText(data);
        data = intent.getStringExtra("note");
        note.setText(data);

        int practiced_times;
        practiced_times = intent.getIntExtra("practiced", 0);
        prof.setText(String.valueOf(practiced_times));



    }
}
