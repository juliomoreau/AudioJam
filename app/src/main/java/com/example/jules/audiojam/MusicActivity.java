package com.example.jules.audiojam;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by domicile on 19/02/2017.
 */

public class MusicActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View rootView = inflater.inflate(R.layout.fragment_music_layout, container, false);
        Button btn1 = (Button) rootView.findViewById(R.id.button2);
        Button btn2 = (Button) rootView.findViewById(R.id.button3);
        Button btn3 = (Button) rootView.findViewById(R.id.button4);

        TextView txt1 = (TextView) rootView.findViewById(R.id.textView2);
        final TextView txt2 = (TextView) rootView.findViewById(R.id.textView3);
        TextView txt3 = (TextView) rootView.findViewById(R.id.textView4);
        txt1.setVisibility(View.GONE);
        txt2.setVisibility(View.GONE);
        txt3.setVisibility(View.GONE);


        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                TextView txt1 = (TextView) rootView.findViewById(R.id.textView2);
                TextView txt3 = (TextView) rootView.findViewById(R.id.textView4);
                txt2.setVisibility(View.GONE);
                txt1.setVisibility(View.VISIBLE);
                txt3.setVisibility(View.GONE);
            }

        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                TextView txt1 = (TextView) rootView.findViewById(R.id.textView2);
                TextView txt3 = (TextView) rootView.findViewById(R.id.textView4);
                txt2.setVisibility(View.VISIBLE);
                txt1.setVisibility(View.GONE);
                txt3.setVisibility(View.GONE);
            }

        });
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                TextView txt1 = (TextView) rootView.findViewById(R.id.textView2);
                TextView txt3 = (TextView) rootView.findViewById((R.id.textView4));
                txt3.setVisibility(View.VISIBLE);
                txt1.setVisibility(View.GONE);
                txt2.setVisibility(View.GONE);
            }

        });

        return rootView;
    }
}
