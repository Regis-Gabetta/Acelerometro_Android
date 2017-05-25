package com.example.u15191.novoprojeto;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;

    private TextView txtUm;
    private TextView txtDois;
    private TextView txtTres;
    private FazTudo fazTudo;
    Canvas canvas = new Canvas();
    private Paint paint = new Paint();
    private float velX = 0;
    private float velY = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fazTudo = new FazTudo(this, null, 540, 1200);
        setContentView(fazTudo);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME);

        paint.setAntiAlias(true);
        paint.setStrokeWidth(6f);
        paint.setTextSize(150);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            velX = event.values[0];
            velY = event.values[1];
            float z = 45;

            fazTudo.translateBola((-5) * velX, 5 * velY);

            if (fazTudo.isColidiu())
                Log.println(Log.INFO, "Hue", "Morrrreu");


            if (fazTudo.getXBola() > 66 && fazTudo.getYBola() > 66 && fazTudo.getXBola() < 1011 && fazTudo.getYBola() < 1467)
                fazTudo.invalidate();
            else
                fazTudo.translateBola((5) * velX, (-5) * velY);

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}

