package com.example.saurav.complex.WikiPedia;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.saurav.complex.R;

public class IntroWikiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_wiki);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
startActivity(new Intent(getApplicationContext(), WikiSwipeActivity.class));
finish();

             }
        }, 900);
    }
}
