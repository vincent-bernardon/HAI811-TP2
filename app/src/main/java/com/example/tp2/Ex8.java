package com.example.tp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ex8);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ArrayList<String> pays = new ArrayList<>();
        pays.addAll(Arrays.asList(getResources().getStringArray(R.array.pays))); //le Arrays.asList permet de transformer un tableau en liste

        ArrayList<String> populations = new ArrayList<>();
        populations.addAll(Arrays.asList(getResources().getStringArray(R.array.populations)));

        ArrayList<String> capitales = new ArrayList<>();
        capitales.addAll(Arrays.asList(getResources().getStringArray(R.array.capitales)));

        ArrayList<String> fete = new ArrayList<>();
        fete.addAll(Arrays.asList(getResources().getStringArray(R.array.fete_national)));

        recyclerView.setAdapter(new PaysAdapter(pays, populations, capitales, fete));


    }

    public static class PaysAdapter extends RecyclerView.Adapter<PaysAdapter.ViewHolder> {
        private final List<String> pays;
        private final List<String> populations;
        private final List<String> capitales;
        private final List<String> fete;

        public PaysAdapter(List<String> pays, List<String> populations, List<String> capitales, List<String> fete) {
            this.pays = pays;
            this.populations = populations;
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

        public static class ViewHolder extends RecyclerView.ViewHolder {
            private final Button button;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                button = itemView.findViewById(R.id.pays);
            }

            public void bind(String pays, String population, String capitale, String fete) {
                button.setText(pays);
                button.setOnClickListener(v -> {
                    Intent intent = new Intent(v.getContext(), Ex8_detail.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("pays_selec", pays + " : ");
                    bundle.putString("population", "Population : "+ population);
                    bundle.putString("capitale", "Capitale : "+capitale);
                    bundle.putString("fete_national", "Fête nationale : "+fete);
                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);
                });
            }
        }
    }


}

/// MERCI mille fois : https://stackoverflow.com/questions/40584424/simple-android-recyclerview-example