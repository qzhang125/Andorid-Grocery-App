package com.example.map524_assignment1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

public class Stores {
    public String storeName;
    public String address;
    public Bitmap image;
    public Integer status;
    public Bitmap checkImg;

    Stores(String name, String address, Bitmap image){
        this.storeName = name;
        this.address = address;
        this.image = image;
        //Set random number between 0 and 1 to the status
        this.status = new Random().nextInt(2);
    }

    public void setCheckBox(Bitmap checkImage){
        this.checkImg = checkImage;
    }
}

