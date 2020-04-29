package com.example.collaborativeband.ui.playlists;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.example.collaborativeband.R;
import com.example.collaborativeband.ui.library.SongInfo;

public class PlaylistInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_info);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_playlistinfo);
        toolbar.inflateMenu(R.menu.toolbar_menu_edit);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlaylistInfo.this.finish(); // Realize closing but not returning.
            }
        });

    }
}
