package com.example.vudang.fitness.Activity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.vudang.fitness.DemoActivity;
import com.example.vudang.fitness.R;
import com.example.vudang.fitness.Util.AlarmReceiver;
import com.example.vudang.fitness.Util.MyAlarmService;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

public class ReminderFragment extends Fragment {
    private PendingIntent pendingIntent;
    Button set_reminder,unset_reminder;
    TimePicker timePicker;
    TextView txt_status;
    AlarmManager alarmManager;
    public ReminderFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_reminder, container, false);
        Context context = getActivity().getApplicationContext();
        timePicker = (TimePicker)rootView.findViewById(R.id.timePicker);
        txt_status =(TextView) rootView.findViewById(R.id.txt_status);
        set_reminder = (Button) rootView.findViewById(R.id.btn_setReminder);
        unset_reminder = (Button) rootView.findViewById(R.id.btn_unsetReminder);

        alarmManager = (AlarmManager)getActivity().getSystemService(ALARM_SERVICE);

        // alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        set_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                //calendar.setTimeInMillis(System.currentTimeMillis());
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();
                System.out.println("AM:"+timePicker.getHour());
                calendar.set(Calendar.HOUR_OF_DAY,hour);
                calendar.set(Calendar.MINUTE,minute);
                System.out.println(calendar.getTimeInMillis());
                txt_status.setText("Alarm set to "+hour+":"+minute);
                Intent myIntent = new Intent(getActivity().getApplicationContext(), MyAlarmService.class);
                myIntent.putExtra("status","on");
                myIntent.putExtra("hour",hour);
                myIntent.putExtra("minute",minute);
                pendingIntent = PendingIntent.getService(getActivity().getApplicationContext(), 0, myIntent, 0);
                if (Calendar.getInstance().after(calendar)) {
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                }
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY, pendingIntent);
               //alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
//
//                Intent intent = new Intent(context,AlarmReceiver.class);
//                pendingIntent = PendingIntent.getBroadcast(DemoActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
//                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            }
        });
        unset_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmManager = (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);
                txt_status.setText("Alarm off!");
                Intent myIntent = new Intent(getActivity().getApplicationContext(), MyAlarmService.class);
                myIntent.putExtra("status","off");
                //pendingIntent = PendingIntent.getService(DemoActivity.this, 0, myIntent, 0);
                getActivity().stopService(myIntent);

                pendingIntent = PendingIntent.getService(getActivity().getApplicationContext(), 0, myIntent, 0);
                //  alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                if(alarmManager!=null){
                    System.out.println("Cancel");
                    alarmManager.cancel(pendingIntent);
                }

            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
