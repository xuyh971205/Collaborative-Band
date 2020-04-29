package com.example.collaborativeband.ui.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

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
            view.setTag(viewHolder); // store viewHolder in view
        }
        else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); // get viewHolder again
        }

        viewHolder.songImage.setImageResource(song.getImgId());
        viewHolder.songName.setText(song.getName());
        viewHolder.songSinger.setText(song.getSinger());

        return view;
    }

    public class ViewHolder {
        ImageView songImage;
        TextView songName;
        TextView songSinger;
    }

}
