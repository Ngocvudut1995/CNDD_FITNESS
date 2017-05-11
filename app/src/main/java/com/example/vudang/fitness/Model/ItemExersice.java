package com.example.vudang.fitness.Model;

/**
 * Created by VuDang on 10/05/17.
 */

public class ItemExersice {
    private int IDItemExersice;
    private String NameItemExersice;
    private String Image;

    public int getIDItemExersice() {
        return IDItemExersice;
    }

    public void setIDItemExersice(int IDItemExersice) {
        this.IDItemExersice = IDItemExersice;
    }

    public ItemExersice() {
    }

    public ItemExersice(int IDItem, String nameItemExersice, String image) {
        this.IDItemExersice = IDItem;
        NameItemExersice = nameItemExersice;
        Image = image;
    }



    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getNameItemExersice() {
        return NameItemExersice;
    }

    public void setNameItemExersice(String nameItemExersice) {
        NameItemExersice = nameItemExersice;
    }
}
