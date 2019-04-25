package com.example.ibon.glutenfreeapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LugaresSQLiteHelper  extends SQLiteOpenHelper{


    String sqlCreate=" CREATE TABLE lugar(idlugar INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            " nombre TEXT UNIQUE," +
            " telefono TEXT,"+
            " tipo INTEGER,"+                // LA COLUMNA TIPO PODRA TENER LOS VALORES 1 o 0, INDICARA SI ES COMERCIO O RESTAURANTE
            " latitud REAL," +
            " longitud REAL,"+
            " foto TEXT,"+                   // EN UN PRINCIPIO SERA LA URL DE UNA FOTO QUE SE CARGARA
            " descripcion TEXT)";

    public LugaresSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // CREAMOS LA TABLA
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
