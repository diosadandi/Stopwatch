package com.hfad.stopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends Activity {

    private int seconds = 0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
    }

    //start the stopwatch running when the start button is clicked
    public void onClickStart(View view){
        running = true;
    }

    //stop the stopwatch running when the stop button is clicked
    public void onClickStop(View view){
        running = false;
    }

    //reset the stopwatch running when the reset button is clicked
    public void onClickReset(View view){
        running = false;
        seconds = 0;
    }

    //sets the number of seconds timer
    private void runTimer(){
        final TextView timeView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;

                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, secs);

                timeView.setText(time);
                if (running)
                {
                    seconds++;
                }

                handler.postDelayed(this, 1000);
            }
        });
    }
}