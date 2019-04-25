package com.example.ibon.glutenfreeapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Lista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        LugaresSQLiteHelper lsq = new LugaresSQLiteHelper(this,"BBDD",null,1);

        SQLiteDatabase db = lsq.getWritableDatabase();

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('Restaurante Olarizu',945217500,0,42.850588600737666 ,-2.6836532895313496,'https://lh5.googleusercontent.com/p/AF1QipNZ9AgOnrB1YXpD9sDvmxH56PXW8l5shwR2eQGK=w284-h160-k-no','Menús de cocina vasco-española en refinado restaurante con comedores para bodas y banquetes y sala de baile.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('PASTELERÍA MI POSTRE',945046679,1,42.84822986802399,-2.6752331507206293,'https://lh5.googleusercontent.com/p/AF1QipMQS7f-0DWEvDjlo1P2c9AM8YRKqdjDora41yrX=w193-h160-k-no','Pasteleria creativa, vegana, sin azúcar, sin gluten, sin lactosa')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud, foto,descripcion)" +
                " VALUES ('Artepan',9945278888,1,42.843853,-2.6669702,'https://lh5.googleusercontent.com/p/AF1QipNBrXnd9YxsYHVepxMJwUJ47cL0LvqQFMNWY-MW=w321-h160-k-no','Luminoso local de sencilla decoración moderna que vende panes variados, bollería artesana, tartas y bombones. Variedad de productos sin gluten.')");

        //db.execSQL("UPDATE lugar SET latitud=42.851140336306145, longitud=-2.669170137992893 where nombre='Tomate Cafe'");

        db.close();
    }
}
