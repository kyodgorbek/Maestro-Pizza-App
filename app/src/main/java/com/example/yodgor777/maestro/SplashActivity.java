package com.example.yodgor777.maestro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onInitActivity() {
        try {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, HomeScreenActivity.class));
                    SplashActivity.this.finish();
                }
            }, 2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
