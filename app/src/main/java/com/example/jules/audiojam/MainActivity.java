package com.example.jules.audiojam;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import com.example.domicile.adapter.SectionsPagerAdapter;
import com.example.domicile.entities.Music;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LiveActivity.LiveInterface{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    //Tab Titles
    private String[] tabs = {"Live", "Add Music", "Options"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create a button to access the menu
        ImageButton btnMenu = (ImageButton) findViewById(R.id.menu_button);
        btnMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //TODO: implement the menu opening here
                // Should open the menu
                Snackbar.make(view, "Opens the menu", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        createLiveList();
        createPastList();
        createWallList();
    }

    @Override
    public List<Music> createLiveList() {
        List<Music> liveList = new ArrayList<Music>();
        liveList.add(new Music("Johnny"));
        liveList.add(new Music("Jacky"));
        return liveList;
    }

    @Override
    public List<Music> createPastList() {
        List<Music> pastList = new ArrayList<Music>();
        pastList.add(new Music("Ken"));
        pastList.add(new Music("Koko"));
        return pastList;
    }

    @Override
    public List<String> createWallList() {
        List<String> wallList = new ArrayList<String>();
        wallList.add("This is an awesome playlist!");
        wallList.add("Meh...");
        return wallList;
    }

    @Override
    public ArrayAdapter<String> arrayadapterLive() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, createWallList()
                );

        return adapter;
    }

    @Override
    public ArrayAdapter<String> arrayadapterHistory() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, createWallList()
        );

        return adapter;
    }

    @Override
    public ArrayAdapter<String> arrayadapterWall() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, createWallList()
        );

        return adapter;
    }
}
