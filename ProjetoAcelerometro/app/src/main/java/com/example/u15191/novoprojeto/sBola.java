package com.example.u15191.novoprojeto;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import org.locationtech.jts.geom.Coordinate;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by u15191 on 26/04/2017.
 */

public class sBola extends View {

    public float x;
    public float y;
    public float z;

    public float getxInMap1() {
        return xInMap1;
    }

    public void setxInMap1(float xInMap1) {
        this.xInMap1 = xInMap1;
    }

    public float getyFinMap1() {
        return yFinMap1;
    }

    public void setyFinMap1(float yFinMap1) {
        this.yFinMap1 = yFinMap1;
    }

    public float getyInMap1() {
        return yInMap1;
    }

    public void setyInMap1(float yInMap1) {
        this.yInMap1 = yInMap1;
    }

    public float getxFinMap1() {
        return xFinMap1;
    }

    public void setxFinMap1(float xFinMap1) {
        this.xFinMap1 = xFinMap1;
    }

    public float getxInMap2() {
        return xInMap2;
    }

    public void setxInMap2(float xInMap2) {
        this.xInMap2 = xInMap2;
    }

    public float getyInMap2() {
        return yInMap2;
    }

    public void setyInMap2(float yInMap2) {
        this.yInMap2 = yInMap2;
    }

    public float getyFinMap2() {
        return yFinMap2;
    }

    public void setyFinMap2(float yFinMap2) {
        this.yFinMap2 = yFinMap2;
    }

    public float getxFinMap2() {
        return xFinMap2;
    }

    public void setxFinMap2(float xFinMap2) {
        this.xFinMap2 = xFinMap2;
    }

    public float xInMap1;
    public float yInMap1;
    public float yFinMap1;
    public float xFinMap1;
    public float xInMap2;
    public float yInMap2;
    public float yFinMap2;
    public float xFinMap2;

    private Paint paint = new Paint();
    private Paint paint2 = new Paint();
    private Path path   = new Path();
    private Random random = new Random();
    private Boolean primeiraVez = true;
    private LinkedList<Coordinate> linhas1;
    private LinkedList<Coordinate> linhas2;
    private static float DELTA_Y = 30;
    private static float MAX_DELTA_X = 4 * DELTA_Y;

    public sBola(Context context, AttributeSet attrs, float xs, float ys)
    {
        super(context,attrs);

        x = xs;
        y = ys;
        z =  65;

        this.setxInMap1(370);
        this.setyInMap1(1700);
        this.setxFinMap1(370);
        this.setyFinMap1(-200);
        this.setxInMap2(720);
        this.setyInMap2(1700);
        this.setxFinMap2(720);
        this.setyFinMap2(-200);


        paint.setAntiAlias(true);
        paint.setStrokeWidth(6f);
        paint.setTextSize(30);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeJoin(Paint.Join.ROUND);

        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(20f);
        paint2.setColor(Color.BLUE);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setStrokeJoin(Paint.Join.ROUND);

        linhas1 = new LinkedList<>();
        linhas2 = new LinkedList<>();

        linhas1.addFirst(new Coordinate(xInMap1, yInMap1));
        linhas2.addFirst(new Coordinate(xInMap2, yInMap2));
        linhas1.addFirst(new Coordinate(xFinMap1, yFinMap1));
        linhas2.addFirst(new Coordinate(xFinMap2, yFinMap2));

    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        if(z >= 0) {
            canvas.drawCircle(x, y, 65, paint);
            canvas.drawText("x: " + this.getXBolinha() + "  y: " + this.getYBolinha(), 160, 100, paint);
            generatePoints();
            desenharLinha(canvas);
        }
    }

    public void setXBolinha(float novox)
    {
        x = novox;
    }

    public void setYBolinha(float novoy)
    {
        y = novoy;
    }

    public float getXBolinha()
    {
        return x;
    }
    public float getYBolinha()
    {
        return y;
    }

    private void generatePoints() {
            for (Coordinate g:
                    linhas1){
                g.y += 6;
            }

            for (Coordinate g:
                    linhas2){
                g.y += 6;
            }

        float deltaX = random.nextInt((int) MAX_DELTA_X) - MAX_DELTA_X/2 + 11/MAX_DELTA_X ;

        Coordinate cn1 = new Coordinate(linhas1.getFirst().x + deltaX, linhas1.getFirst().y - DELTA_Y);
        Coordinate cn2 = new Coordinate(linhas2.getFirst().x + deltaX, linhas2.getFirst().y - DELTA_Y);

        linhas1.addFirst(cn1);
        linhas2.addFirst(cn2);

        if (linhas1.getLast().y > yInMap1) {
            linhas1.removeLast();
            linhas2.removeLast();
        }
    }

    private void desenharLinha(Canvas c){
            Coordinate g = null;
            for (Coordinate h:
                    linhas1){
                if (g == null){
                    g = h;
                    continue;
                }
                c.drawLine(((float) g.x), ((float) g.y), ((float) h.x), ((float) h.y), paint2);
                g = h;
            }

        g = null;
            for (Coordinate h:
                    linhas2){
                if (g == null){
                    g = h;
                    continue;
                }
                c.drawLine(((float) g.x), ((float) g.y), ((float) h.x), ((float) h.y), paint2);
                g = h;
        }
    }
}
