package com.example.collaborativeband.ui.addanewsong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.collaborativeband.R;

public class editthesongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_the_song);

        // finish this activity by clicking on the close button.
        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar_editthesong);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editthesongActivity.this.finish();
            }
        });

        // Hide the keyboard by clicking on anywhere outside EditViews.
        findViewById(R.id.editthesong_parent_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.editthesong_parent_layout) {
                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        });





    }
}
