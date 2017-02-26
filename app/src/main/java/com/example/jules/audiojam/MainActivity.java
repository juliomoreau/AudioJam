package com.example.jules.audiojam;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.jules.audiojam.GoToImplementor;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;

    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    GoToImplementor mGTImpl = new GoToImplementor();
    public final static String EXTRA = "com.example.domicile.finaltesting.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        //Setup DrawerLayout and NavigationView
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.sidemenu);

        //Inflate TabFragment as first Fragment
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();



        //Setup click events
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem){
                mDrawerLayout.closeDrawers();

                if (menuItem.getItemId() == R.id.nav_item_myPlaylist){
                    mGTImpl.gotoMyPlaylists(mDrawerLayout);
                }
                if (menuItem.getItemId() == R.id.nav_item_join_add){
                    mGTImpl.gotoAddJoinPlaylist(mDrawerLayout);
                }
                if (menuItem.getItemId() == R.id.nav_item_help){
                    mGTImpl.gotoHelp(mDrawerLayout);
                }
                if (menuItem.getItemId() == R.id.nav_item_settings){
                    mGTImpl.gotoAppSettings(mDrawerLayout);
                }
                if (menuItem.getItemId() == R.id.nav_item_about){
                    mGTImpl.gotoAbout(mDrawerLayout);
                }
                if (menuItem.getItemId() == R.id.nav_item_logout){
                    signOut();
                    //get current user
                    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user == null) {
                        // user auth state is changed - user is null
                        // launch login activity
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        finish();
                    }
                }
                return false;
            }
        });

        //Setup Drawer Toggle on the toolbar (currently hidden)
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name,R.string.app_name);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();


    }


    //sign out method
    public void signOut() {
        auth.signOut();
    }

    /*Gestion du cycle de vie de l'appli*/




}