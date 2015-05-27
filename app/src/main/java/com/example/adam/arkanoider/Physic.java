package com.example.adam.arkanoider;

import android.util.Log;

/**
 * Created by Adam on 26.1.2015.
 */
public class Physic {




    public static  void checkColision(Ball ball,Rider rider){

        if(rider.r.intersect(ball.getBall())){

            Log.d("Kolize", "Kolize nastala na " + ball.getX() + " " + ball.getY());

            ball.setVectorY(-ball.getVectorY());
        }

    }

}
