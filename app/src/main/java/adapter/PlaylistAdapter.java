package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jules.audiojam.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import entities.Playlist;
import entities.ResultSearch;

/**
 * Created by domicile on 26/04/2017.
 */

public class PlaylistAdapter extends BaseAdapter {
    Context context;
    Activity activity;
    private static LayoutInflater inflater;
    private List<Playlist> items;

    //Constructor for the Adapter to call when wanting to fill a listview
    public PlaylistAdapter(Context context, Activity activity, List<Playlist> playlistList){
        this.context=context;
        this.activity=activity;
        items=playlistList;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public boolean addPlaylistToList(Playlist item){ items.add(item); return true;}

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    //La méthode getView est celle qui est appelée lors de la création d'une listview.
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View vi = convertView;
        vi =   inflater.inflate(R.layout.playlistrow_layout,null);
        ImageView cover = (ImageView) vi.findViewById(R.id.pCover);
        TextView nom = (TextView) vi.findViewById(R.id.pTitle);
        ImageButton delete = (ImageButton) vi.findViewById(R.id.pDelete);
        ImageButton addadmin = (ImageButton) vi.findViewById(R.id.pAdmin);
        ImageButton settings = (ImageButton) vi.findViewById(R.id.pSettings);

        Playlist playlistitem = items.get(position);
        nom.setText(playlistitem.getName());
        //Picasso.with(context).load(resultSearch.getThumbnail().getUrl()).into(image);
        cover.setImageResource(R.drawable.choosecover);
        delete.setImageResource(R.drawable.delete_icon);
        settings.setImageResource(R.drawable.settings_icon);
        addadmin.setImageResource(R.drawable.addadmin_icon);

        return vi;
    }

}
