package com.example.vudang.fitness.Model;

import android.app.Application;

/**
 * Created by VuDang on 11/05/17.
 */

public class Setting  {
    private int time_running ;
    private int time_break;
    private boolean sound;
    private String color;

    public Setting() {

    }

    public int getTime_running() {
        return time_running;
    }

    public void setTime_running(int time_running) {
        this.time_running = time_running;
    }

    public int getTime_break() {
        return time_break;
    }

    public void setTime_break(int time_break) {
        this.time_break = time_break;
    }

    public boolean isSound() {
        return sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
