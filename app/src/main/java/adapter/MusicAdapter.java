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

import java.util.List;

import entities.Music;


/**
 * Created by domicile on 10/05/2017.
 */

public class MusicAdapter extends BaseAdapter {
    Context context;
    Activity activity;
    private static LayoutInflater inflater;
    private List<Music> items;

    //Constructor for the Adapter to call when wanting to fill a listview
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

    //La méthode getView est celle qui est appelée lors de la création d'une listview.
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