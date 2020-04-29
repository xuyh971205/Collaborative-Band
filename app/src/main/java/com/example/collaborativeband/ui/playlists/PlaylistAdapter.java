package com.example.collaborativeband.ui.playlists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.collaborativeband.R;
import com.example.collaborativeband.ui.library.Song;
import com.example.collaborativeband.ui.library.SongAdapter;

import java.util.List;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {
    private int resourceId;

    public PlaylistAdapter(@NonNull Context context, int ItemView, List<Playlist> objects) {
        super(context, ItemView, objects);
        resourceId = ItemView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Playlist playlist = getItem(position);
        View view;
        ViewHolder viewHolder;

        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent,
                    false);
            viewHolder = new ViewHolder();
            viewHolder.playlistImage = (ImageView) view.findViewById (R.id.item_playlist_image);
            viewHolder.playlistName = (TextView) view.findViewById (R.id.item_playlist_name);
            viewHolder.playlistDate = (TextView) view.findViewById (R.id.item_playlist_date);
            view.setTag(viewHolder); // store viewHolder in view
        }
        else {
            view = convertView;
            viewHolder = (PlaylistAdapter.ViewHolder) view.getTag(); // get viewHolder again
        }

        viewHolder.playlistImage.setImageResource(playlist.getImgId());
        viewHolder.playlistName.setText(playlist.getName());
        viewHolder.playlistDate.setText(playlist.getDate());

        return view;
    }

    public class ViewHolder {
        ImageView playlistImage;
        TextView playlistName;
        TextView playlistDate;
    }
}
