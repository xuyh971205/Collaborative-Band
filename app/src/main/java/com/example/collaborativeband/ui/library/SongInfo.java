package com.example.collaborativeband.ui.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
        String data = intent.getStringExtra("name");



    }
}
