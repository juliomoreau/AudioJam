package com.example.jules.audiojam;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by domicile on 25/02/2017.
 */

public class GoToImplementor

{

    //Creating the functions to travel through pages
    //Will be called when the user clicks the corresponding menu item.
    public void gotoMyPlaylists(View view){
        Intent intent = new Intent(view.getContext(), PlaylistActivity.class);
        intent.putExtra(MainActivity.EXTRA, FirebaseAuth.getInstance().getCurrentUser().getUid());
        view.getContext().startActivity(intent);

    }

    public void gotoAddJoinPlaylist(View view){
        Intent intent = new Intent(view.getContext(), AddJoinPlaylistActivity.class);
        intent.putExtra(MainActivity.EXTRA, FirebaseAuth.getInstance().getCurrentUser().getUid());
        view.getContext().startActivity(intent);
    }

    public void gotoHelp(View view){
        Intent intent = new Intent(view.getContext(), HelpActivity.class);
        intent.putExtra(MainActivity.EXTRA, "ici entrer la valeur de l'utilisateur (on pourra récup les infos en direct de la même façon");
        view.getContext().startActivity(intent);
    }

    public void gotoAppSettings(View view){
        Intent intent = new Intent(view.getContext(), AppSettingsActivity.class);
        intent.putExtra(MainActivity.EXTRA, "ici entrer la valeur de l'utilisateur (on pourra récup les infos en direct de la même façon");
        view.getContext().startActivity(intent);
    }

    public void gotoAbout(View view){
        Intent intent = new Intent(view.getContext(), AboutActivity.class);
        // intent.putExtra(MainActivity.EXTRA, "ici entrer la valeur de l'utilisateur (on pourra récup les infos en direct de la même façon");
        view.getContext().startActivity(intent);
    }




    public void gotoLogout(View view){

    }


}