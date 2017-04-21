package com.example.jules.audiojam;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import entities.Music;

/**
 * Created by domicile on 24/02/2017.
 */

public class LiveFragment extends Fragment {

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ListFragment lf = new ListFragment();
        ft.replace(R.id.liveTableLayout, lf);
        ft.commit();

        View rootView = inflater.inflate(R.layout.livelayout, null);
        return rootView;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //TODO:INITIALIZE text on it's values or create template values.

        Button btn1 = (Button) getView().findViewById(R.id.btnComing);
        Button btn2 = (Button) getView().findViewById(R.id.btnHistory);
        Button btn3 = (Button) getView().findViewById(R.id.btnWall);

        /*
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Testing for 0 (TODO: check for playlistID before)

                List<Music> res = getListLive("0");
                for (int i=0;i<res.size();i++){
                    addListItemLive(res.get(i));
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public List<Music> getListLive(String playlistToken){
        final List<Music> lm = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mDatabaseRef;
        mDatabaseRef = database.getReference();
        DatabaseReference myMusicListRef = mDatabaseRef.child("playlists").child(playlistToken).child("musicList");
        myMusicListRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                long value=dataSnapshot.getChildrenCount();
                GenericTypeIndicator<List<Music>> genericTypeIndicator =new GenericTypeIndicator<List<Music>>(){};
                List<Music> musicList=dataSnapshot.getValue(genericTypeIndicator);
                for(int i=0;i<musicList.size();i++){

                    addListItemLive(musicList.get(i));
                }
            }
            @Override
            public void onCancelled(DatabaseError error){
                // Failed to read value
            }
        });

        mDatabaseRef.child("playlists").child(playlistToken).child("musicList");
        return lm;
    }

    public List<Music> getListPast(String playlistToken){
        //Create a past list in the database for every playlist where a music will be passed to (and deleted from the actual list)
        List<Music> lm = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mDatabaseRef;
        mDatabaseRef = database.getReference();

        return lm;
    }

    public List<String> getListWall(String playlistToken){
        List<String> ls = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mDatabaseRef;
        mDatabaseRef = database.getReference();

        return ls;
    }

    public TableRow addListItemLive(Music m){
        Context c = getContext();
        LinearLayout l1 = new LinearLayout(c);
        LinearLayout l2 = new LinearLayout(c);
        TableRow tbR = new TableRow(c);
        TextView txt1 = new TextView(c);
        TextView txt2 = new TextView(c);
        TextView txt3 = new TextView(c);
        ImageView i1 = new ImageView(c);
        ImageView i2 = new ImageView(c);

        txt1.setText(m.getCover().toString());
        txt2.setText(m.getName());
        txt3.setText(m.getRating());
        i1.setImageResource(R.drawable.opencamera);
        i2.setImageResource(R.drawable.opencamera);

        l1.setOrientation(LinearLayout.HORIZONTAL);
        l2.setOrientation(LinearLayout.VERTICAL);
        l1.addView(txt1);
        l1.addView(txt2);
        l2.addView(i1);
        l2.addView(i2);
        l1.addView(l2);
        l1.addView(txt3);

        tbR.addView(l1);
        return tbR;
    }

    public TableRow addListItemPast(Music m){
        TableRow tbR = new TableRow(getContext());

        return tbR;
    }

    public TableRow addListItemWall(String s){
        TableRow tbR = new TableRow(getContext());

        return tbR;
    }
    */
    }
}
