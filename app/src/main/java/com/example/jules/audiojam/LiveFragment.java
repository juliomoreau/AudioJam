package com.example.jules.audiojam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by domicile on 24/02/2017.
 */

public class LiveFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.livelayout, null);
        View v = new View(getContext());

        final TextView txt1 = (TextView) rootView.findViewById(R.id.txtVNameRow1);
        final TextView txt2 = (TextView) rootView.findViewById(R.id.txtVNameRow2);
        final TextView txt3 = (TextView) rootView.findViewById(R.id.txtVNameRow3);
        final TextView txt4 = (TextView) rootView.findViewById(R.id.txtVNameRow4);

        final TextView txtR1 = (TextView) rootView.findViewById(R.id.txtVRateRow1);
        final TextView txtR2 = (TextView) rootView.findViewById(R.id.txtVRateRow2);
        final TextView txtR3 = (TextView) rootView.findViewById(R.id.txtVRateRow3);
        final TextView txtR4 = (TextView) rootView.findViewById(R.id.txtVRateRow4);


        //TODO:INITIALIZE text on it's values or create template values.

        Button btn1 = (Button) rootView.findViewById(R.id.btnComing);
        Button btn2 = (Button) rootView.findViewById(R.id.btnHistory);
        Button btn3 = (Button) rootView.findViewById(R.id.btnWall);

        TableLayout tabLayout = (TableLayout) rootView.findViewById(R.id.liveTableLayout);
        final TableRow row1 = (TableRow) rootView.findViewById(R.id.liveRow1);
        final TableRow row2 = (TableRow) rootView.findViewById(R.id.liveRow2);
        final TableRow row3 = (TableRow) rootView.findViewById(R.id.liveRow3);
        final TableRow row4 = (TableRow) rootView.findViewById(R.id.liveRow4);

        txt1.setText("Click a button");
        txtR1.setText("0");

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                txt1.setText("ch");
                txt2.setText("ch");
                txt3.setText("ch");
                txt4.setText("ch");
                txtR1.setText("100");
                txtR2.setText("100");
                txtR3.setText("100");
                txtR4.setText("100");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setText("test2");
                txt2.setText("tet");
                txt3.setText("jkghv");
                txt4.setText("gh");
                txtR1.setText("100");
                txtR2.setText("100");
                txtR3.setText("100");
                txtR4.setText("100");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setText("test3");
                txt2.setText("tty");
                txt3.setText("hfj");
                txt4.setText("tt");
                txtR1.setText("100");
                txtR2.setText("100");
                txtR3.setText("100");
                txtR4.setText("100");
            }
        });

        return rootView;
    }
}
