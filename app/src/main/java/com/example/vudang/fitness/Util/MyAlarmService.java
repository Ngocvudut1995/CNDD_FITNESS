package com.example.vudang.fitness.Util;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.vudang.fitness.Activity.RestFragment;
import com.example.vudang.fitness.DemoActivity;
import com.example.vudang.fitness.MainActivity;
import com.example.vudang.fitness.R;

import java.util.Calendar;

public class MyAlarmService extends Service {
    public MyAlarmService() {
    }
    MediaPlayer mediaPlayer;
    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        String status = intent.getStringExtra("status");
        System.out.println("Start Service!");
        if(status.equals("on")){
            System.out.println("Alarm on!");
            mediaPlayer = MediaPlayer.create(this, R.raw.track1);
            mediaPlayer.start();
            NotificationManager notify_manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            Intent intent_main = new Intent(this.getApplicationContext(), MainActivity.class);
            intent_main.putExtra("reminder",true);
            PendingIntent pendingIntent_main = PendingIntent.getActivity(this,0,intent_main,PendingIntent.FLAG_UPDATE_CURRENT);
            Notification notification = new Notification.Builder(this).setContentTitle("An alarm is going off")
                    .setContentText("Click me!").setContentIntent(pendingIntent_main).setAutoCancel(true).
                            setSmallIcon(R.drawable.ic_action_name).build();
            notify_manager.notify(0,notification);
            new CountDownTimer(9*1000, 1000) { // adjust the milli seconds here
                public void onTick(long millisUntilFinished) {

                }

                public void onFinish() {
                    mediaPlayer.stop();
//                   AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
//                    Calendar calendar = Calendar.getInstance();
//                    //calendar.setTimeInMillis(System.currentTimeMillis());
//                    int hour = intent.getIntExtra("hour",0);
//                    int minute = intent.getIntExtra("minute",0);
//
//                    calendar.set(Calendar.HOUR_OF_DAY,hour);
//                    calendar.set(Calendar.MINUTE,minute);
//                    System.out.println(calendar.getTimeInMillis());
//                   // txt_status.setText("Alarm set to "+hour+":"+minute);
//                    Intent myIntent = new Intent(getApplicationContext(), MyAlarmService.class);
//                    myIntent.putExtra("status","on");
//                    myIntent.putExtra("hour",hour);
//                    myIntent.putExtra("minute",minute);
//                    PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 0, myIntent, 0);
//                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),1000 * 10, pendingIntent);
                   onDestroy();
                }
            }.start();

        }else if(status.equals("off"))
        {
            System.out.println("Alarm stop!");
            mediaPlayer = MediaPlayer.create(this, R.raw.track1);
            mediaPlayer.stop();
            onDestroy();
        }

        return START_NOT_STICKY;
    }

    @Override

    public void onCreate() {

// TODO Auto-generated method stub

        Toast.makeText(this, "MyAlarmService.onCreate()", Toast.LENGTH_LONG).show();

    }



    @Override

    public IBinder onBind(Intent intent) {

// TODO Auto-generated method stub

        Toast.makeText(this, "MyAlarmService.onBind()", Toast.LENGTH_LONG).show();

        return null;

    }



    @Override

    public void onDestroy() {

// TODO Auto-generated method stub

        super.onDestroy();
        System.out.println("Destroy Service!");
        Toast.makeText(this, "MyAlarmService.onDestroy()", Toast.LENGTH_LONG).show();

    }



    @Override

    public void onStart(Intent intent, int startId) {

// TODO Auto-generated method stub

        super.onStart(intent, startId);

        Toast.makeText(this, "MyAlarmService.onStart()", Toast.LENGTH_LONG).show();

    }



    @Override

    public boolean onUnbind(Intent intent) {

// TODO Auto-generated method stub

        Toast.makeText(this, "MyAlarmService.onUnbind()", Toast.LENGTH_LONG).show();

        return super.onUnbind(intent);

    }
}
