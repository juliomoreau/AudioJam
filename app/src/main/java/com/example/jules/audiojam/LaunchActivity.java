package com.example.jules.audiojam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        ImageView img= (ImageView) findViewById(R.id.imageView4);
        img.setImageResource(R.drawable.logohqweb);
    }
}