package com.example.jules.audiojam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class PlaylistActivity extends AppCompatActivity {

    FirebaseDatabase database= FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference();
    DatabaseReference UserAccessRef = databaseReference.child("UserAccess");

    private List<String> getPlaylistRefs(String userid){


        List<String> listPlaylist = new ArrayList<>();
        UserAccessRef.orderByChild(userid);
        return listPlaylist;
    }

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






        //ViewGroup mViewGroup = (ViewGroup) findViewById(R.id.playlist_mainview);
        //mViewGroup.addView(txtView);
    }
}
