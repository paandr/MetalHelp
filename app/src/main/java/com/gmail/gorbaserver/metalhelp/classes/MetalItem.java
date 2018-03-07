package com.gmail.gorbaserver.metalhelp.classes;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by phorbaienko on 01.02.2018.
 */

public class MetalItem {

    private int itemId;
    private String name;
    private MetalType metalType;
    private String size;
    private double weight;

    //private double meterInTonne;

    public MetalItem() {
    }

    public MetalItem(String name, String size, double weight) {
        this.name = name;
        this.size = size;
        this.weight = weight;
    }

    public MetalItem(String name, int itemId, int typeId, String typeName, String size, double weight) {
        this.metalType = new MetalType(typeId, typeName);
        this.itemId = itemId;
        this.name = name;
        this.size = size;
        this.weight = weight;
        //this.meterInTonne = meterInTonne;
    }
//edit_code
    public MetalItem(String name, String size, double weight, boolean calculateMeters) {
        this.metalType = null;
        this.name = name;
        this.size = size;
        this.weight = weight;
        if (calculateMeters) {
            //this.meterInTonne = meterInTonne;
        }
    }

    public String getSize() {
        return this.size;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getWeightString() {
//        DecimalFormat df = new DecimalFormat("#.###");
//        df.setRoundingMode(RoundingMode.CEILING);
//
//        return df.format(this.weight);

        //return String.format("%.3f",this.weight);
        return String.valueOf(this.weight);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public double getMeterInTonne() {
        return Helper.WEIGHT_ONE_TONNE_KG / this.weight;
    }

    public String getMeterInTonneString() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(Helper.WEIGHT_ONE_TONNE_KG / this.weight);
    }

    public int getItemId() {
        return this.itemId;
    }

    public MetalType getMetalType() {
        return this.metalType;
    }

    @Override
    public String toString() {
        return this.name;
    }


}
