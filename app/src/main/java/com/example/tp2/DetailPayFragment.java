package com.example.tp2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DetailPayFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_ex8_detail, container, false);
        String pays= "";
        String population = "";
        try{
            pays = getArguments().getString("pays_selec");
            population = getArguments().getString("population");
            TextView textView = view.findViewById(R.id.textview);
            textView.setText(pays+" : ");
            TextView textView2 = view.findViewById(R.id.textview2);
            textView2.setText("Population : "+population);
        } catch (Exception e) {

        }



        return view;
    }
}
