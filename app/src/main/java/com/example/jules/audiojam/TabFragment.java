package com.example.jules.audiojam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by domicile on 24/02/2017.
 */

public class TabFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int nb_items = 3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflate tabLayout and set views
        View v = inflater.inflate(R.layout.tab_layout, container, false);
            tabLayout = (TabLayout) v.findViewById(R.id.tabs);
            viewPager = (ViewPager) v.findViewById(R.id.viewpager);
            //viewPager.setOffscreenPageLimit(3);

            //Setting adapter for the ViewPager
            viewPager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager()));

            //Workaround because setupWithViewPager needs Runnable
            tabLayout.post(new Runnable() {
                @Override
                public void run() {
                    tabLayout.setupWithViewPager(viewPager);
                }
            });

            return v;
        }

        class MyFragmentPagerAdapter extends FragmentPagerAdapter {
            public MyFragmentPagerAdapter(FragmentManager fm) {
                super(fm);
            }

            //Return fragment for position
            @Override
            public Fragment getItem(int position) {

                switch (position) {
                    case 0:
                        return new LiveFragment();
                    case 1:
                        return new MusicFragment();
                    case 2:
                        return new OptionFragment();
                }
                return null;
            }

            @Override
            public int getCount() {
                return nb_items;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "Live";
                    case 1:
                        return "Add Music";
                    case 2:
                        return "Options";
                }
                return null;
            }
        }
}
