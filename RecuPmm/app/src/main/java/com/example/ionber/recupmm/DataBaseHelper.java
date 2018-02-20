package com.example.ionber.recupmm;

/**
 * Created by ionber on 16/02/18.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper {
    private Context mCtx = null;
    private DataBaseHelperInternal mDbHelper = null;
    private SQLiteDatabase mDb = null;
    private static final String DATABASE_NAME = "CRONO";
    private static final int DATABASE_VERSION = 3;

    // tabla y campos
    private static final String DATABASE_TABLE_CRONO = "crono";
    public static final String SL_ID = "_id";
    public static final String SL_HORARIO = "horario";

    // SQL de creación de la tabla
    private static final String DATABASE_CREATE_CRONO =
            "create table "+ DATABASE_TABLE_CRONO +" ("+SL_ID+" integer primary key, "+SL_HORARIO+" text not null)";

    //constructor
    public DataBaseHelper(Context ctx) {
        this.mCtx = ctx;
    }

    //clase privada para control de la SQLite
    private static class DataBaseHelperInternal extends SQLiteOpenHelper {
        public DataBaseHelperInternal(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            createTables(db);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            deleteTables(db);
            createTables(db);
        }
        private void createTables(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_CRONO);
        }

        private void deleteTables(SQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_CRONO);
        }
    }

    public DataBaseHelper open()  {
        mDbHelper = new DataBaseHelperInternal(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    //obtener todos los elementos
    public Cursor getItems() {
        return mDb.query(DATABASE_TABLE_CRONO, new String[] {SL_ID, SL_HORARIO}, null, null, null, null, SL_ID);
    }

    //crear elemento
    public long insertItem(String id, String horario){
        ContentValues initialValues = new ContentValues();
        initialValues.put(SL_ID, id);
        initialValues.put(SL_HORARIO, horario);
        return mDb.insert(DATABASE_TABLE_CRONO, null, initialValues);
    }

    //obtener elemento
    public Cursor getItem(int itemId){
        return mDb.rawQuery(" select "+ SL_ID+","+ SL_HORARIO + " from " + DATABASE_TABLE_CRONO  + " where " + SL_ID + "= ?",new String[]{Integer.toString(itemId)});
    }

    //actualiza
    public int updateItem(int ident, String id, String horario) {
        ContentValues cv = new ContentValues();
        cv.put(SL_ID, id);
        cv.put(SL_HORARIO, horario);
        return mDb.update(DATABASE_TABLE_CRONO, cv, SL_ID + "=?", new String[]{Integer.toString(ident)});
    }

}



/*



import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
     */

/**
 * Created by Alejandro on 16/02/2018.
 */

/*
public class DataBaseHelper {

    private Context mCtx = null;
    private DataBaseHelperInternal mDbHelper = null;
    private SQLiteDatabase mDb = null;
    private static final String DATABASE_NAME = "CRONO";
    private static final int DATABASE_VERSION = 3;
    // tabla y campos
    private static final String DATABASE_TABLE_CRONO = "crono";
    public static final String SL_ID = "_id";
    public static final String SL_HOUR = "hora";

    private static final String DATABASE_TABLE_USUARIO = "Usuario";
    public static final String SL_USERID = "_id";
    public static final String SL_USERNAME = "nombre";
    public static final String SL_PASSWORD = "password";

    // SQL de creación de la tabla
    private static final String DATABASE_CREATE_HORARIO =
            "create table "+ DATABASE_TABLE_CRONO +" ("+SL_ID+" integer primary key, "+SL_HOUR+" text not null)";

    private static final String DATABASE_CREATE_USER =
            "create table "+ DATABASE_TABLE_USUARIO + " ("+SL_USERID+" integer primary key autoincrement, "+SL_USERNAME+" text not null, "+SL_PASSWORD+" text not null)";
    //constructor
    public DataBaseHelper(Context ctx) {
        this.mCtx = ctx;
    }
    //clase privada para control de la SQLite
    private static class DataBaseHelperInternal extends SQLiteOpenHelper {
        public DataBaseHelperInternal(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);		}

        @Override
        public void onCreate(SQLiteDatabase db) {
            createTables(db);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            deleteTables(db);
            createTables(db);
        }
        private void createTables(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_HORARIO);
            db.execSQL(DATABASE_CREATE_USER);
        }

        private void deleteTables(SQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_CRONO);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_USUARIO);

        }
    }

    public DataBaseHelper open()  {
        mDbHelper = new DataBaseHelperInternal(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    //obtener todos los elementos
    public Cursor getHours() {
        return mDb.query(DATABASE_TABLE_CRONO, new String[] {SL_ID, SL_HOUR}, null, null, null, null, null);
    }

    public Cursor getUsers() {
        return mDb.query(DATABASE_TABLE_USUARIO, new String[] {SL_USERID, SL_USERNAME, SL_PASSWORD}, null, null, null, null, null);

    }


    //crear elemento
    public long insertHour(String hour){
        ContentValues initialValues = new ContentValues();
        initialValues.put(SL_HOUR, hour);
        return mDb.insert(DATABASE_TABLE_CRONO, null, initialValues);
    }

    public long insertUser(String user, String password){
        ContentValues initialValues = new ContentValues();
        initialValues.put(SL_USERNAME, user);
        initialValues.put(SL_PASSWORD, password);
        return mDb.insert(DATABASE_TABLE_USUARIO, null, initialValues);
    }

    public Cursor getUser(int itemId) {
        return mDb.rawQuery(" select "+ SL_USERNAME + "," + SL_PASSWORD+ " from " + DATABASE_TABLE_USUARIO  + " where " + SL_USERID + "= ?",new String[]{Integer.toString(itemId)});
    }


    //obtener elemento
    public Cursor getHour(int itemId){
        return mDb.rawQuery(" select "+ SL_HOUR + " from " + DATABASE_TABLE_CRONO  + " where " + SL_ID + "= ?",new String[]{Integer.toString(itemId)});
    }



}
*/