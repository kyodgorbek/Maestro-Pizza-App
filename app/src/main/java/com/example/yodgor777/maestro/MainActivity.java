package com.example.yodgor777.maestro;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final PizzaFragment pizzaFragment = new PizzaFragment();
    KebabFragment kebabFragment = new KebabFragment();
    SaladFragment saladFragment = new SaladFragment();
    OtherFragment otherFragment = new OtherFragment();
    FrameLayout mContainer;
    TextView mPizzaTv, mKebabTv, mSaladTv, mOtherTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.parseColor("#635a5a"));
        }

        mContainer = (FrameLayout) findViewById(R.id.container);
        mPizzaTv = (TextView) findViewById(R.id.pizzaBtn);
        mKebabTv = (TextView) findViewById(R.id.kebabBtn);
        mSaladTv = (TextView) findViewById(R.id.saladBtn);
        mOtherTv = (TextView) findViewById(R.id.otherBtn);

// first should be pizza second is kebab third salad fourth other
        mKebabTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!(getSupportFragmentManager().findFragmentById(R.id.container) instanceof KebabFragment)) {

                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.container, kebabFragment).commit();
                }
            }
        });

        mSaladTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(getSupportFragmentManager().findFragmentById(R.id.container) instanceof SaladFragment)) {
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.container, saladFragment).commit();
                }
            }
        });


        mOtherTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(getSupportFragmentManager().findFragmentById(R.id.container) instanceof OtherFragment)) {
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.container, otherFragment).commit();
                }
            }
        });


        mPizzaTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(getSupportFragmentManager().findFragmentById(R.id.container) instanceof PizzaFragment)) {
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.container, pizzaFragment).commit();
                }
            }
        });

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.container,pizzaFragment).commit();

    }
}