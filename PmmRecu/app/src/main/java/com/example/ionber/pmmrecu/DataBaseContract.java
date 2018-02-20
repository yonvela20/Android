package com.example.ionber.pmmrecu;

/**
 * Created by ionber on 16/02/18.
 */

import android.provider.BaseColumns;

public class DataBaseContract {
    // Constantes para facilitar la creación de sentencias SQL.
    private static final String PRIMARY_KEY = " PRIMARY KEY";
    private static final String FOREIGN_KEY = " FOREIGN KEY";
    private static final String UNIQUE = " UNIQUE ";
    private static final String REFERENCES = " REFERENCES ";
    private static final String ON_DELETE = " ON DELETE";
    private static final String ON_UPDATE = " ON UPDATE";
    private static final String CASCADE = " CASCADE";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String REAL_TYPE = " REAL";
    private static final String TEXT_TYPE = " TEXT";
    private static final String NOT_NULL = " NOT NULL";
    private static final String COMA_SEP = ", ";

    // Constructor vacío para prevenir la instanciación accidental de la clase.
    private DataBaseContract() {}

    public static final class UsuarioEntry implements BaseColumns {
        public static final String TABLE_NAME = "usuario";
        public static final String KEY_NAME = "nombre";
        public static final String KEY_PASSWORD = "password";

        private UsuarioEntry() {}

        // Array con todas las columnas.
        public static final String[] KEY_ARRAY = {
                KEY_NAME,
                KEY_PASSWORD
        };

        // El campo nombre es único por comodidad y para que sirva de identificador.
        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + _ID + INTEGER_TYPE + PRIMARY_KEY + COMA_SEP
                + KEY_NAME + TEXT_TYPE + NOT_NULL + COMA_SEP
                + KEY_PASSWORD + TEXT_TYPE + NOT_NULL + COMA_SEP
                + UNIQUE + "(" + KEY_NAME + ")"
                + ")";

        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static final class HorariosEntry implements BaseColumns {
        public static final String TABLE_NAME = "horarios";
        public static final String KEY_USER_NAME = "nombre_usuario";
        public static final String KEY_TIME = "horario";

        private HorariosEntry() {}

        // Array con todas las columnas.
        public static final String[] KEY_ARRAY = {
                KEY_USER_NAME,
                KEY_TIME
        };

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + _ID + INTEGER_TYPE + PRIMARY_KEY + COMA_SEP
                + KEY_USER_NAME + TEXT_TYPE + NOT_NULL + COMA_SEP
                + KEY_TIME + TEXT_TYPE + NOT_NULL + COMA_SEP
                + FOREIGN_KEY + "(" + KEY_USER_NAME + ")"
                + REFERENCES + UsuarioEntry.TABLE_NAME + "(" +UsuarioEntry.KEY_NAME + ")"
                + ")";

        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}