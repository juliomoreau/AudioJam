package com.example.jules.audiojam;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO: Integrate the storage for the cover and it's database String equivalent (path-to-image)

        final Context basecontext = this;

        //Setting up the storage
        mStorageRef = storage.getReference();
        StorageReference coversRef = mStorageRef.child("covers");
        super.onCreate(savedInstanceState);

        //Setting up the RTDatabase
        mDatabaseRef = database.getReference();

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
        EditText editTxtToken = (EditText) findViewById(R.id.inputtoken);
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
                *
                * SHOULD ALSO BE FOUND:
                * int playlistID = mDatabaseRef.child("values/playlist").getValue;
                */


        btnCreateP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Recuperate the creator's id and feed it to the database
                //TODO: Create a database child with the current next playlistID available and use it
                //TODO: Integrate the use of stored images for covers
                String baskinrobins = visibility.getSelectedItem().toString();
                String chuckNorris = editTxtName.getText().toString();
                String pathtoimage = "TODO";
                int playlistID = 1;

                if (chuckNorris.equals("") || baskinrobins.equals("")){
                    Toast alert = Toast.makeText(basecontext, "Please fill the blanks", Toast.LENGTH_LONG);
                }

                else{
                    if (baskinrobins.equals("public")){
                        Playlist playlist = new Playlist(chuckNorris, pathtoimage, true);
                        String SpID = String.valueOf(playlistID++);
                        mDatabaseRef.child("playlists").child(SpID).setValue(playlist);
                    }
                    if (baskinrobins.equals("private")){
                        Playlist playlist = new Playlist(chuckNorris, pathtoimage, false);
                        String SpID = String.valueOf(playlistID++);
                        mDatabaseRef.child("playlists").child(SpID).setValue(playlist);
                    }
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
