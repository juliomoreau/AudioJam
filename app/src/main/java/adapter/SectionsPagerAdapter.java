package adapter;

import android.app.VoiceInteractor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.domicile.testing.LiveActivity;
import com.example.domicile.testing.MainActivity;
import com.example.domicile.testing.MusicActivity;
import com.example.domicile.testing.OptionActivity;

/**
 * Created by domicile on 19/02/2017.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        switch(position){
            case 0:
                return new LiveActivity();
            case 1:
                return new MusicActivity();
            case 2:
                return new OptionActivity();
        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
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
