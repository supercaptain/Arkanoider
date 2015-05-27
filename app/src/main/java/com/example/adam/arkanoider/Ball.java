package com.example.adam.arkanoider;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.Log;
import android.view.View;

/**
 * Created by Adam on 24.1.2015.
 */
public class Ball {

    Bitmap bitmap;
    private Rect ball;
    private int x;
    private int y;

    private int size;
    private int color;
    private int vectorX;
    private int vectorY;

    public View view;


    public Ball(int x, int y, int size, int color, Bitmap bitmap, View view){
        this.bitmap = bitmap;
        this.view = view;
        setX(x);
        setY(y);
        setSize(size);
        setVectorX(2);
        setVectorY(2);
        setBall(new Rect(getX(),getY(),getX()+getSize(),getY()+getSize()));

    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(bitmap, getX() - (bitmap.getWidth() / 2), getY() - (bitmap.getHeight() / 2), null);
       // canvas.drawBitmap(bitmap,getX(),getY(),null);


    }

    public void moveBall(){
        int speed = 0;

        //VEKTOR X  - 0
        if(x <= 0 && vectorX < 0)
            vectorX = -vectorX;
        //VEKTOR X  - WIDTH
        if(x + getSize() == view.getWidth() && vectorX > 0)
            vectorX = -vectorX;

        //VEKTOR Y  - 0
        if(y <= 0 && vectorY < 0 )
            vectorY = -vectorY;

        if(y + getSize() == view.getHeight() && vectorY > 0)
            vectorY = -vectorY;

        //pos.set(pos.x + vectorX, pos.y + vectorY);
        x = x + vectorX + speed;
        y = y + vectorY + speed;

        setBall(new Rect(getX(),getY(),getX()+getSize(),getY()+getSize()));

        ball.left = x;
        ball.right = x + getSize();

        ball.top = y;
        ball.bottom= y + getSize();
        //Log.d("T", "x " + x + "y " + y);

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getVectorX() {
        return vectorX;
    }

    public void setVectorX(int vectorX) {
        this.vectorX = vectorX;
    }

    public int getVectorY() {
        return vectorY;
    }

    public void setVectorY(int vectorY) {
        this.vectorY = vectorY;
    }

    public Rect getBall() {
        return ball;
    }

    public void setBall(Rect ball) {
        this.ball = ball;
    }
}
