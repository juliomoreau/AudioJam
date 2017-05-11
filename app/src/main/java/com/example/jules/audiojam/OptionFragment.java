package com.example.jules.audiojam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by domicile on 24/02/2017.
 */

public class OptionFragment extends Fragment {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mDatabaseRef = database.getReference();
    String UserId = FirebaseAuth.getInstance().getCurrentUser().getUid();
    DatabaseReference cPIDRef =  mDatabaseRef.child("UserAccess").child(UserId).child("currentplaylist");
    String cplaylistID;
    boolean isAdmin;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.optionslayout, null);
        return rootView;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button confirmButton = (Button) getView().findViewById(R.id.confirmOptions);
        final EditText editAdmin = (EditText) getView().findViewById(R.id.editTextAdmin);
        final EditText editFriend = (EditText) getView().findViewById(R.id.editTextFriend);


        //Setting the spinner and creating the adapter
        final Spinner visibility = (Spinner) getActivity().findViewById(R.id.spinnerVisibility);
        List<String> spinArray = new ArrayList<String>();
        spinArray.add("public");
        spinArray.add("private");
        ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(
                getContext(), android.R.layout.simple_spinner_item, spinArray);
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        visibility.setAdapter(spinadapter);

        //Creating a listener to get the current playlist id
        ValueEventListener newidlistener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cplaylistID =dataSnapshot.getValue().toString();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        cPIDRef.addValueEventListener(newidlistener);

        //Creating a listener to check if user is admin of playlist or not
        ValueEventListener isAdminListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot listSnapshot: dataSnapshot.getChildren()){
                    String val = listSnapshot.getValue(String.class);
                    if (val==UserId){
                        isAdmin=true;
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        DatabaseReference cPlaylistModListRef = mDatabaseRef.child("playlists").child(cplaylistID).child("modList");
        cPlaylistModListRef.addValueEventListener(isAdminListener);

        //Setting the fucntion for changing the visibility of the playlist.
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get the selected item, or new admin or friend
                String vis = visibility.getSelectedItem().toString();
                String adm = editAdmin.getText().toString();
                String fri = editFriend.getText().toString();

                //Check if admin or not
                if (isAdmin==true) {

                    //change visibility to public
                    if (vis == "public") {
                        mDatabaseRef.child("playlists").child(cplaylistID).child("visibility").child(String.valueOf(true));
                    }

                    //change visibility to private
                    if (vis == "private") {
                        mDatabaseRef.child("playlists").child(cplaylistID).child("visibility").child(String.valueOf(false));
                    }

                    //push new value to modList
                    if (adm != "") {
                        //TODO: method of recuperating the userID from a name or emailaddress (outside to be called twice)
                        mDatabaseRef.child("playlists").child(cplaylistID).child("modList").push().setValue(adm);
                    }

                    //set a new value to useraccess list refering to the current user
                    if (fri != "") {
                        //TODO: method of recuperating the userID from a name or emailaddress (outside to be called twice)
                        mDatabaseRef.child("UserAccess").child(fri).child(cplaylistID).setValue(cplaylistID);
                    }
                }
                else {
                    Toast.makeText(getContext(), "You are not allowed to perform this", Toast.LENGTH_SHORT);
                }
            }
        });

    }
}
