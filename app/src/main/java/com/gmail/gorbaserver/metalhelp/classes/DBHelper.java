package com.gmail.gorbaserver.metalhelp.classes;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.gmail.gorbaserver.metalhelp.R;

import static com.gmail.gorbaserver.metalhelp.classes.Helper.writeToLog;

class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String dbName, SQLiteDatabase.CursorFactory cursorFactory, int dbVersion) {
        super(context, dbName, cursorFactory, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DBType.createTable());
        db.execSQL(DBItem.createTable());
        db.execSQL(DBOperation.createTable());
        db.execSQL(DBOperationItem.createTable());

        insertTypes(db);

        insertMetalItem(db, DBItem.Armatura.getArmatura(),DBItem.Armatura.NAME);

        insertMetalItem(db, DBItem.ListStalnoy.getListStalnoy(),DBItem.ListStalnoy.NAME);

        insertMetalItem(db, DBItem.ListOtsynkovany.getListOtsynkovany(),DBItem.ListOtsynkovany.NAME);

        insertMetalItem(db, DBItem.ListRifleny.getListRifleny(),DBItem.ListRifleny.NAME);

        insertMetalItem(db, DBItem.Krug.getKrug(),DBItem.Krug.NAME);

        insertMetalItem(db, DBItem.Kvadrat.getKvadrat(),DBItem.Kvadrat.NAME);

        insertMetalItem(db, DBItem.TrubaKvadratnaya.getTrubaKvadratnaya(),DBItem.TrubaKvadratnaya.NAME);

        insertMetalItem(db, DBItem.TrubaPryamougolnaya.getTrubaPryamougolnaya(),DBItem.TrubaPryamougolnaya.NAME);
    }


    //ok
    private void insertMetalItem(SQLiteDatabase db, MetalItem[] items, String typeName) {
        ContentValues cv = new ContentValues();

        MetalType type = getTypeByName(db, typeName);


        for (MetalItem item : items) {

            cv.clear();
            cv.put(DBItem.COLUMN_TYPE_ID, type.getId());
            cv.put(DBItem.COLUMN_NAME, item.getName());
            cv.put(DBItem.COLUMN_SIZE, item.getSize());
            cv.put(DBItem.COLUMN_WEIGHT, item.getWeight());

            db.insert(DBItem.getDbTableName(), null, cv);
        }
    }

    //ok
    private void insertTypes(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        // Insert Type of Metal
        String[] types = DBType.getTypeNames();

        for (String type : types) {
            cv.clear();
            cv.put(DBType.COLUMN_TYPE, type);

            db.insert(DBType.getDbTableName(), null, cv);
        }
    }

    //ok
    private MetalType getTypeByName(SQLiteDatabase db, String typeName) {
        MetalType result = new MetalType();

        Cursor cursor = db.query(
                DBType.getDbTableName(),
                null,
                DBType.COLUMN_TYPE + " = ?",
                new String[]{typeName},
                null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                result.setId(cursor.getInt(cursor.getColumnIndex(DBType.COLUMN_ID)));
                result.setType(cursor.getString(cursor.getColumnIndex(DBType.COLUMN_TYPE)));
            }
            cursor.close();
        }
        return result;
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
