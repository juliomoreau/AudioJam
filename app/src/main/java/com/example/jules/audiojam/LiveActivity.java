package com.example.jules.audiojam;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.domicile.entities.Music;

import java.util.List;

/**
 * Created by domicile on 19/02/2017.
 */

public class LiveActivity extends Fragment {

    private LiveInterface interfaceImpl;
    private ArrayAdapter<String> adapter1;
    private ArrayAdapter<String> adapter2;
    private ArrayAdapter<String> adapter3;
    private List<String> livelist, pastlist, walllist;

    public void initLists() {
        livelist.add("This is the first live element");
        livelist.add("This is the second live element");
        pastlist.add("This element is the first from the past");
        pastlist.add("This element is the second from the past");
        walllist.add("First!");
        walllist.add("I'm second!");
    }

    public interface LiveInterface{

        public List<Music> createLiveList();
        public List<Music> createPastList();
        public List<String> createWallList();

        public ArrayAdapter<String> arrayadapterLive();
        public ArrayAdapter<String> arrayadapterHistory();
        public ArrayAdapter<String> arrayadapterWall();

    }

    @Override
    public void onAttach(Activity context){
        super.onAttach(context);
        this.interfaceImpl = (LiveInterface)context;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_live_layout, container, false);
        //Initializing the lists.
        initLists();

        //Create the buttons that will be used to navigate.
        Button btnLive = (Button) rootView.findViewById(R.id.btnComing);
        Button btnHistory = (Button) rootView.findViewById(R.id.btnHistory);
        Button btnWall = (Button) rootView.findViewById(R.id.btnWall);

        //Create the listViews that will appear and disappear with click of corresponding button.
        ListView liveView = (ListView) rootView.findViewById(R.id.listComing);
        ListView pastView = (ListView) rootView.findViewById(R.id.listHistory);
        ListView wallView = (ListView) rootView.findViewById(R.id.listWall);

        //Initializing (cleaning) the adapters.
        adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
        adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
        adapter3 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
        adapter1.clear();
        adapter1.addAll(livelist);
        adapter2.clear();
        adapter2.addAll(pastlist);
        adapter3.clear();
        adapter3.addAll(walllist);
        //Setting and then filling the ListViews with the adapters.
        liveView.setAdapter(adapter1);
        pastView.setAdapter(adapter2);
        wallView.setAdapter(adapter3);

        //INITIALIZATION with liveView activated
        liveView.setVisibility(View.VISIBLE);
        pastView.setVisibility(View.VISIBLE);
        wallView.setVisibility((View.VISIBLE));



        btnLive.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ListView liveView = (ListView) getActivity().findViewById(R.id.listComing);
                ListView pastView = (ListView) getActivity().findViewById(R.id.listHistory);
                ListView wallView = (ListView) getActivity().findViewById(R.id.listWall);
                liveView.setVisibility(View.VISIBLE);
                pastView.setVisibility(View.GONE);
                wallView.setVisibility(View.GONE);
            }

        });
        btnHistory.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ListView liveView = (ListView) getActivity().findViewById(R.id.listComing);
                ListView pastView = (ListView) getActivity().findViewById(R.id.listHistory);
                ListView wallView = (ListView) getActivity().findViewById(R.id.listWall);
                liveView.setVisibility(View.GONE);
                pastView.setVisibility(View.VISIBLE);
                wallView.setVisibility(View.GONE);
            }

        });
        btnWall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ListView liveView = (ListView) getActivity().findViewById(R.id.listComing);
                ListView pastView = (ListView) getActivity().findViewById(R.id.listHistory);
                ListView wallView = (ListView) getActivity().findViewById(R.id.listWall);
                liveView.setVisibility(View.GONE);
                pastView.setVisibility(View.GONE);
                wallView.setVisibility(View.VISIBLE);
            }



        });

        return rootView;
    }

}
