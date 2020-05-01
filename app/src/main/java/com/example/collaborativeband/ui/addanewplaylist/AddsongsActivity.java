package com.example.collaborativeband.ui.addanewplaylist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.collaborativeband.R;
import com.example.collaborativeband.database.CommonDatabase;
import com.example.collaborativeband.database.MyDatabaseHelper;
import com.example.collaborativeband.ui.library.Song;

import java.util.ArrayList;
import java.util.List;

public class AddsongsActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;
    private List<Song> songList = new ArrayList<>();
    private ListView listView;
    Adapter adapter;

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

                // Display them on each item in the ListView
                Song song = new Song();
                song.setName(name);
                song.setSinger(singer);

                songList.add(song);

            } while (cursor.moveToNext());
        }
        cursor.close();

        //
        listView = (ListView) findViewById(R.id.listview_SonglistForCreatingANewPlaylist);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        //
        //adapter = new Adapter(AddsongsActivity.this, R.layout.item_song, songList);
        adapter = new Adapter();

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();

                boolean isChecked = checkedItemPositions.get(position);


                // Reload the listView after clicking on an item.
                adapter.notifyDataSetChanged();

                /*Toast.makeText(AddsongsActivity.this, "item " +
                        position + " isChecked=" + isChecked, Toast.LENGTH_SHORT).show();*/

            }
        });

    }




    public class Adapter extends BaseAdapter {
        private int resourceId;

        @Override
        public int getCount() {

            return songList.size();
        }

        @Override
        public Object getItem(int position) {

            return songList.get(position);
        }

        @Override
        public long getItemId(int position) {

            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view;
            ViewHolder viewHolder;

            if (convertView == null) {

                viewHolder = new ViewHolder();
                convertView = View.inflate(AddsongsActivity.this, R.layout.item_song, null);
                viewHolder.songImage = (ImageView) convertView.findViewById (R.id.item_song_image);
                viewHolder.songName = (TextView) convertView.findViewById (R.id.item_song_name);
                viewHolder.songSinger = (TextView) convertView.findViewById (R.id.item_song_singer);
                viewHolder.songProf = (Button) convertView.findViewById(R.id.item_song_proficiency);
                convertView.setTag(viewHolder); // store viewHolder in view
            }
            else {

                viewHolder = (ViewHolder) convertView.getTag(); // get viewHolder again
            }

            viewHolder.songImage.setImageResource(songList.get(position).getImgId());
            viewHolder.songName.setText(songList.get(position).getName());
            viewHolder.songSinger.setText(songList.get(position).getSinger());

            if(songList.get(position).getProf() == 0){
                viewHolder.songProf.setBackgroundResource(R.drawable.background_grade1);
            }
            if(songList.get(position).getProf() == 1){
                viewHolder.songProf.setBackgroundResource(R.drawable.background_grade2);
            }
            if(songList.get(position).getProf() == 2){
                viewHolder.songProf.setBackgroundResource(R.drawable.background_grade3);
            }
            if(songList.get(position).getProf() == 3){
                viewHolder.songProf.setBackgroundResource(R.drawable.background_grade4);
            }
            if(songList.get(position).getProf() == 4){
                viewHolder.songProf.setBackgroundResource(R.drawable.background_grade5);
            }
            if(songList.get(position).getProf() > 4){
                viewHolder.songProf.setBackgroundResource(R.drawable.splash_background_gradient);
            }

            // Song item is selected...
            if(listView.isItemChecked(position)) {
                convertView.setBackgroundResource(R.drawable.selected_item_background);
            }
            // Song item is clicked to unselected...
            else {
                convertView.setBackgroundColor(Color.TRANSPARENT);
            }

            return convertView;
        }


        public class ViewHolder {
            ImageView songImage;
            TextView songName;
            TextView songSinger;
            Button songProf;
        }

    }



}
