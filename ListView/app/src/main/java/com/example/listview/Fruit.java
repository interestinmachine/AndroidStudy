package com.example.listview;

public class Fruit {
    private String name;
    private int imgId;

    public Fruit(String name,int imgId) {
        this.imgId = imgId;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getImgId() {
        return imgId;
    }
}
