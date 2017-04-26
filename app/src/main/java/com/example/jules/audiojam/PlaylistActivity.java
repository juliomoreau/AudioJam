package com.example.jules.audiojam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import adapter.PlaylistAdapter;
import adapter.SearchAdapter;
import entities.IdPlaylist;
import entities.Playlist;

public class PlaylistActivity extends AppCompatActivity {

    FirebaseDatabase database= FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference();
    DatabaseReference UserAccessRef = databaseReference.child("UserAccess");

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

        List<String> ls = getPlaylistRefs(UserID);
        List<Playlist> pl = getUserAccessPlaylist(ls);

        ListView lv=(ListView) findViewById(R.id.listview);

        PlaylistAdapter adapter = new PlaylistAdapter(getBaseContext(), this, pl);
        lv.setAdapter(adapter);
        //ViewGroup mViewGroup = (ViewGroup) findViewById(R.id.playlist_mainview);
        //mViewGroup.addView(txtView);
    }

    private List<String> getPlaylistRefs(String userid){
        //TODO: possible change with having a list of playslists rather than simply list of IDs (heavier and slower)
        // but easier and more complete

        final List<String> listPlaylist = new ArrayList<>();
        DatabaseReference ref = UserAccessRef.child(userid);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                IdPlaylist idPlaylist = dataSnapshot.getValue(IdPlaylist.class);
                for (int i=0; i<idPlaylist.getToken().size();i++){ /*Points to a null object reference idPlaylist not found??*/
                    listPlaylist.set(i, idPlaylist.getToken().get(i));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return listPlaylist;
    }

    private List<Playlist> getUserAccessPlaylist(List<String> stringList){

        final List<Playlist> pl = new ArrayList<>();
        DatabaseReference ref = databaseReference.child("playlists");
        for (int i=0; i<stringList.size();i++){
            DatabaseReference dref =ref.child(stringList.get(i));

            dref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Playlist p = dataSnapshot.getValue(Playlist.class);
                    pl.add(p);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }

        return pl;
    }
}
