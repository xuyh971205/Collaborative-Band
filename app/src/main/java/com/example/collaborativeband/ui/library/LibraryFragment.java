package com.example.collaborativeband.ui.library;

import android.content.Intent;
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

import com.example.collaborativeband.R;
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

        ListView listView = getActivity().findViewById(R.id.listview_SongList);

        //
        initFruits();

        SongAdapter adapter = new SongAdapter(getActivity(), R.layout.item_song, songList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Turn to SongInfo page, not including data now.
                Intent intent = new Intent(getActivity(), SongInfo.class);

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

    private void initFruits() {
        for (int i = 0; i < 5; i++) {
            Song apple = new Song(1, "Old Days", "XHUI", "Metal", "English",
                    "4m32s", "#C", "Guitar, bass, drum", "None.",
                    "1234", R.drawable.audience, 1);
            songList.add(apple);

        }
    }
}
