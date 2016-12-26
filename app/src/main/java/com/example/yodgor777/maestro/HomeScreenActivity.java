package com.example.yodgor777.maestro;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;

public class HomeScreenActivity extends BaseActivity {
    @BindView(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_home_screen;
    }

    @Override
    protected void onInitActivity() {
        setSupportActionBar(toolbar);
        setTitle("Home");
    }

}
