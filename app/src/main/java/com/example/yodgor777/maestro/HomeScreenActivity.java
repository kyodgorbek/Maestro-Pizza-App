package com.example.yodgor777.maestro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HomeScreenActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        TextView menuView = (TextView) findViewById(R.id.MenuOption);
        TextView info = (TextView) findViewById(R.id.information);
        TextView findUs = (TextView) findViewById(R.id.findUs);
        menuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuIntent = new Intent(HomeScreenActivity.this, MainActivity.class);
                startActivity(menuIntent);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreenActivity.this, Information.class));
            }
        });

        findUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreenActivity.this, FindUsActivity.class));
            }
        });

    }
}


