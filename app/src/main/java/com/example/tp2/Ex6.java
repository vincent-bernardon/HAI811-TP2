package com.example.tp2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ex6 extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor sensor;

    private void displayAccelerometer(){
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        displayAccelerometer();

        setContentView(R.layout.activity_ex6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() != Sensor.TYPE_PROXIMITY){
            return;
        }
        float distance = event.values[0];
        TextView textView = findViewById(R.id.textView);
        textView.setText("Distance : " + distance +" cm");
        System.out.println("Distance : " + distance);

        ImageView imageView = findViewById(R.id.imageView);

        if (distance >= 10) {
            imageView.setVisibility(ImageView.GONE);
        } else {
            imageView.setVisibility(ImageView.VISIBLE);
            int size = (int) ((10 - distance) * 100);
            imageView.getLayoutParams().width = size;
            imageView.getLayoutParams().height = size;
            imageView.requestLayout();
        }




    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}