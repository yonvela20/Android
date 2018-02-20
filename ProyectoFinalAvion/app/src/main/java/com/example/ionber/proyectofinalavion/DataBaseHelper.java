package com.example.ionber.proyectofinalavion;

/**
 * Created by ionber on 20/02/18.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    private Context mCtx = null;
    private SQLiteDatabase mDb = null;
    private static final String DATABASE_NAME = "dbViajes";
    private static final int DATABASE_VERSION = 4;

    // tabla y campos
    public static final String DATABASE_TABLE_VIAJES = "viajes";

    public static final String SL_ID_VIAJES = "id";
    public static final String SL_DESTINO = "destino";
    public static final String SL_ORIGEN = "origen";
    public static final String SL_PRECIO = "precio";


    private static final String DATABASE_CREATE_VIAJES =
            "create table " + DATABASE_TABLE_VIAJES + " (" + SL_ID_VIAJES +
                    " integer primary key, " + SL_ORIGEN + " text not null, " + SL_PRECIO + " float,  "
                    + SL_DESTINO + " text not null)";

    public static final String DATABASE_CREATE_BILLETE = "CREATE TABLE billete (id INTEGER primary key autoincrement, id_billete INTEGER, billete TEXT," +
            "cantidad INTEGER not null,precio INTEGER not null,clase TEXT,extras TEXT)";

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_CREATE_VIAJES);
        sqLiteDatabase.execSQL(DATABASE_CREATE_BILLETE);


        sqLiteDatabase.execSQL("INSERT INTO viajes (id , destino, origen, precio) VALUES ('1', 'amsterdam', 'Valencia', '150') ");
        sqLiteDatabase.execSQL("INSERT INTO viajes (id , destino, origen, precio) VALUES ('2', 'berlin', 'barcelona','220') ");
        sqLiteDatabase.execSQL("INSERT INTO viajes (id , destino, origen, precio) VALUES ('3', 'praga', 'madrid','300') ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}