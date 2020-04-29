package com.example.collaborativeband.ui.playlists;

import com.example.collaborativeband.ui.library.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * function: Assistance
 * Created by XYH on 2020-04-27.
 */

public class PlaylistsListHolder {

    public static List<Playlist> generatePlaylistList() {

        // Create a list as a display holder for playlists.
        List<Playlist> playlistList = new ArrayList<>();

        // Add a new playlist into this holder.
        Playlist playlist = new Playlist();
        playlistList.add(playlist);

        return playlistList;
    }

}
