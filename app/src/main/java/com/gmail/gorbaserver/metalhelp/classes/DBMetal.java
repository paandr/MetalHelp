package com.gmail.gorbaserver.metalhelp.classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;


public class DBMetal {

    // - - - - -

    private DBHelper dbHelper;
    private SQLiteDatabase db;
    private Context context;

    public DBMetal(Context context) {
        this.context = context;
    }

    private static final String DB_NAME = "metaldb";
    private static final int DB_VERSION = 1;

    public void open() {
        dbHelper = new DBHelper(context, DB_NAME, null, DB_VERSION);
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        if (dbHelper != null) dbHelper.close();
    }


    //ok
    public ArrayList<MetalItem> getMetalItemsByTypeName(String name) {
        ArrayList<MetalItem> result = new ArrayList<>();

        String table = DBItem.getDbTableName() + " I " + " inner join " + DBType.getDbTableName() + " T "
                + " on " + " I." + DBItem.COLUMN_TYPE_ID + " = " + " T." + DBType.COLUMN_ID;

        String itemId = "itemId";
        String itemName = "itemName";
        String itemTypeId = "itemTypeId";
        String typeName = "typeName";
        String itemSize = "itemSize";
        String itemWeight = "itemWeight";

        String[] columns = {
                "I." + DBItem.COLUMN_ID + " as " + itemId,
                "I." + DBItem.COLUMN_NAME + " as " + itemName,
                "I." + DBItem.COLUMN_TYPE_ID + " as " + itemTypeId,
                "T." + DBType.COLUMN_TYPE + " as " + typeName,
                "I." + DBItem.COLUMN_SIZE + " as " + itemSize,
                "I." + DBItem.COLUMN_WEIGHT + " as " + itemWeight
        };

        String selection = "T." + DBType.COLUMN_TYPE + " = ?";
        String[] sArgs = {name};

        Cursor c = db.query(table,
                columns,
                selection,
                sArgs,
                null, null, null);

        if (c != null) {
            if (c.moveToFirst()) {
                MetalItem item;
                do {
                    item = new MetalItem(c.getString(c.getColumnIndex(itemName)),
                            c.getInt(c.getColumnIndex(itemId)),
                            c.getInt(c.getColumnIndex(itemTypeId)),
                            c.getString(c.getColumnIndex(typeName)),
                            c.getString(c.getColumnIndex(itemSize)),
                            c.getDouble(c.getColumnIndex(itemWeight))
                    );
                    result.add(item);
                } while (c.moveToNext());
            }
            c.close();

            return result;
        } else {
            return null;
        }

    }


    //ok
    public void addOperation(Operation item) {

        ContentValues cv = new ContentValues();
        cv.clear();
        cv.put(DBOperation.COLUMN_DATE, item.getDateTimeString());
        cv.put(DBOperation.COLUMN_NAME, item.getName());
        cv.put(DBOperation.COLUMN_NOTE, item.getNote());
        cv.put(DBOperation.COLUMN_DISTANCE, item.getDistance());
        cv.put(DBOperation.COLUMN_FINISH, item.getFinish());

        db.insert(DBOperation.getDbTableName(), null, cv);
    }


    public int getMaxOperationId(){
        int id = 0;

        String query = "SELECT MAX("+DBOperation.COLUMN_ID+") FROM "+DBOperation.getDbTableName();
        Cursor c = db.rawQuery(query,null);
        if (c != null){
            c.moveToFirst();
            id = c.getInt(0);
        }
        return id;
    }

    public ArrayList<Operation> getOperations() {

        ArrayList<Operation> operations = new ArrayList<>();

        String name = "name";
        String date = "date";
        String note = "note";
        String distance = "distance";
        String pointFinish = "finish";

        Cursor c = db.query(DBOperation.getDbTableName(), null, null, null, null, null, null);

        if (c != null) {
            Operation oper;
            Date mDate = new Date();
            if (c.moveToFirst()) {
                do {

                    try {
                        mDate = Helper.sdf_yyyyMMddHHmmss.parse(c.getString(c.getColumnIndex(date)));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    oper = new Operation(
                            c.getString(c.getColumnIndex(note))
                            , c.getString(c.getColumnIndex(name))
                            , mDate
                            , c.getDouble(c.getColumnIndex(distance)),
                            c.getString(c.getColumnIndex(pointFinish))
                    );
                    operations.add(oper);
                } while (c.moveToNext());
            }
        }

        return operations;

    }


}
