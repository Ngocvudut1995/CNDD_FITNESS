package com.example.vudang.fitness.Model;

import android.app.Application;

/**
 * Created by VuDang on 11/05/17.
 */

public class MyApp  extends Application{
    Setting setting;

    public MyApp() {
//        System.out.println("MyApp");
//        DBHandler db = new DBHandler(this);
//        this.setting = db.getSetting();
    }

    public Setting getSetting() {
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }
}
