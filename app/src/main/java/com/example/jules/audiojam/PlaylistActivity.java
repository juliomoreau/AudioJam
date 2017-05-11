package com.example.jules.audiojam;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import adapter.PlaylistAdapter;
import entities.Playlist;

public class PlaylistActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference();
    DatabaseReference UserAccessRef = databaseReference.child("UserAccess");
    ArrayList<String> listPlaylist = new ArrayList<>(10);
    ArrayList<Playlist> pl = new ArrayList<>(10);

    //TODO: In order to function, this needs an asynchronous task to populate. First, create the layout and show it,
    // then search and populate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        ImageButton exit = (ImageButton) findViewById(R.id.imageButton);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });

        Intent intent = getIntent();
        final String UserID = intent.getStringExtra(MainActivity.EXTRA);

        ArrayList<String> lp = getPlaylistRefs(UserID);             //Returns an empty list
        Log.e("Tag", "onCreate: "+lp);
        try {
            ArrayList<Playlist> pl = getUserAccessPlaylist(lp); //Retuns an empy list
            ListView lv=(ListView) findViewById(R.id.listview);
            PlaylistAdapter adapter = new PlaylistAdapter(getBaseContext(), getParent(), pl);
            lv.setAdapter(adapter);
        }catch (Exception e){}
    }

    //Method to get the list of Ids accesible to a user
    private ArrayList<String> getPlaylistRefs(String userid){
        DatabaseReference ref = UserAccessRef.child(userid);
        ValueEventListener getlistlistener =  new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot listSnapshot: dataSnapshot.getChildren()){
                    String val = listSnapshot.getKey();
                    listPlaylist.add(val);
                    Log.e("tag", val );
                }
                //Method works in debug line per line. Else returns empty list
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        ref.addValueEventListener(getlistlistener);
        return listPlaylist;
    }

    //Method to get the list of playlists from a list of ids. Usually gotten after the previous method
    private ArrayList<Playlist> getUserAccessPlaylist(List<String> stringList){
        DatabaseReference ref = databaseReference.child("playlists");
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Playlist p = dataSnapshot.getValue(Playlist.class);
                pl.add(p);
                Toast.makeText(getBaseContext(), p.getName(), Toast.LENGTH_SHORT);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };

        for (int i=0; i<stringList.size();i++){
            DatabaseReference dref =ref.child(stringList.get(i));
            dref.addValueEventListener(valueEventListener);
        }
        return pl;
    }

 /*
    private class GetPlaylistsTask extends AsyncTask<String, Void, List<Playlist>> {

        @Override
        protected List<Playlist> doInBackground(String... params) {
            DatabaseReference ref = UserAccessRef.child(String.valueOf(params));

            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot listSnapshot : dataSnapshot.getChildren()) {
                        String val = listSnapshot.getKey();
                        listPlaylist.add(val);

                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        DatabaseReference dref = databaseReference.child("playlists").child(val);
                        dref.addValueEventListener(new ValueEventListener() {
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
                }

                //Method works in debug line per line. Else returns empty list
                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });

            return pl;
        }

            @Override
            protected void onPostExecute (List<Playlist> playlistresult){


            }

            @Override
            protected void onPreExecute () {
            }

            @Override
            protected void onProgressUpdate (Void...values){
            }

        }
*/
}
