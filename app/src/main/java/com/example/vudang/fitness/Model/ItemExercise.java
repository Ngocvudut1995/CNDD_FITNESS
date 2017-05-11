package com.example.vudang.fitness.Model;

import android.support.v7.widget.RecyclerView;

/**
 * Created by TU on 5/10/2017.
 */

public class ItemExercise {
    private int image;
    private String Name;
    private String decription;

    public ItemExercise(int image, String name, String decription) {
        this.image = image;
        Name = name;
        this.decription = decription;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }
}
