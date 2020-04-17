package com.example.collaborativeband.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.example.collaborativeband.R;

public class SongRecognizing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_recognizing);

        // The close button on the toolbar
        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar_songrecognizing);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent_1;
                intent_1 = new Intent(addanewplaylistActivity.this, MainActivity.class);
                startActivity(intent_1);*/
                SongRecognizing.this.finish(); // Realize closing but not returning.
            }
        });




    }
}
