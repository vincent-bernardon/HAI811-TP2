package com.example.tp2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SelectExo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.select_exo); //c'est la vue
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.selectexo), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buttonExo2 = findViewById(R.id.button_exo2);
        buttonExo2.setOnClickListener(v -> {
            Intent intent = new Intent(SelectExo.this, MainActivity.class); //pas bien compris pour quoi il faut spécifier la classe si jamais diapo 61
            startActivity(intent);
        });

        Button buttonExo3 = findViewById(R.id.button_exo3);
        buttonExo3.setOnClickListener(v -> {
            Intent intent = new Intent(SelectExo.this, Exo3.class);
            startActivity(intent);
        });

        Button buttonExo4 = findViewById(R.id.button_exo4);
        buttonExo4.setOnClickListener(v -> {
            Intent intent = new Intent(SelectExo.this, Exo4.class);
            startActivity(intent);
        });

        Button buttonExo5 = findViewById(R.id.button_exo5);
        buttonExo5.setOnClickListener(v -> {
            Intent intent = new Intent(SelectExo.this, Exo5.class);
            startActivity(intent);
        });

        Button buttonExo6 = findViewById(R.id.button_exo6);
        buttonExo6.setOnClickListener(v -> {
            Intent intent = new Intent(SelectExo.this, Exo6.class);
            startActivity(intent);
        });

        Button buttonExo7 = findViewById(R.id.button_exo7);
        buttonExo7.setOnClickListener(v -> {
            Intent intent = new Intent(SelectExo.this, Exo7.class);
            startActivity(intent);
        });

        Button buttonExo8 = findViewById(R.id.button_exo8);
        buttonExo8.setOnClickListener(v -> {
            Intent intent = new Intent(SelectExo.this, Exo8.class);
            startActivity(intent);
        });

        Button buttonExo9 = findViewById(R.id.button_exo9);
        buttonExo9.setOnClickListener(v -> {
            Intent intent = new Intent(SelectExo.this, Exo9.class);
            startActivity(intent);
        });
    }
}
