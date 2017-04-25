package com.example.jules.audiojam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by domicile on 24/02/2017.
 */

public class OptionFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.optionslayout, null);



        return rootView;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final Spinner visibility = (Spinner) getActivity().findViewById(R.id.spinnerVisibility);

        List<String> spinArray = new ArrayList<String>();
        spinArray.add("public");
        spinArray.add("private");
        ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(
                getContext(), android.R.layout.simple_spinner_item, spinArray);
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        visibility.setAdapter(spinadapter);

    }
}
