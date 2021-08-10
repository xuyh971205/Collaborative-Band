package com.example.collaborativeband.ui.addanewsong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.collaborativeband.R;
import com.example.collaborativeband.database.CommonDatabase;
import com.example.collaborativeband.ui.library.SongInfo;

public class editthesongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_the_song);

        
        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar_editthesong);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editthesongActivity.this.finish();
            }
        });

        
        findViewById(R.id.editthesong_parent_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.editthesong_parent_layout) {
                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        });

        final SQLiteDatabase db = CommonDatabase.getSqliteObject(editthesongActivity.this, "SongLibrary");

        final EditText song_name = (EditText) findViewById(R.id.editText_newSong_name);
        final EditText song_singer = (EditText) findViewById(R.id.editText_newSong_singer);
        final EditText song_style = (EditText) findViewById(R.id.editText_newSong_style);
        final EditText song_language = (EditText) findViewById(R.id.editText_newSong_language);
        final EditText song_time = (EditText) findViewById(R.id.editText_newSong_time);
        final EditText song_key = (EditText) findViewById(R.id.editText_newSong_key);
        final EditText song_instruments = (EditText) findViewById(R.id.editText_newSong_instruments);
        final EditText song_note = (EditText) findViewById(R.id.editText_newSong_note);

        // get data passed from the last activity by intent.
        Intent intent = getIntent();

        String mname, msinger, mstyle, mlanguage, mtime, mkey, minstruments, mnote;
        // get input data from intent
        mname = intent.getStringExtra("name");
        song_name.setText(mname);

        msinger = intent.getStringExtra("singer");
        song_singer.setText(msinger);

        mtime = intent.getStringExtra("time");
        song_time.setText(mtime);

        mstyle = intent.getStringExtra("style");
        song_style.setText(mstyle);

        mlanguage = intent.getStringExtra("language");
        song_language.setText(mlanguage);

        mkey = intent.getStringExtra("song_key");
        song_key.setText(mkey);

        minstruments = intent.getStringExtra("instruments");
        song_instruments.setText(minstruments);

        mnote = intent.getStringExtra("note");
        song_note.setText(mnote);


        // Add song data into the table "Song" in the database "SongLibrary.db"
        Button addaNewSong = (Button) findViewById(R.id.addanewsong_finish_button);
        addaNewSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues values = new ContentValues();

                String name = song_name.getText().toString();
                String singer = song_singer.getText().toString();
                String style = song_style.getText().toString();
                String language = song_language.getText().toString();
                String time = song_time.getText().toString();
                String key = song_key.getText().toString();
                String instruments = song_instruments.getText().toString();
                String note = song_note.getText().toString();

                // Build the data group, by using values.
                values.put("name", name);
                values.put("singer", singer);
                values.put("style", style);
                values.put("language", language);
                values.put("time", time);
                values.put("song_key", key);
                values.put("instruments", instruments);
                values.put("note", note);

                // If finish adding a song...

                // Update the data group in the SongLibray.db database.
                db.update("Song", values, "name = ?",
                        new String[]{name});

                // Jump to SongInfo page to display the new added song.
                Intent intent = new Intent(editthesongActivity.this, SongInfo.class);

                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putString("singer", singer);
                bundle.putString("style", style);
                bundle.putString("language", language);
                bundle.putString("time", time);
                bundle.putString("song_key", key);
                bundle.putString("instruments", instruments);
                bundle.putString("note", note);
                bundle.putInt("practiced", 0);
                intent.putExtras(bundle);

                startActivity(intent);

                // Clear the "container" values.
                values.clear();

                Toast.makeText(editthesongActivity.this,
                        "Success editing!", Toast.LENGTH_SHORT).show();

                editthesongActivity.this.finish();


            }
        });



    }
}
