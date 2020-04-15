package com.example.collaborativeband.ui.addanewplaylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.example.collaborativeband.R;

public class AddsongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addsongs);

        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar_addsongs);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddsongsActivity.this.finish();
            }
        });





    }
}
