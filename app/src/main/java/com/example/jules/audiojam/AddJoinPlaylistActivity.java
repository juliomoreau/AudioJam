package com.example.jules.audiojam;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import entities.Playlist;


public class AddJoinPlaylistActivity extends AppCompatActivity {


    FirebaseStorage storage = FirebaseStorage.getInstance();
    private StorageReference mStorageRef;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabaseRef;
    int playlistID;
    String splaylistID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO: Integrate the storage for the cover and it's database String equivalent (path-to-image)

        final Context basecontext = this;
        final String userID = getIntent().getStringExtra(MainActivity.EXTRA);

        //Setting up the storage
        mStorageRef = storage.getReference();
        StorageReference coversRef = mStorageRef.child("covers");
        super.onCreate(savedInstanceState);

        //Setting up the RTDatabase
        mDatabaseRef = database.getReference();
        DatabaseReference pIDRef = mDatabaseRef.child("currentplaylistID");

        setContentView(R.layout.activity_add_join_playlist);

        //Creating the exit button
        ImageButton exit = (ImageButton) findViewById(R.id.imageButton);
        exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }

        });

        //Setting the buttons for listeners
        ImageButton cameraOpener = (ImageButton) findViewById(R.id.btnQRCodeScan);
        ImageButton coverSelector = (ImageButton) findViewById(R.id.btnChooseImage);
        Button btnJoinP = (Button) findViewById(R.id.btnValidate);
        Button btnCreateP = (Button) findViewById(R.id.btnValidate2);

        //Setting the spinner
        final Spinner visibility = (Spinner) findViewById(R.id.spinnerVisibility);

        //Setting the EditTexts
        final EditText editTxtToken = (EditText) findViewById(R.id.inputtoken);
        final EditText editTxtName = (EditText) findViewById(R.id.inputName);

        //Filling the spinner
        List<String> spinArray = new ArrayList<String>();
        spinArray.add("public");
        spinArray.add("private");
        ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinArray);
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        visibility.setAdapter(spinadapter);

                /*HERE SHOULD BE CALLED:
                * String pathtoimage = newRef.getName();
                */

        //Creating a listener for change in the database for the currentplaylistID
        ValueEventListener newidlistener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                splaylistID =dataSnapshot.getValue().toString();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        pIDRef.addValueEventListener(newidlistener);

        btnJoinP.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //TODO: Create a Method to verify join of playlist (does exist? is joinable?
                // if yes to both then: add id to list of playlist to user) TOKEN=CRYPTED OR MODIFIED ID

                //TODO previous method that stocks in memory the QRCODE? or else integrated method inside the onclick method
                String jackiechan =editTxtToken.getText().toString();
                if (jackiechan.equals("")) {
                    Toast toast = Toast.makeText(basecontext, "Please enter the token or flash th QRCode", Toast.LENGTH_LONG);
                    toast.show();
                }
                else{
                    if(mDatabaseRef.child("playlists").child(jackiechan).child("visibility").equals(true)) {
                    mDatabaseRef.child("UserAcces").child(userID).child(jackiechan).setValue(1);
                    }
                }
            }
        });

        //Create a listener (and writer) for confirmation and creation of a new playlist
        btnCreateP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Integrate the use of stored images for covers
                //TODO: Creation of QRCODE?
                String baskinrobins = visibility.getSelectedItem().toString();
                String chuckNorris = editTxtName.getText().toString();
                String pathtoimage = "TODO";
                playlistID = Integer.parseInt(splaylistID);

                if (chuckNorris.equals("") || baskinrobins.equals("")){
                    Toast.makeText(basecontext, "Please fill the blanks", Toast.LENGTH_LONG).show();
                }

                else{
                    if (baskinrobins.equals("public")){
                        Playlist playlist = new Playlist(chuckNorris, pathtoimage, true, userID);
                        String SpID = String.valueOf(playlistID++);
                        mDatabaseRef.child("playlists").child(SpID).setValue(playlist);
                        mDatabaseRef.child("currentplaylistID").setValue(playlistID++);
                    }
                    if (baskinrobins.equals("private")){
                        Playlist playlist = new Playlist(chuckNorris, pathtoimage, false, userID);
                        String SpID = String.valueOf(playlistID++);
                        mDatabaseRef.child("playlists").child(SpID).setValue(playlist);
                        mDatabaseRef.child("currentplaylistID").setValue(playlistID++);
                    }
                    Toast.makeText(basecontext, "Playlist successfully created", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });

            /*
            METHOD TO IMPLEMENT AFTER


        Uri file = Uri.fromFile(new File("path/to/images/rivers.jpg"));
        StorageReference riversRef = storageRef.child("images/"+file.getLastPathSegment());
        uploadTask = riversRef.putFile(file);

// Register observers to listen for when the download is done or if it fails
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                Uri downloadUrl = taskSnapshot.getDownloadUrl();
            }
        });
        */

    }
}
