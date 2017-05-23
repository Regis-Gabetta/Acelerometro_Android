package com.example.u15191.novoprojeto;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by u15191 on 26/04/2017.
 */

public class sBola extends View {

    public float x;
    public float y;
    public float z;

    private Paint paint = new Paint();
    private Path path   = new Path();

    public sBola(Context context, AttributeSet attrs, float xs, float ys)
    {
        super(context,attrs);

        x = xs;
        y = ys;
        z =  65;

        paint.setAntiAlias(true);
        paint.setStrokeWidth(6f);
        paint.setTextSize(150);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeJoin(Paint.Join.ROUND);


    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        if(z >= 0)
        {
            canvas.drawCircle(x,y,65,paint);
        }
    }


    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float xs = event.values[0];
            float ys = event.values[1];

            x = xs;
            y = ys;

            invalidate();
        }
    }


}
