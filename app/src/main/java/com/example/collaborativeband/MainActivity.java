package com.example.collaborativeband;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_playlists, R.id.navigation_library, R.id.navigation_aboutme)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        // annotating the following line to hide the default actionBar
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // Enable navView to change with navController.
        NavigationUI.setupWithNavController(navView, navController);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.toolbar_menu);
        //setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Enable toolbar to change with navController.
        NavigationUI.setupWithNavController(toolbar, navController);
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);


        // FAB's click and jump
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(MainActivity.this, SongRecognizing.class);
                startActivity(intent);
            }
        });

        // git fresh by Yuhui



    }
}

