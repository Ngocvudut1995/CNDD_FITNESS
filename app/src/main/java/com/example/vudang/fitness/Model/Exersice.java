package com.example.vudang.fitness.Model;

/**
 * Created by VuDang on 10/05/17.
 */

public class Exersice {
    private int IDExersice;
    private String NameExersice;
    private String ListIDItemExersice;
    public Exersice() {

    }
    public Exersice(int IDExersice, String nameExersice, String listIDItemExersice) {
        this.IDExersice = IDExersice;
        NameExersice = nameExersice;
        ListIDItemExersice = listIDItemExersice;
    }

    public int getIDExersice() {
        return IDExersice;
    }

    public void setIDExersice(int IDExersice) {
        this.IDExersice = IDExersice;
    }

    public String getNameExersice() {
        return NameExersice;
    }

    public void setNameExersice(String nameExersice) {
        NameExersice = nameExersice;
    }

    public String getListIDItemExersice() {
        return ListIDItemExersice;
    }

    public void setListIDItemExersice(String listIDItemExersice) {
        ListIDItemExersice = listIDItemExersice;
    }
}
