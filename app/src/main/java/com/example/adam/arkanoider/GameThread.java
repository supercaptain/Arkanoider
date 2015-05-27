package com.example.adam.arkanoider;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

/**
 * Created by Adam on 24.1.2015.
 */
public class GameThread extends  Thread {

    private static final String LOGGER = GameThread.class.getSimpleName();
    private boolean running;
    SurfaceHolder surfaceholder;
    GameView gameview;
    Ball ball;

    public GameThread(SurfaceHolder holder, GameView gameview, Ball ball){
        this.surfaceholder = holder;
        this.gameview = gameview;
        this.ball = ball;
    }

    @Override
    public void run(){
        Canvas canvas = null;
        long tick = 0;
        while (isRunning()){
           // tick++;
            try{
                canvas = surfaceholder.lockCanvas();
                synchronized (surfaceholder){
                    this.gameview.ball.moveBall();
                    Physic.checkColision(gameview.ball, gameview.rider);
                    this.gameview.draw(canvas);
                }
            }
            finally {
                if(canvas != null){
                    surfaceholder.unlockCanvasAndPost(canvas);
                }
            }


           // Log.d("GP","Gameloop num"  + tick );
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
