package com.example.collaborativeband.ui.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.collaborativeband.R;
import com.example.collaborativeband.ui.SongRecognizing;

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

        TextView singer = (TextView)findViewById(R.id.activity_song_info_singer);
        TextView time = (TextView)findViewById(R.id.activity_song_info_time);
        TextView style = (TextView)findViewById(R.id.activity_song_info_style);
        TextView language = (TextView)findViewById(R.id.activity_song_info_language);
        TextView song_key = (TextView)findViewById(R.id.activity_song_info_key);
        TextView instruments = (TextView)findViewById(R.id.activity_song_info_instruments);
        TextView note = (TextView)findViewById(R.id.activity_song_info_note);

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

    }
}
