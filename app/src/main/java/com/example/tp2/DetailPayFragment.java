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
        String capitale = "";
        String fete_national = "";
        try{
            pays = getArguments().getString("pays_selec");
            population = getArguments().getString("population");
            capitale = getArguments().getString("capital");
            fete_national = getArguments().getString("fete_national");
            TextView textView = view.findViewById(R.id.textview);
            textView.setText(pays);
            TextView textView2 = view.findViewById(R.id.textview2);
            textView2.setText(population+"\n"+capitale+"\n"+fete_national);
        } catch (Exception e) {

        }



        return view;
    }
}
