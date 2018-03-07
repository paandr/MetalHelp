package com.gmail.gorbaserver.metalhelp.classes;


public class MetalType {
    private int id;
    private String type;

    public MetalType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public MetalType() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }
}
