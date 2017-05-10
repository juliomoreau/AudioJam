package adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jules.audiojam.MainActivity;
import com.example.jules.audiojam.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;

import entities.Music;
import entities.ResultSearch;


/**
 * Created by Jules on 16/04/2017.
 */

public class SearchAdapter extends BaseAdapter {
    Context context;
    Activity activity;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseRef=database.getReference();
    DatabaseReference getDatabaseRefPlaylist=databaseRef.child("playlists");
    public String retrievePlaylistID(){

        databaseRef.child("UserAccess").child("CNOfE4e1EtZRJ5nGKOE7nOpTDVQ2").child("currentplaylist").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                current = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                current="";
            }
        });
        return current;
    }

    String current=retrievePlaylistID(); //ne change pas la valeur


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

        final ResultSearch resultSearch = items.get(position);
        Picasso.with(context).load(resultSearch.getThumbnail().getUrl()).into(image);
        nom.setText(resultSearch.getVideoName());
        vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Music music=new Music(resultSearch.getVideoName(),1,resultSearch.getVideoId());
                DatabaseReference getGetDatabaseRefPlaylistToken=getDatabaseRefPlaylist.child(current);
                DatabaseReference newRef=getGetDatabaseRefPlaylistToken.child("musicList").push();
                newRef.setValue(music);
                Toast.makeText(context,resultSearch.getVideoName()+" ajouté à la playlist",Toast.LENGTH_LONG).show();

            }
        });



        return vi;
    }




}
