package com.example.tp2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PaysAdapter extends RecyclerView.Adapter<PaysAdapter.ViewHolder> {
    private List<String> pays;
    private List<String> populations;
    private List<String> capitales;
    private List<String> fete;
    private FragmentActivity activity; //ne pas oublier le FragmentActivity sinon on ne pourra pas utiliser le getSupportFragmentManager et donc pas afficher le fragment

    public PaysAdapter(List<String> pays, List<String> populations, List<String> capitales, List<String> fete ,FragmentActivity activity) {
        this.pays = pays;
        this.populations = populations;
        this.activity = activity;
        this.capitales = capitales;
        this.fete = fete;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ex8_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(pays.get(position), populations.get(position), capitales.get(position), fete.get(position));
    }

    @Override
    public int getItemCount() {
        return pays.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.pays);
        }

        public void bind(String pays, String population, String capitale, String fete) {
            button.setText(pays);
            button.setOnClickListener(v -> {
                if (activity instanceof Ex9) {
                    ((Ex9) activity).displaySelectedCountry(pays, population, capitale, fete);
                }

                DetailPayFragment detailPayFragment = new DetailPayFragment();
                Bundle args = new Bundle();
                args.putString("pays_selec", pays + " : ");
                args.putString("population",  "Population : "+ population);
                args.putString("capital", "Capitale : "+capitale);
                args.putString("fete_national", "Fête nationale : "+fete);
                detailPayFragment.setArguments(args);

                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.detail_pays, detailPayFragment)
                        .commit();
            });
        }
    }
}