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
                " VALUES ('The Challenge',945031506,0,42.851263,-2.669491,'https://lh5.googleusercontent.com/p/AF1QipOMzffMJ8JEKUIEA5wmyq_teWLl6al3v_JBmfZh=w213-h160-k-no','Americana, Opciones vegetarianas, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('Restaurante Pintabocas',945339660,0,42.844689,-2.666002,'https://lh5.googleusercontent.com/p/AF1QipOLCbl7f422tV2eeI62xOd144zP8LukK2Unj8YJ=w285-h160-k-no','Italiana, Española, Opciones vegetarianas, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('Tomate Cafe',656759177,0,42.85114033630614,-2.66917013799289,'https://lh5.googleusercontent.com/p/AF1QipMz9QVGggUyT0L8-XjVvf7p7YhK4Z-FhEaIek9O=w213-h160-k-no','Cafe bar, sirven hamburguesas, bocadillos, ensaladas, comida oriental, y tienen opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('La Pintozzeria',945124390,0,42.84745,-2.670354,'https://lh5.googleusercontent.com/p/AF1QipMbQfLWsJdut9dGTDv3NQnaIyarN2Kps9CZv8Qq=w213-h160-k-no','Italiana, Pizza, Opciones vegetarianas, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('Dolomiti',945233426,0,42.84324195947408,-2.67562588114583,'https://lh5.googleusercontent.com/p/AF1QipM67U3-0m0VT93nrQxyg4tUPU5APr6LTMSgH1IK=w213-h160-k-no','Italiana, Pizza, Mediterránea, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('Kotarro',945132297,0,42.84762031069491,-2.68009406374077,'https://lh5.googleusercontent.com/p/AF1QipNNtJycmDPXaY485bCWCdX44m7KEgImtANf9k8J=w213-h160-k-no','Comida variada, Opciones vegetarianas, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('Kaskagorri',945149263,0,42.84735997299865,-2.67186794725004,'https://lh5.googleusercontent.com/p/AF1QipNsIpUfX2uoyTFxkdGOmpNnInei_qKDPzfGyyfR=w329-h160-k-no','Comida Mediterránea, Opciones vegetarianas, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('El Clarete',945263874,0,42.84885173233667,-2.67570798092549,'https://lh5.googleusercontent.com/p/AF1QipPbHTzVUnRk6tL_bqL2KeCiE4CdEk2BJpCkVO21=w213-h160-k-no','Comida Mediterránea, Europea, Española, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('Asador Sagartoki',945288676,0,42.8459757,-2.6751414,'https://lh5.googleusercontent.com/p/AF1QipOICi86XynR67ie1DaY2nNe-zEQKI8_OmbVCAyv=w213-h160-k-no','Comida Mediterránea, Europea, Española, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('La Posada del Duende',945287931,0,42.84768052016656,-2.66002661558036,'https://lh5.googleusercontent.com/p/AF1QipNLLdigqdHM6X_taZ6RneRPF1KYrKXsFlpNt_J9=w213-h160-k-no','Comida Española, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('Erdizka taberna',945283418,0,42.84804085833809,-2.67078429521149,'https://lh5.googleusercontent.com/p/AF1QipM1Ji4vZqwtj3pi8cNYkrG2gFJmDCvYorIG0Z5T=w284-h160-k-no','Comida Mediterránea, Opciones vegetarianas, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('El Siete',945272298,0,42.84754412930911,-2.67077458681371,'https://lh5.googleusercontent.com/p/AF1QipOmrPijz6saZJJ8VKyNU18ztBtnmLbvJpyVa4Zt=w120-h160-k-no','Acogedora y desenfadada taberna con mesas de madera y terraza que sirve pintxos, bocadillos y cocina vasca.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('El Siete',945272298,0,42.84754412930911,-2.67077458681371,'https://lh5.googleusercontent.com/p/AF1QipOmrPijz6saZJJ8VKyNU18ztBtnmLbvJpyVa4Zt=w120-h160-k-no','Acogedora y desenfadada taberna con mesas de madera y terraza que sirve pintxos, bocadillos y cocina vasca.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('Restaurante Olarizu',945217500,0,42.850588600737666 ,-2.6836532895313496,'https://lh5.googleusercontent.com/p/AF1QipNZ9AgOnrB1YXpD9sDvmxH56PXW8l5shwR2eQGK=w284-h160-k-no','Menús de cocina vasco-española en refinado restaurante con comedores para bodas y banquetes y sala de baile.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('PASTELERÍA MI POSTRE',945046679,1,42.84822986802399,-2.6752331507206293,'https://lh5.googleusercontent.com/p/AF1QipMQS7f-0DWEvDjlo1P2c9AM8YRKqdjDora41yrX=w193-h160-k-no','Pasteleria creativa, vegana, sin azúcar, sin gluten, sin lactosa')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('Artepan',9945278888,1,42.843853,-2.6669702,'https://lh5.googleusercontent.com/p/AF1QipNBrXnd9YxsYHVepxMJwUJ47cL0LvqQFMNWY-MW=w321-h160-k-no','Luminoso local de sencilla decoración moderna que vende panes variados, bollería artesana, tartas y bombones. Variedad de productos sin gluten.')");

        //db.execSQL("UPDATE lugar SET latitud=42.851140336306145, longitud=-2.669170137992893 where nombre='Tomate Cafe'");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
