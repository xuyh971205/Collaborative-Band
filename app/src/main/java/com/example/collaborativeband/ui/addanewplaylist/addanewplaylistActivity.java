package com.example.collaborativeband.ui.addanewplaylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.example.collaborativeband.MainActivity;
import com.example.collaborativeband.R;
import com.example.collaborativeband.database.MyDatabaseHelper;

public class addanewplaylistActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_a_new_playlist);

        dbHelper = new MyDatabaseHelper(this, "Playlists.db", null, 1);
        dbHelper.getWritableDatabase();

        /*
        * The following code are hardcoding to navigate between MainActivity and other activities.
        * Try to use "stack" to store the front activities, instead of hardcoding.
        * */

        // Hide the keyboard by clicking on anywhere outside EditViews.
        findViewById(R.id.addanewplaylist_parent_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.addanewplaylist_parent_layout) {
                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        });

        // the back button on the toolbar, back to MainActivity
        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar_addaplaylist);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent_1;
                intent_1 = new Intent(addanewplaylistActivity.this, MainActivity.class);
                startActivity(intent_1);*/
                addanewplaylistActivity.this.finish();
            }
        });

        // the next button to the AddsongsActivity
        Button next;
        next = findViewById(R.id.addanewplaylist_next);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_2;
                intent_2 = new Intent(addanewplaylistActivity.this, AddsongsActivity.class);
                startActivity(intent_2);
            }
        });








    }
}
