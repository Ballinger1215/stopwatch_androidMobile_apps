package com.afad.stopwatch;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class StopwatchActivity extends Activity {

    private int seconds = 0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        runTimer();
    }

    //start the stopwatch running when the Start button in clicked.

    public void onClickStart(View view) {

        running = true;
    }

    //stop the stopwatch running when the Stop button is clicked.

    public void onClickStop(View view) {

        running = false;

    }

    //reset the stopwatch when the Reset button is clicked.

    public void onclickReset(View view) {

        running = false;
        seconds = 0;

    }

    private void runTimer() {

        final TextView timeView = (TextView) findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {

            @Override
            public void run() {

                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format("%d:%02d:%02d",
                        hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                seconds++;
            }

            handler.postDelayed(this,1000);
        }
    });
 }
}
