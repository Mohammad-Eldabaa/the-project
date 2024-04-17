package com.example.shifaaapp;

public class Medical_C {

    private  int id;
    private String Sname;
    private String Tname;
    private String use;
    private String Xuse;

    public Medical_C(int id, String sname, String tname, String use, String xuse) {
        this.id = id;
        Sname = sname;
        Tname = tname;
        this.use = use;
        Xuse = xuse;
    }

    public Medical_C() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getXuse() {
        return Xuse;
    }

    public void setXuse(String xuse) {
        Xuse = xuse;
    }
}
