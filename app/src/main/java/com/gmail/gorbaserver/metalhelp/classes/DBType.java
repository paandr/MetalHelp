package com.gmail.gorbaserver.metalhelp.classes;

import android.content.res.Resources;

import com.gmail.gorbaserver.metalhelp.R;

public class DBType {

    private static final String DB_TABLE_NAME = "type";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TYPE = "type";

    private static final String DB_CREATE_TABLE =
            "create table " + DB_TABLE_NAME
                    + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + ","
                    + COLUMN_TYPE + " TEXT"
                    + ");";

    private static final String[] typeNames = new String[]{
            DBItem.Armatura.NAME,
            DBItem.Krug.NAME,
            DBItem.ListStalnoy.NAME,
            DBItem.ListOtsynkovany.NAME,
            DBItem.ListRifleny.NAME,
            DBItem.Kvadrat.NAME,
            DBItem.TrubaKvadratnaya.NAME,
            DBItem.TrubaPryamougolnaya.NAME
    };

    public static String createTable() {
        return DB_CREATE_TABLE;
    }

    public static String getDbTableName() {
        return DB_TABLE_NAME;
    }

    public static String[] getTypeNames() {
        return typeNames;
    }
}
