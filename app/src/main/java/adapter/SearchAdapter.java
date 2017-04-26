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

import entities.ResultSearch;


/**
 * Created by Jules on 16/04/2017.
 */

public class SearchAdapter extends BaseAdapter {
    Context context;
    Activity activity;


    private  static  LayoutInflater inflater;
    private List<ResultSearch> items;

    public SearchAdapter(Context c, Activity a, List<ResultSearch> searchList){
        context=c;
        activity=a;
        items=searchList;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addResultSearch(ResultSearch item) {
        items.add(item);
    }

    public int getCount() {
        return items.size();
    }

    public Object getItem(int position) {
        return items.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View vi = convertView;
        vi =   inflater.inflate(R.layout.row_layout,null);
        ImageView image = (ImageView) vi.findViewById(R.id.list_image);
        TextView nom = (TextView) vi.findViewById(R.id.title);

        ResultSearch resultSearch = items.get(position);
        Picasso.with(context).load(resultSearch.getThumbnail().getUrl()).into(image);
        nom.setText(resultSearch.getVideoName());

        return vi;
    }

}
