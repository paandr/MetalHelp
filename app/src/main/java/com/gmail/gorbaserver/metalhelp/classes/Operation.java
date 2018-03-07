package com.gmail.gorbaserver.metalhelp.classes;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Operation {

    private int id;
    private String note;
    private String name;
    private Date date;
    private double distance;
    private String finish;
    private ArrayList<MetalItem> items;

    public Operation() {

    }

    public Operation(String note, String name, Date date, double distance,String finish) {

        this.finish = finish;
        this.note = note;
        this.name = name;
        this.date = date;
        this.distance = distance;
    }

    public int getId() {
        return this.id;
    }

    public String getNote() {
        return this.note;
    }

    public Date getDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return cal.getTime();
    }

    public String getDateTimeString() {
        return Helper.sdf_yyyyMMddHHmmss.format(this.date);
    }

    public double getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public ArrayList<MetalItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void addItems(MetalItem item) {
        items.add(item);
    }

    public String getFinish() {
        return finish;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
