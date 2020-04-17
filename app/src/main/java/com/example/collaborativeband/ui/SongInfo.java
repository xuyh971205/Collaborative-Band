package com.example.collaborativeband.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.collaborativeband.R;

public class SongInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_info);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_songinfo);
        toolbar.inflateMenu(R.menu.toolbar_menu_without_search);


    }
}
