package com.example.collaborativeband.ui.library;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.collaborativeband.R;
import com.example.collaborativeband.database.CommonDatabase;
import com.example.collaborativeband.ui.addanewsong.addanewsongActivity;

import java.util.ArrayList;
import java.util.List;

public class LibraryFragment extends Fragment {

    private LibraryViewModel libraryViewModel;
    private List<Song> songList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        libraryViewModel =
                ViewModelProviders.of(this).get(LibraryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_library, container, false);

        /*final TextView textView = root.findViewById(R.id.text_library);
        libraryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        return root;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Clicking on the add button to add a new song into library.
        Button btn1;
        btn1 = getActivity().findViewById(R.id.button_add_song);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // The getActivity() realized setOnClickListener() in a fragment, instead of only in an activity.
                // In MainActivity.java, getActivity() here will be replaced by MainActivity.this.
                Intent intent_1 = new Intent(getActivity(), addanewsongActivity.class);
                startActivity(intent_1);
            }
        });


        SQLiteDatabase db = CommonDatabase.getSqliteObject(getActivity(), "SongLibrary");

        Cursor cursor = db.query("Song", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                // Get data from db.
                String name = cursor.getString(cursor.getColumnIndex
                        ("name"));
                String singer = cursor.getString(cursor.getColumnIndex
                        ("singer"));
                String time = cursor.getString(cursor.getColumnIndex
                        ("time"));
                String style = cursor.getString(cursor.getColumnIndex
                        ("style"));
                String language = cursor.getString(cursor.getColumnIndex
                        ("language"));
                String song_key = cursor.getString(cursor.getColumnIndex
                        ("song_key"));
                String instruments = cursor.getString(cursor.getColumnIndex
                        ("instruments"));
                String note = cursor.getString(cursor.getColumnIndex
                        ("note"));
                int prof = cursor.getInt(cursor.getColumnIndex
                        ("practiced"));

                // Print them out.
                Song song = new Song();
                song.setName(name);
                song.setSinger(singer);
                song.setTime(time);
                song.setStyle(style);
                song.setLanguage(language);
                song.setKey(song_key);
                song.setInstruments(instruments);
                song.setNote(note);
                song.setProf(prof);

                songList.add(song);

            } while (cursor.moveToNext());
        }
        cursor.close();


        ListView listView = getActivity().findViewById(R.id.listview_SongList);

        SongAdapter adapter = new SongAdapter(getActivity(), R.layout.item_song, songList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Turn to SongInfo page, not including data now.
                Intent intent = new Intent(getActivity(), SongInfo.class);

                Song song = songList.get(position);

                // Use the following lines to pass data.
                Bundle bundle = new Bundle();
                bundle.putString("name", song.getName());
                bundle.putString("singer", song.getSinger());
                bundle.putString("style", song.getStyle());
                bundle.putString("language", song.getLanguage());
                bundle.putString("time", song.getTime());
                bundle.putString("song_key", song.getKey());
                bundle.putString("instruments", song.getInstruments());
                bundle.putString("note", song.getNote());
                bundle.putInt("practiced", song.getProf());
                intent.putExtras(bundle);

                startActivity(intent);

            }
        });

    }

}
