package com.example.ionber.pmmrecu;

/**
 * Created by ionber on 16/02/18.
 */

import android.content.ContentValues;
import android.database.Cursor;

public class Login {
    private String nombre;
    private String password;

    public Login(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }
    public Login(Cursor cursor) {
        this.nombre = cursor.getString(cursor.getColumnIndex(DataBaseContract.UsuarioEntry.KEY_NAME));
        this.password = cursor.getString(cursor.getColumnIndex(DataBaseContract.UsuarioEntry.KEY_PASSWORD));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(DataBaseContract.UsuarioEntry.KEY_NAME, nombre);
        values.put(DataBaseContract.UsuarioEntry.KEY_PASSWORD, password);
        return values;
    }
}
