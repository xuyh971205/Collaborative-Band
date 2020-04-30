package com.example.collaborativeband.ui.library;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.collaborativeband.R;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends ArrayAdapter<Song> {
    private int resourceId;

    public SongAdapter(@NonNull Context context, int ItemView, List<Song> objects) {
        super(context, ItemView, objects);
        resourceId = ItemView;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Song song = getItem(position);
        View view;
        ViewHolder viewHolder;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent,
                    false);
            viewHolder = new ViewHolder();
            viewHolder.songImage = (ImageView) view.findViewById (R.id.item_song_image);
            viewHolder.songName = (TextView) view.findViewById (R.id.item_song_name);
            viewHolder.songSinger = (TextView) view.findViewById (R.id.item_song_singer);
            viewHolder.songProf = (Button) view.findViewById(R.id.item_song_proficiency);
            view.setTag(viewHolder); // store viewHolder in view
        }
        else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); // get viewHolder again
        }

        viewHolder.songImage.setImageResource(song.getImgId());
        viewHolder.songName.setText(song.getName());
        viewHolder.songSinger.setText(song.getSinger());

        if(song.getProf() == 0){
            viewHolder.songProf.setBackgroundResource(R.drawable.background_grade1);
        }
        if(song.getProf() == 1){
            viewHolder.songProf.setBackgroundResource(R.drawable.background_grade2);
        }
        if(song.getProf() == 2){
            viewHolder.songProf.setBackgroundResource(R.drawable.background_grade3);
        }
        if(song.getProf() == 3){
            viewHolder.songProf.setBackgroundResource(R.drawable.background_grade4);
        }
        if(song.getProf() == 4){
            viewHolder.songProf.setBackgroundResource(R.drawable.background_grade5);
        }
        if(song.getProf() > 4){
            viewHolder.songProf.setBackgroundResource(R.drawable.splash_background_gradient);
        }

        return view;


    }


    public class ViewHolder {
        ImageView songImage;
        TextView songName;
        TextView songSinger;
        Button songProf;
    }

}
