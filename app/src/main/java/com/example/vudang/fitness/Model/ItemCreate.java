package com.example.vudang.fitness.Model;

/**
 * Created by PC on 5/13/2017.
 */

public class ItemCreate {
    private int ImageCreate;
    private String txtNameCreate;
    private boolean checkboxCreate;

    public ItemCreate(int imageCreate, String txtNameCreate, boolean checkboxCreate) {
        ImageCreate = imageCreate;
        this.txtNameCreate = txtNameCreate;
        this.checkboxCreate = checkboxCreate;
    }

    public int getImageCreate() {
        return ImageCreate;
    }

    public void setImageCreate(int imageCreate) {
        ImageCreate = imageCreate;
    }

    public String getTxtNameCreate() {
        return txtNameCreate;
    }

    public void setTxtNameCreate(String txtNameCreate) {
        this.txtNameCreate = txtNameCreate;
    }

    public boolean getCheckboxCreate() {
        return checkboxCreate;
    }

    public void setCheckboxCreate(boolean checkboxCreate) {
        this.checkboxCreate = checkboxCreate;
    }
}
