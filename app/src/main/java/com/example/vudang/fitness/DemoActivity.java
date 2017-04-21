package com.example.vudang.fitness;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Chronometer;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class DemoActivity extends AppCompatActivity {
   // private Chronometer chronometer;
    TextView txt_countdown;
    private static final String FORMAT = "%02d";

    int seconds , minutes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
      txt_countdown = (TextView) findViewById(R.id.txt_countdown);
        new CountDownTimer(30000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {
                txt_countdown.setText(""+millisUntilFinished/1000);
//                txt_countdown.setText(""+String.format(FORMAT,
//                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
//                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
//                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
//                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
//                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                txt_countdown.setText("done!");
            }
        }.start();
    }

}
