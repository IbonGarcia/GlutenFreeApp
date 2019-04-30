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
        // INSERTAMOS LA INFORMACION

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('The Challenge',945031506,0,42.851263,-2.669491,'the_challenge.jpg','Americana, Opciones vegetarianas, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('Restaurante Pintabocas',945339660,0,42.844689,-2.666002,'pintabocas.jpg','Italiana, Española, Opciones vegetarianas, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('Tomate Cafe',656759177,0,42.85114033630614,-2.66917013799289,'tomate.jpg','Cafe bar, sirven hamburguesas, bocadillos, ensaladas, comida oriental, y tienen opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('La Pintozzeria',945124390,0,42.84745,-2.670354,'pintozzeria.jpg','Italiana, Pizza, Opciones vegetarianas, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('Dolomiti',945233426,0,42.84324195947408,-2.67562588114583,'dolomiti.jpd','Italiana, Pizza, Mediterránea, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('Kotarro',945132297,0,42.84762031069491,-2.68009406374077,'kotarro.jpg','Comida variada, Opciones vegetarianas, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('Kaskagorri',945149263,0,42.84735997299865,-2.67186794725004,'kaskagorri.jpg','Comida Mediterránea, Opciones vegetarianas, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('El Clarete',945263874,0,42.84885173233667,-2.67570798092549,'clarete.jpg','Comida Mediterránea, Europea, Española, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('Asador Sagartoki',945288676,0,42.8459757,-2.6751414,'sagartoki.jpg','Comida Mediterránea, Europea, Española, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('La Posada del Duende',945287931,0,42.84768052016656,-2.66002661558036,'duende.jpg','Comida Española, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('Erdizka taberna',945283418,0,42.84804085833809,-2.67078429521149,'erdizka.jpg','Comida Mediterránea, Opciones vegetarianas, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('El Siete',945272298,0,42.84754412930911,-2.67077458681371,'siete.jpg','Acogedora y desenfadada taberna con mesas de madera y terraza que sirve pintxos, bocadillos y cocina vasca.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('Restaurante Olarizu',945217500,0,42.850588600737666 ,-2.6836532895313496,'olarizu.jpg','Menús de cocina vasco-española en refinado restaurante con comedores para bodas y banquetes y sala de baile.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('PASTELERÍA MI POSTRE',945046679,1,42.84822986802399,-2.6752331507206293,'postre.jpg','Pasteleria creativa, vegana, sin azúcar, sin gluten, sin lactosa')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('Artepan',9945278888,1,42.843853,-2.6669702,'artepan.jpg','Luminoso local de sencilla decoración moderna que vende panes variados, bollería artesana, tartas y bombones. Variedad de productos sin gluten.')");

        //db.execSQL("UPDATE lugar SET latitud=42.851140336306145, longitud=-2.669170137992893 where nombre='Tomate Cafe'");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
