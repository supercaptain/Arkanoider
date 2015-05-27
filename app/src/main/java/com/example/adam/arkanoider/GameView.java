package com.example.adam.arkanoider;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;


public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    public GameThread gamethread;
    Context context;
    int color;
    int c = 1;
    Ball ball;
    Rider rider;
    List<Block> listblocks;

    public GameView(Context context){
        super(context);
        getHolder().addCallback(this);
        ball = new Ball(20,20,20, Color.YELLOW, BitmapFactory.decodeResource(getResources(),R.drawable.ball ), this );
        rider = new Rider(500,1150, 200,28, BitmapFactory.decodeResource(getResources(), R.drawable.rider));
        listblocks = initBlock();
        gamethread = new GameThread(getHolder(),this, ball);

        //for handle events
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        gamethread.setRunning(true);
        gamethread.start();
    }


    //For destroy surface
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean repeat = true;
        Log.d("GameView", "Surface starts destroy itself.");
        while (repeat){
            try {
                gamethread.join();
                repeat = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d("GameView", "Surface is destroyed. Clean way.");
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

   //pouze pro testovani
   public  List<Block>  initBlock(){
       List<Block> listblocks = new ArrayList<>();
       //                   200     257
       Block b1 = new Block(200,100, 57,25, BitmapFactory.decodeResource(getResources(), R.drawable.block));
       Block b2 = new Block(300,100, 57,25, BitmapFactory.decodeResource(getResources(), R.drawable.block));

       Block b3 = new Block(200,300, 57,25, BitmapFactory.decodeResource(getResources(), R.drawable.block));
       Block b4 = new Block(400,300, 57,25, BitmapFactory.decodeResource(getResources(), R.drawable.block));

       listblocks.add(b1);
       listblocks.add(b2);
       listblocks.add(b3);
       listblocks.add(b4);

       return listblocks;
   }


    public void draw(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        //canvas.drawColor(this.color);
        /*
        for(Block item : this.listblocks){
            item.drawBlock(canvas);
        }
        */
        rider.drawRider(canvas);
        ball.draw(canvas);



         //Log.d("T", "Sirka " + getWidth()  + " Vyska " + getHeight());
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){

        float x = e.getX();
        float y = e.getY();
       // Log.d("souradnice", "X:" + x +  " Y:" + y);

        if(e.getAction() == MotionEvent.ACTION_MOVE ){
            /*
            rider.setX((int)x - rider.getSizeX()/2);
            rider.r.left = (int)x - rider.getSizeX()/2;
            rider.r.right = (int)x + rider.getSizeX()/2;
            */
            rider.setX((int)x);
            rider.r.left = (int)x ;
            rider.r.right = (int)x + rider.getSizeX() ;


        }
        return true;
    }
}
