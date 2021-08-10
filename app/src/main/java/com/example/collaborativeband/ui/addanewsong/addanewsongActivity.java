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
import com.example.collaborativeband.database.MyDatabaseHelper;
import com.example.collaborativeband.ui.addanewplaylist.addanewplaylistActivity;
import com.example.collaborativeband.ui.library.SongInfo;

public class addanewsongActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addanewsong);

       
        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar_addanewsong);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addanewsongActivity.this.finish();
            }
        });

        // Hide the keyboard by clicking on anywhere outside EditViews.
        findViewById(R.id.addanewsong_parent_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.addanewsong_parent_layout) {
                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        });

        // Add song data into the table "Song" in the database "SongLibrary.db"
        final Button addaNewSong = (Button) findViewById(R.id.addanewsong_finish_button);
        addaNewSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = CommonDatabase.getSqliteObject(addanewsongActivity.this, "SongLibrary");
                ContentValues values = new ContentValues();

                EditText newSong_name = (EditText) findViewById(R.id.editText_newSong_name);
                EditText newSong_singer = (EditText) findViewById(R.id.editText_newSong_singer);
                EditText newSong_style = (EditText) findViewById(R.id.editText_newSong_style);
                EditText newSong_language = (EditText) findViewById(R.id.editText_newSong_language);
                EditText newSong_time = (EditText) findViewById(R.id.editText_newSong_time);
                EditText newSong_key = (EditText) findViewById(R.id.editText_newSong_key);
                EditText newSong_instruments = (EditText) findViewById(R.id.editText_newSong_instruments);
                EditText newSong_note = (EditText) findViewById(R.id.editText_newSong_note);

                // get input data from editText
                // NOTE: getText() method should be used "in" onClick(), otherwise it cannot get the text.
                String name = newSong_name.getText().toString();
                String singer = newSong_singer.getText().toString();
                String style = newSong_style.getText().toString();
                String language = newSong_language.getText().toString();
                String time = newSong_time.getText().toString();
                String key = newSong_key.getText().toString();
                String instruments = newSong_instruments.getText().toString();
                String note = newSong_note.getText().toString();

                // Build the data group, by using values.
                values.put("name", name);
                values.put("singer", singer);
                values.put("style", style);
                values.put("language", language);
                values.put("time", time);
                values.put("song_key", key);
                values.put("instruments", instruments);
                values.put("note", note);
                values.put("practiced", 0);

                // If finish adding a song...
                if((name.trim().length() != 0) && (note.trim().length() != 0)){
                    // Put the data group into the SongLibray.db database.
                    db.insert("Song", null, values);

                    // Jump to SongInfo page to display the new added song.
                    Intent intent = new Intent(addanewsongActivity.this, SongInfo.class);

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

                    Toast.makeText(addanewsongActivity.this,
                            "You have added a new song!", Toast.LENGTH_LONG).show();

                    addanewsongActivity.this.finish();
                }
                //
                else{
                    Toast.makeText(addanewsongActivity.this,
                            "You haven't finished adding a song.", Toast.LENGTH_SHORT).show();
                }




            }
        });








    }
}
