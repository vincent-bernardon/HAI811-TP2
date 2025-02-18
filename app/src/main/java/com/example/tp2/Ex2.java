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

public class Ex2 extends AppCompatActivity {

    private void listSensorsNotPresent(){
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sensorDesc = new StringBuilder();
        for(int i = 1; i < 15; i++){
            boolean found = false;
            for (Sensor sensor : sensors) {
                if(sensor.getType() == i){
                    found = true;
                    break;
                }
            }
            if(!found){
                sensorDesc.append("Sensor type ").append(i).append(" is not present\n");
            }
        }

        TextView textView = findViewById(R.id.textView);
        textView.setText(sensorDesc.toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ex2);

        listSensorsNotPresent();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}