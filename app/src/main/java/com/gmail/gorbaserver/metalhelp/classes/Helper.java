package com.gmail.gorbaserver.metalhelp.classes;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Helper {

    public static final String ATTRIBUTE_NAME = "text";
    public static final String ATTRIBUTE_SIZE = "size";
    public static final String ATTRIBUTE_WEIGHT = "weight";
    public static final String ATTRIBUTE_METER_IN_TONNE = "meterInTonne";
    public static final String ATTRIBUTE_DISTANCE="distance";
    public static final String ATTRIBUTE_DATE="date";
    public static final String ATTRIBUTE_TIME="time";
    public static final String ATTRIBUTE_POINT_FINISH="pointFinish";

    public static final int CODE_ADD_POSITION = 1;

    public static final int WEIGHT_ONE_TONNE_KG = 1000;


    public static void writeToLog(String text) {
        Log.e("MyLogs", text);
    }

    public static double getDoubleFromEditText(String text) {

        if (!text.isEmpty() && text != null) {
            if (text.equals(".") || text.equals(","))
                return -1;
            return Double.parseDouble(text);
        }
        return -1;
    }

    public static SimpleDateFormat sdf_yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    public static SimpleDateFormat sdf_HHmm = new SimpleDateFormat("HH:mm", Locale.getDefault());
    public static SimpleDateFormat sdf_ddMMyyyy = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());


    /**
     * calculate weight of 'truba kruglaya'
     *
     * @param diameter
     * @param thickness
     * @param length
     * @return Вес 1 метра трубы круглой
     */
    public static double calcWeightTrubaKruglaya(double diameter, double thickness, double length) {
        final double COEFFICIENT = 0.02466;

        return COEFFICIENT * thickness * (diameter - thickness) * length;
    }

    public static double calcWeightInLength(double weightInMeter, double length) {
        return length * weightInMeter;
    }

    public static double calcLengthInWeight(double weightInMeter, double weight) {
        return weight / weightInMeter;
    }


}
