package com.example.jules.audiojam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        ImageButton exit = (ImageButton) findViewById(R.id.imageButton);
        exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }

        });

        Intent intent = getIntent();
        String UserID = intent.getStringExtra(MainActivity.EXTRA);
        String msg = UserID+" \nUne fois récupérée, on l'envoie à la BDD pour récupérer les playlists associées";
        TextView txtView = (TextView) findViewById(R.id.pmainview_txt1);
        txtView.setTextSize(10);
        txtView.setPadding(10,30,10,10);
        txtView.setText(msg);

        //ViewGroup mViewGroup = (ViewGroup) findViewById(R.id.playlist_mainview);
        //mViewGroup.addView(txtView);
    }
}