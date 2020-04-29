package com.example.collaborativeband.ui.addanewplaylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.collaborativeband.R;
import com.example.collaborativeband.database.CommonDatabase;
import com.example.collaborativeband.database.MyDatabaseHelper;
import com.example.collaborativeband.ui.library.Song;
import com.example.collaborativeband.ui.library.SongAdapter;

import java.util.ArrayList;
import java.util.List;

public class AddsongsActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;
    private List<Song> songList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addsongs);

        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar_addsongs);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddsongsActivity.this.finish();
            }
        });


        SQLiteDatabase db = CommonDatabase.getSqliteObject(this, "SongLibrary");

        Cursor cursor = db.query("Song", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                // Get data from db.
                String name = cursor.getString(cursor.getColumnIndex
                        ("name"));
                String singer = cursor.getString(cursor.getColumnIndex
                        ("singer"));

                // Print them out.
                Song song = new Song();
                song.setName(name);
                song.setSinger(singer);

                songList.add(song);

            } while (cursor.moveToNext());
        }
        cursor.close();

        //
        ListView listView = (ListView) findViewById(R.id.listview_SonglistForCreatingANewPlaylist);

        SongAdapter adapter = new SongAdapter(AddsongsActivity.this, R.layout.item_song, songList);
        listView.setAdapter(adapter);

    }
}
