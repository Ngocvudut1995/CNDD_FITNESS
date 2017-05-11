package com.example.vudang.fitness;

import android.app.Application;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.vudang.fitness.Model.DBHandler;
import com.example.vudang.fitness.Model.Exersice;
import com.example.vudang.fitness.Model.MyApp;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DemoActivity extends AppCompatActivity {
   // private Chronometer chronometer;
    TextView txt_countdown;
    private static final String FORMAT = "%02d";

    int seconds , minutes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_demo);
//      txt_countdown = (TextView) findViewById(R.id.txt_countdown);
//        new CountDownTimer(30000, 1000) { // adjust the milli seconds here
//
//            public void onTick(long millisUntilFinished) {
//                txt_countdown.setText(""+millisUntilFinished/1000);
////                txt_countdown.setText(""+String.format(FORMAT,
////                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
////                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
////                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
////                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
////                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
//            }
//
//            public void onFinish() {
//                txt_countdown.setText("done!");
//            }
//        }.start();
        DBHandler db = new DBHandler(this);
       MyApp myapp = ((MyApp) getApplicationContext());
        myapp.setSetting(db.getSetting());

        // Reading all shops
        //db.addExersice(new Exersice(0,"Full Body","1,2,3,4,5"));
        //  db.addExersice(new Exersice(0,"Stretch Easy","1,2,3,4,5"));
        Log.d("Reading: ", "Reading all shops..");
        List<Exersice> list = db.getAllExersice();

        for (Exersice item : list) {
            String log = "Id: " + item.getIDExersice() + " ,Name: " + item.getNameExersice() + " ,Address: " + item.getListIDItemExersice();
// Writing shops to log
            Log.d("Exersice: : ", log);
        }
    }
}
