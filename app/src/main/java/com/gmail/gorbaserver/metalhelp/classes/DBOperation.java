package com.gmail.gorbaserver.metalhelp.classes;

/**
 * Created by phorbaienko on 01.03.18.
 */

public class DBOperation {

    private static final String DB_TABLE_NAME = "operation";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_NOTE = "note";
    public static final String COLUMN_DISTANCE = "distance";
    public static final String COLUMN_FINISH = "finish";

    // Operation
    private static final String DB_CREATE_TABLE =
            "create table " + DB_TABLE_NAME
                    + " ("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                    + ", " + COLUMN_NAME + " TEXT "
                    + ", " + COLUMN_DATE + " DATETIME "
                    + ", " + COLUMN_NOTE + " TEXT "
                    + ", " + COLUMN_DISTANCE + " REAL "
                    + ", " + COLUMN_FINISH + " TEXT "
                    + ");";

    public static String createTable() {
        return DB_CREATE_TABLE;
    }


    public static String getDbTableName() {
        return DB_TABLE_NAME;
    }

}
