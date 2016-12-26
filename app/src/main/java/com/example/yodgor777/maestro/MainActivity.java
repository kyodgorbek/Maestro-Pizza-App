package com.example.yodgor777.maestro;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    FrameLayout mContainer;
    TextView mPizzaTv, mKebabTv, mSaladTv, mOtherTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContainer = (FrameLayout) findViewById(R.id.container);
        mPizzaTv = (TextView) findViewById(R.id.pizzaBtn);
        mKebabTv = (TextView) findViewById(R.id.kebabBtn);
        mSaladTv = (TextView) findViewById(R.id.saladBtn);
        mOtherTv = (TextView) findViewById(R.id.otherBtn);


        mKebabTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                KebabFragment kebabFragment = new KebabFragment();

                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.container,kebabFragment).commit();
            }
        });

        mSaladTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaladFragment saladFragment = new SaladFragment();
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().add(R.id.container, saladFragment).commit();
            }
        });


        mOtherTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OtherFragment otherFragment = new OtherFragment();
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().add(R.id.container,otherFragment).commit();
            }
        });

        final PizzaFragment pizzaFragment = new PizzaFragment();

        mPizzaTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().add(R.id.container,pizzaFragment).commit();
            }
        });

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.container,pizzaFragment).commit();



    }
}