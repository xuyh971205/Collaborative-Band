package com.example.collaborativeband.ui.addanewsong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.collaborativeband.R;
import com.example.collaborativeband.database.MyDatabaseHelper;
import com.example.collaborativeband.ui.addanewplaylist.addanewplaylistActivity;

public class addanewsongActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addanewsong);

        // finish this activity by clicking on the close button.
        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar_addanewsong);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addanewsongActivity.this.finish();
            }
        });

        // Create the database SongLibrary.db, without clicking on anything.
        dbHelper = new MyDatabaseHelper(this, "SongLibrary.db", null, 1);
        dbHelper.getWritableDatabase();

        // Add song data into the table "Song" in the database "SongLibrary.db"
        Button addaNewSong = (Button) findViewById(R.id.addanewsong_finish_button);
        addaNewSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();

                EditText newSong_name = (EditText) findViewById(R.id.editText_newSong_name);
                EditText newSong_style = (EditText) findViewById(R.id.editText_newSong_style);
                EditText newSong_language = (EditText) findViewById(R.id.editText_newSong_language);
                EditText newSong_time = (EditText) findViewById(R.id.editText_newSong_time);
                EditText newSong_key = (EditText) findViewById(R.id.editText_newSong_key);
                EditText newSong_instruments = (EditText) findViewById(R.id.editText_newSong_instruments);
                EditText newSong_note = (EditText) findViewById(R.id.editText_newSong_note);

                // get input data from editText
                // NOTE: getText() method should be used "in" onClick(), otherwise it cannot get the text.
                String name = newSong_name.getText().toString();
                String style = newSong_style.getText().toString();
                String language = newSong_language.getText().toString();
                String time = newSong_time.getText().toString();
                String key = newSong_key.getText().toString();
                String instruments = newSong_instruments.getText().toString();
                String note = newSong_note.getText().toString();

                // Build the data group, by using values.
                values.put("name", name);
                values.put("style", style);
                values.put("language", language);
                values.put("time", time);
                values.put("song_key", key);
                values.put("instruments", instruments);
                values.put("note", note);
                values.put("practiced", 0);

                // Put the data group in the values into the database.
                db.insert("Song", null, values);

                // Clear the "container"-- values.
                values.clear();
            }
        });






    }
}
