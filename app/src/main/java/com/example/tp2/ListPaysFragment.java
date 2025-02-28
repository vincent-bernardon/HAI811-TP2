package com.example.tp2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListPaysFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_ex8, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<String> pays = new ArrayList<>();
        pays.addAll(Arrays.asList(getResources().getStringArray(R.array.pays))); //le Arrays.asList permet de transformer un tableau en liste

        ArrayList<String> populations = new ArrayList<>();
        populations.addAll(Arrays.asList(getResources().getStringArray(R.array.populations)));

        recyclerView.setAdapter(new PaysAdapter(pays, populations, getActivity()));
        return view;
    }
}
