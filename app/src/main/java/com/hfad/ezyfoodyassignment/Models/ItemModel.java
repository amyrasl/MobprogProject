package com.hfad.ezyfoodyassignment.Models;

import java.io.Serializable;

public class ItemModel implements Serializable {
    int image;
    String itemname;
    String itemprice;

    public ItemModel(int image, String itemname, String itemprice) {
        this.image = image;
        this.itemname = itemname;
        this.itemprice = itemprice;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getItemprice() {
        return itemprice;
    }

    public void setItemprice(String itemprice) {
        this.itemprice = itemprice;
    }
}
