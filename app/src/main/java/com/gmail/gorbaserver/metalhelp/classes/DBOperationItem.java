package com.gmail.gorbaserver.metalhelp.classes;



public class DBOperationItem {

    private static final String DB_TABLE_NAME = "operation_item";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_OPERATION_ID = "oi_operation_id";
    public static final String COLUMN_METALITEM_ID = "oi_metalitem_id";
    public static final String COLUMN_WEIGHT = "oi_weight";
    public static final String COLUMN_LENGTH = "oi_length";
    public static final String COLUMN_QUANTITY = "oi_quantity";

    private static final String DB_CREATE_TABLE =
            "create table " + DB_TABLE_NAME + " ("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                    + ", " + COLUMN_OPERATION_ID + " INTEGER NOT NULL "
                    + ", " + COLUMN_METALITEM_ID + " INTEGER NOT NULL "
                    + ", " + COLUMN_WEIGHT + " REAL "
                    + ", " + COLUMN_LENGTH + " REAL "
                    + ", " + COLUMN_QUANTITY + " INTEGER "
                    + ", FOREIGN KEY(" + COLUMN_OPERATION_ID + ") REFERENCES "
                        + DBOperation.getDbTableName() + "(" + DBOperation.COLUMN_ID + ")"
                    + ", FOREIGN KEY(" + COLUMN_METALITEM_ID + ") REFERENCES "
                        + DBItem.getDbTableName() + "(" + DBItem.COLUMN_ID + ")"
                    + ");";


    public static String createTable() {
        return DB_CREATE_TABLE;
    }
}
