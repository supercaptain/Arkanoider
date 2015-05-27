package com.example.adam.arkanoider;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Adam on 17.05.2015.
 */
public class Block {

    private int x;
    private int y;
    private int sizeX;
    private int sizeY;
    private Bitmap bitmap;
    Rect r;


    public Block(int x, int y, int sizeX, int sizeY, Bitmap bitmap){
        setX(x);
        setY(y);
        setSizeX(sizeX);
        setSizeY(sizeY);
        setBitmap(bitmap);
        r = new Rect(getX(),getY(),getX() + getSizeX(), getY()+getSizeY());

    }

    public void drawBlock(Canvas canvas){
        //canvas.drawBitmap(getBitmap(), getX(), getY() , null);

        Paint p = new Paint();
        p.setColor(Color.RED);

        canvas.drawRect(r,p);
        //canvas.drawBitmap(getBitmap(), getX(), getY() , null);
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

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
