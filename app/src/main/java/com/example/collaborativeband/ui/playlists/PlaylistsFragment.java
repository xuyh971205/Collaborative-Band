package com.example.collaborativeband.ui.playlists;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.collaborativeband.R;
import com.example.collaborativeband.ui.addanewplaylist.addanewplaylistActivity;

import java.util.ArrayList;
import java.util.List;

public class PlaylistsFragment extends Fragment {

    private PlaylistsViewModel playlistsViewModel;
    private ListView mLvMsgList;
    private List<Playlist> mDatas = new ArrayList<>();
    private PlaylistAdapter mAdapter;

    private Button btn1;

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

        //

        mLvMsgList = getActivity().findViewById(R.id.listview_PlaylistList);

        /**
         * 多调用两次，数据会更多
         */
        mDatas.addAll(PlaylistsListHolder.generatePlaylistList());
        mDatas.addAll(PlaylistsListHolder.generatePlaylistList());

        mAdapter = new PlaylistAdapter(this.getContext(), mDatas);

        mLvMsgList.setAdapter(mAdapter);




    }
}

