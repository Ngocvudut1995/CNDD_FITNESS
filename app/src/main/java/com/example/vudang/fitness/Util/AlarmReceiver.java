package com.example.vudang.fitness.Util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

/**
 * Created by VuDang on 13/05/17.
 */

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
//        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
//            System.out.println("Alarm !!!!");
//        }

        System.out.println("Start Alarm!");
        Intent service_intent = new Intent(context,MyAlarmService.class);
        context.startService(service_intent);
    }
}
