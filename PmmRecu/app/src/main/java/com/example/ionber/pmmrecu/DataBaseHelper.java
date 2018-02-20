package com.example.ionber.pmmrecu;

/**
 * Created by ionber on 16/02/18.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "database.db";
    // Array con los datos de prueba:
    private static final Usuario[] MOCK_USUARIO_ARRAY = {
            new Usuario("admin", "admin"),
            new Usuario("usuario1", "1111"),
            new Usuario("usuario2", "2222")
    };

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DBContract.UsuarioEntry.CREATE_TABLE);
        sqLiteDatabase.execSQL(DBContract.HorariosEntry.CREATE_TABLE);
        // Insertamos los datos de prueba:
        mockData(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DBContract.UsuarioEntry.DROP_TABLE);
    }

    // Método para insertar un usuario de prueba:
    public long mockUsuario(SQLiteDatabase sqLiteDatabase, Usuario usuario) {
        return sqLiteDatabase.insert(
                DBContract.UsuarioEntry.TABLE_NAME,
                null,
                usuario.toContentValues()
        );
    }

    // Método para insertar todas los usuarios de prueba:
    private void mockData(SQLiteDatabase sqLiteDatabase) {
        for (Usuario task : MOCK_USUARIO_ARRAY) {
            mockUsuario(sqLiteDatabase, task);
        }
    }

    // Método para obtener todas los usuarios de la base de datos:
    public Cursor getAllUsuarios() {
        return getReadableDatabase().query(
                DBContract.UsuarioEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    // Método para obtener los usuarios de la base de datos según el nombre:
    public Cursor getUsuarioByNombre(String name) {
        return getReadableDatabase().query(
                DBContract.UsuarioEntry.TABLE_NAME,
                null,
                DBContract.UsuarioEntry.KEY_NAME + " LIKE ?",
                new String[]{name},
                null,
                null,
                null
        );
    }

    // Método para obtener los horarios de la base de datos según el usuario:
    public Cursor getHorarioByNombre(String name) {
        return getReadableDatabase().query(
                DBContract.HorariosEntry.TABLE_NAME,
                null,
                DBContract.HorariosEntry.KEY_USER_NAME + " LIKE ?",
                new String[]{name},
                null,
                null,
                null
        );
    }

    // Método para insertar un nuevo usuario en la base de datos:
    public long insertUsuario(Usuario usuario) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                DBContract.UsuarioEntry.TABLE_NAME,
                null,
                usuario.toContentValues());
    }

    // Método para insertar un nuevo horario en la base de datos:
    public long insertHorario(Horario horario) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                DBContract.UsuarioEntry.TABLE_NAME,
                null,
                horario.toContentValues());
    }
}