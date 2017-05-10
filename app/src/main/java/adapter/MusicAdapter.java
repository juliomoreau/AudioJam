package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jules.audiojam.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import entities.Music;
import entities.Playlist;
import entities.ResultSearch;

/**
 * Created by domicile on 10/05/2017.
 */

public class MusicAdapter extends BaseAdapter {
    Context context;
    Activity activity;

    private static LayoutInflater inflater;
    private List<Music> items;

    public MusicAdapter(Context c, Activity a, List<Music> musicList){
        context=c;
        activity=a;
        items=musicList;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addMusic(Music item){items.add(item);}



    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        vi =   inflater.inflate(R.layout.row_layout,null);
        ImageView image = (ImageView) vi.findViewById(R.id.list_image);
        TextView nom = (TextView) vi.findViewById(R.id.title);

        Music music = items.get(position);
        nom.setText(music.getName());
        image.setImageResource(R.drawable.choosecover);

        return vi;
    }
}
