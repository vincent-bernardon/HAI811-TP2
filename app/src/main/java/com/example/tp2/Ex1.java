package com.example.tp2;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class Ex1 extends AppCompatActivity {

    private void listSensor(){
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sensorDesc = new StringBuilder();
        for (Sensor sensor : sensors) {
            sensorDesc.append("New sensor detected: \n");
            sensorDesc.append("Name: ").append(sensor.getName()).append("\n");
            sensorDesc.append("Type: ").append(sensor.getType()).append("\n");
            sensorDesc.append("Vendor: ").append(sensor.getVendor()).append("\n");
            sensorDesc.append("Version: ").append(sensor.getVersion()).append("\n");
            sensorDesc.append("Power: ").append(sensor.getPower()).append("\n");
            sensorDesc.append("Resolution: ").append(sensor.getResolution()).append("\n");
            sensorDesc.append("Max Range: ").append(sensor.getMaximumRange()).append("\n");
            sensorDesc.append("\n");
        }
        TextView textView = findViewById(R.id.textView);
        textView.setText(sensorDesc.toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ex1);

        listSensor();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}