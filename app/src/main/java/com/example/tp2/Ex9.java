package com.example.tp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.fragment.app.Fragment;

public class Ex9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ex9);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            ListPaysFragment listPaysFragment = new ListPaysFragment();
            DetailPayFragment detailPayFragment = new DetailPayFragment();

            // Argument pour le fragment de détail
            Bundle args = new Bundle();
            args.putString("pays_selec", "France : ");
            args.putString("population", "Population : 68 million");
            args.putString("capital", "Capitale : Paris");
            args.putString("fete_national", "Fête nationale : 14 juillet");
            detailPayFragment.setArguments(args);

            fragmentTransaction.add(R.id.list_pays, listPaysFragment);
            fragmentTransaction.add(R.id.detail_pays, detailPayFragment);

            fragmentTransaction.commit();

        }



    }

    public void displaySelectedCountry(String pays, String population, String capitale, String fete) {
        System.out.println("Selected Country: " + pays + ", Population : " + population + ", Capitale : " + capitale + ", Fete : " + fete);
    }




}

