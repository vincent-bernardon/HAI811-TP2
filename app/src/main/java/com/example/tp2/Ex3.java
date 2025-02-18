package com.example.tp2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class Ex3 extends AppCompatActivity implements SensorEventListener {

    private float seuil=50;
    private SensorManager sensorManager;
    private Sensor sensor;
    private void displayAccelerometer(){
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        StringBuilder sensorDesc = new StringBuilder();

        sensorDesc.append("Name: ").append(sensor.getName()).append("\n");
        sensorDesc.append("Type: ").append(sensor.getType()).append("\n");
        sensorDesc.append("Vendor: ").append(sensor.getVendor()).append("\n");
        sensorDesc.append("Version: ").append(sensor.getVersion()).append("\n");
        sensorDesc.append("Power: ").append(sensor.getPower()).append("\n");
        sensorDesc.append("Resolution: ").append(sensor.getResolution()).append("\n");
        sensorDesc.append("Max Range: ").append(sensor.getMaximumRange()).append("\n");
        sensorDesc.append("\n");

        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);


        TextView textView = findViewById(R.id.textView);
        textView.setText(sensorDesc.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ex3);

        displayAccelerometer();

        //listener sur le seekbar pour modifier le seuil
        SeekBar seekBar = findViewById(R.id.seek_Bar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seuil = (float) progress /10;
                TextView textView = findViewById(R.id.textView2);
                textView.setText("Seuil : " + seuil);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() != Sensor.TYPE_LINEAR_ACCELERATION){
            return;
        }
        float x =event.values[0];
        float y =event.values[1];
        float z =event.values[2];

        float magnetude = (float) Math.sqrt(x*x + y*y + z*z);

        RelativeLayout layout = findViewById(R.id.main);
        if(magnetude > seuil){
            layout.setBackgroundColor(0xFFFF0000); //couelur rouge
        }else if(magnetude < seuil){
            layout.setBackgroundColor(0xFF00FF00); //couleur verte
        }else if(magnetude == seuil){
            layout.setBackgroundColor(0xFF000000); //couleur noire
        }else{
            layout.setBackgroundColor(0xFFFFFFFF); //couleur blanche
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}