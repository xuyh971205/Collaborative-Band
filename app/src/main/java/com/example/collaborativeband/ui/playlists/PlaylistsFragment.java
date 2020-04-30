package com.example.collaborativeband.ui.playlists;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collaborativeband.R;
import com.example.collaborativeband.ui.addanewplaylist.addanewplaylistActivity;
import com.example.collaborativeband.ui.library.SongAdapter;
import com.example.collaborativeband.ui.library.SongInfo;

import java.util.ArrayList;
import java.util.List;

public class PlaylistsFragment extends Fragment {

    private PlaylistsViewModel playlistsViewModel;
    private List<Playlist> playlistList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        playlistsViewModel =
                ViewModelProviders.of(this).get(PlaylistsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_playlists, container, false);
        return root;
    }

    @Override
    // 08.04.2020 by Yuhui Xu
    // Here the onActivityCreated() is similar to onCreate() in MainActivity.java.
    // So if you want to write methods and realize functions, please write in it.
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Realized altering pages by clicking a button on a fragment.
        Button btn1;
        btn1 = getActivity().findViewById(R.id.button_add_playlist);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // The getActivity() realized setOnClickListener() in a fragment, instead of only in an activity.
                // In MainActivity.java, getActivity() here will be replaced by MainActivity.this.
                Intent intent_1 = new Intent(getActivity(), addanewplaylistActivity.class);
                startActivity(intent_1);
            }
        });

        ListView listView = getActivity().findViewById(R.id.listview_PlaylistList);

        setListViewHeightBasedOnChildren(listView);

        PlaylistAdapter adapter = new PlaylistAdapter(getActivity(), R.layout.item_playlist, playlistList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Turn to SongInfo page, not including data now.
                Intent intent = new Intent(getActivity(), PlaylistInfo.class);

                //intent.setAction("The pass data");
                String string = "Hello World!";
                intent.putExtra("name", string);

                startActivity(intent);

                // Use the following lines to pass data.
                /*Bundle bundle = new Bundle();
                bundle.putString("key_height", fieldHeight.getText().toString());
                bundle.putString("key_weight", fieldWeight.getText().toString());
                intent.putExtras(bundle);*/

            }
        });

    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();

        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));

        listView.setLayoutParams(params);
    }
}

