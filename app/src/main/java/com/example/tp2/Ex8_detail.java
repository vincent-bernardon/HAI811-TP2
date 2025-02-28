package com.example.tp2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ex8_detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ex8_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String pays = getIntent().getStringExtra("pays_selec");
        TextView textView = findViewById(R.id.textview);
        textView.setText(pays);

        String population = getIntent().getStringExtra("population");
        String capitale = getIntent().getStringExtra("capitale");
        String fete = getIntent().getStringExtra("fete_national");
        TextView textView2 = findViewById(R.id.textview2);

        textView2.setText(population+"\n"+capitale+"\n"+fete);
    }
}