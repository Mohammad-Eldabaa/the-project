package com.example.shifaaapp;

public class Doctors {
    private String name;
    private String partion;
    private String place;

    private  int id;
    private int price;
    private  int star;
    private String about;


    public Doctors() {
    }

    public Doctors(String name, String partion, String place) {
        this.name = name;
        this.partion = partion;
        this.place = place;
    }

    public Doctors(String name, String partion, String place, int id, int price, int star, String about) {
        this.name = name;
        this.partion = partion;
        this.place = place;
        this.id = id;
        this.price = price;
        this.star = star;
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartion() {
        return partion;
    }

    public void setPartion(String partion) {
        this.partion = partion;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
