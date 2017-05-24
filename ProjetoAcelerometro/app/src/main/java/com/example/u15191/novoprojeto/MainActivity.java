package com.example.u15191.novoprojeto;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;

    private TextView txtUm;
    private TextView txtDois;
    private TextView txtTres;
    private sBola bolinha;
    Canvas canvas = new Canvas();
    private Paint paint = new Paint();
    private float  velX = 0;
    private float  velY = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bolinha = new sBola(this,null,100,100);
        setContentView(bolinha);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME);

        paint.setAntiAlias(true);
        paint.setStrokeWidth(6f);
        paint.setTextSize(150);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    public void onPause()
    {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onStop()
    {
        super.onStop();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            velX = event.values[0];
            velY = event.values[1];
            float z = 45;

            bolinha.setXBolinha(bolinha.getXBolinha()-5*velX);
            bolinha.setYBolinha(bolinha.getYBolinha()+5*velY);

//            bolinha.setyInMap1(bolinha.getyInMap1() + 2);
//            bolinha.setyFinMap1(bolinha.getyFinMap1() + 2);
//            bolinha.setyInMap2(bolinha.getyInMap2() + 2);
//            bolinha.setyFinMap2(bolinha.getyFinMap2() + 2);

            if(bolinha.getXBolinha() > 66 && bolinha.getYBolinha() > 66 && bolinha.getXBolinha() <1011 && bolinha.getYBolinha() <1467)
            {
                bolinha.invalidate();
            }
            else
            {
                bolinha.setXBolinha(bolinha.getXBolinha()+5*velX);
                bolinha.setYBolinha(bolinha.getYBolinha()-5*velY);

                velX = 0;
                velY = 0;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}

