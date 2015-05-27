package com.example.adam.arkanoider;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;


public class GameActivity extends ActionBarActivity {

    GameView g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_game);
        g =  new GameView(this);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(g);

    }

    @Override
    protected void onPause(){
        super.onPause();
        g.gamethread.setRunning(false);
        //g.gamethread.interrupt();
    }

    @Override
    protected void onResume(){
        super.onResume();
        g.gamethread.setRunning(true);

    }

    @Override
    protected void onRestart() {
        super.onRestart();  // Always call the superclass method first

        g.gamethread.setRunning(true);

    }


    @Override
    protected void onStart(){
        super.onStart();
        g.gamethread.setRunning(true);
        //g.gamethread.interrupt();
    }

    @Override
    protected void onStop(){
        super.onStop();
        g.gamethread.setRunning(false);
        //g.gamethread.interrupt();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        g.gamethread.setRunning(false);
        //g.gamethread.interrupt();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
