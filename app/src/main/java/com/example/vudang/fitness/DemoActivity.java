package com.example.vudang.fitness;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.vudang.fitness.Model.DBHandler;
import com.example.vudang.fitness.Model.Exersice;
import com.example.vudang.fitness.Model.MyApp;
import com.example.vudang.fitness.Util.AlarmReceiver;
import com.example.vudang.fitness.Util.MyAlarmService;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DemoActivity extends AppCompatActivity {
   // private Chronometer chronometer;

    static private PendingIntent pendingIntent;
    Button set_reminder,unset_reminder;
    TimePicker timePicker;
    TextView txt_status;
    Context context;
    AlarmManager alarmManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_reminder);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        txt_status =(TextView) findViewById(R.id.txt_status);
        set_reminder = (Button) findViewById(R.id.btn_setReminder);
        unset_reminder = (Button) findViewById(R.id.btn_unsetReminder);
        this.context = this;
        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

       // alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        set_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                //calendar.setTimeInMillis(System.currentTimeMillis());
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();
                System.out.println("AM:"+timePicker.getHour());
                calendar.set(Calendar.YEAR,2017);
                calendar.set(Calendar.HOUR_OF_DAY,hour);
                calendar.set(Calendar.MINUTE,minute);
                System.out.println(calendar.getTimeInMillis());
                txt_status.setText("Alarm set to "+hour+":"+minute);
                Intent myIntent = new Intent(DemoActivity.this, MyAlarmService.class);
                myIntent.putExtra("status","on");
                myIntent.putExtra("hour",hour);
                myIntent.putExtra("minute",minute);
                pendingIntent = PendingIntent.getService(DemoActivity.this, 0, myIntent, 0);
               alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY, pendingIntent);
               // alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
//
//                Intent intent = new Intent(context,AlarmReceiver.class);
//                pendingIntent = PendingIntent.getBroadcast(DemoActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
//                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            }
        });
        unset_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                txt_status.setText("Alarm off!");
                Intent myIntent = new Intent(DemoActivity.this, MyAlarmService.class);
                myIntent.putExtra("status","off");
                //pendingIntent = PendingIntent.getService(DemoActivity.this, 0, myIntent, 0);
                stopService(myIntent);

                pendingIntent = PendingIntent.getService(DemoActivity.this, 0, myIntent, 0);
              //  alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                if(alarmManager!=null){
                    System.out.println("Cancel");
                    alarmManager.cancel(pendingIntent);
                }

            }
        });
//        Button buttonStart = (Button)findViewById(R.id.startalarm);
//
//        Button buttonCancel = (Button)findViewById(R.id.cancelalarm);
//
//
//
//        buttonStart.setOnClickListener(new Button.OnClickListener(){
//
//
//
//            @Override
//
//            public void onClick(View arg0) {
//
//                // TODO Auto-generated method stub
//
//
//
//                Intent myIntent = new Intent(DemoActivity.this, MyAlarmService.class);
//
//                pendingIntent = PendingIntent.getService(DemoActivity.this, 0, myIntent, 0);
//
//
//
//                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
//
//                Calendar calendar = Calendar.getInstance();
//
//                calendar.setTimeInMillis(System.currentTimeMillis());
//
//                calendar.add(Calendar.SECOND, 20);
//
//                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
//
//
//
//                Toast.makeText(DemoActivity.this, "Start Alarm", Toast.LENGTH_LONG).show();
//
//            }});
//
//
//
//        buttonCancel.setOnClickListener(new Button.OnClickListener(){
//
//
//
//            @Override
//
//            public void onClick(View arg0) {
//
//                // TODO Auto-generated method stub
//
//                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
//
//                alarmManager.cancel(pendingIntent);
//
//
//
//                // Tell the user about what we did.
//
//                Toast.makeText(DemoActivity.this, "Cancel!", Toast.LENGTH_LONG).show();
//
//
//
//
//
//            }});
//
//
//
   }

}
