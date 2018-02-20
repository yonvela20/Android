package com.example.ionber.pmmrecu;

/**
 * Created by ionber on 16/02/18.
 */

import android.content.ContentValues;
import android.database.Cursor;

public class Horario {
    private String usuario_nombre;
    private String tiempo;

    public Horario(String usuario_nombre, String tiempo) {
        this.usuario_nombre = usuario_nombre;
        this.tiempo = tiempo;
    }
    public Horario(Cursor cursor) {
        this.usuario_nombre = cursor.getString(cursor.getColumnIndex(DataBaseContract.UsuarioEntry.KEY_NAME));
        this.tiempo = cursor.getString(cursor.getColumnIndex(DataBaseContract.UsuarioEntry.KEY_PASSWORD));
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(DataBaseContract.UsuarioEntry.KEY_NAME, usuario_nombre);
        values.put(DataBaseContract.UsuarioEntry.KEY_PASSWORD, tiempo);
        return values;
    }
}