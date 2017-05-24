package com.example.u15191.novoprojeto;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

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

    public sBola(Context context, AttributeSet attrs, float xs, float ys)
    {
        super(context,attrs);

        x = xs;
        y = ys;
        z =  65;


        paint.setAntiAlias(true);
        paint.setStrokeWidth(6f);
        paint.setTextSize(30);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeJoin(Paint.Join.ROUND);

        this.setxInMap1(370);
        this.setyInMap1(1700);
        this.setxFinMap1(370);
        this.setyFinMap1(-200);
        this.setxInMap2(720);
        this.setyInMap2(1700);
        this.setxFinMap2(720);
        this.setyFinMap2(-200);


        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(20f);
        paint2.setColor(Color.BLUE);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setStrokeJoin(Paint.Join.ROUND);


    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        if(z >= 0)
        {
            canvas.drawCircle(x,y,65,paint);
            canvas.drawText("x: "+this.getXBolinha()+"  y: "+this.getYBolinha(),160,100,paint);
//            int i = 0;
//            do{
                canvas.drawLine(this.xInMap1 , this.yInMap1,this.xFinMap1, this.yFinMap1, paint2);
                canvas.drawLine(this.xInMap2 , this.yInMap2,this.xFinMap2, this.yFinMap2, paint2);
//                i++;
//                this.xInMap1 = this.xFinMap1;
//                this.xInMap2 = this.xFinMap2;
//                this.yInMap1  = this.yFinMap1;
//                this.xFinMap1 = random.nextInt(100);
//                this.xFinMap2 = this.xFinMap1 + 350;
//                this.yFinMap1 = this.yInMap1 + 350;
//
//            }while(i<2);


        }
//        if(primeiraVez)
//        {
//            drawMap(canvas);
//            primeiraVez = false;
//        }



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




    protected void drawMap(Canvas canvas)
    {
//        int i=0;
//        int xin1 = 200;
//        int xin2 = 400;
//        int yin = 1380;
//
//        int xfin1 = 200;
//        int xfin2 = 400;
//        int yfin  =-200;
//
//        canvas.drawLine(xin1,yin,xfin1,yfin,paint2);
//        canvas.drawLine(xin2,yin,xfin2,yfin,paint2);

//        do {
//            canvas.drawLine(xin1,yin,xfin1,yfin,paint2);
//            canvas.drawLine(xin2,yin,xfin2,yfin,paint2);
//            xin1 = xfin1;
//            xin2 = xfin2;
//            yin  = yfin;
//            xfin1 = random.nextInt(100);
//            xfin2 = xfin1 + 200;
//            yfin = yin + 200;
//        }while(i<20);

    }


}
