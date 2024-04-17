package com.example.shifaaapp;

public class Danger {

    private int img;
    private String name;
    private int id;

    public Danger(int img, String name, int id) {
        this.img = img;
        this.name = name;
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
