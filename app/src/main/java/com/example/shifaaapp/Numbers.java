package com.example.shifaaapp;

public class Numbers {

    private String name;
    private String place;

    private  String sub_place;

    private String number;
    int id;

    public Numbers(String name, String place, String sub_place,String number,int id) {
        this.name = name;
        this.place = place;
        this.sub_place = sub_place;
        this.number = number;
        this.id= id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getSub_place() {
        return sub_place;
    }

    public void setSub_place(String sub_place) {
        this.sub_place = sub_place;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
