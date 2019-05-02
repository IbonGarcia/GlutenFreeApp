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
            " calle TEXT,"+
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

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud,calle, foto,descripcion)" +
                " VALUES ('The Challenge',945031506,0,42.851263,-2.669491,'6, San Anton Plaza, 01002 Vitoria-Gasteiz, Araba','the_challenge.jpg','Americana, Opciones vegetarianas, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud,calle, foto,descripcion)" +
                " VALUES ('Restaurante Pintabocas',945339660,0,42.844689,-2.666002,'Urriaren Hamabiaren Kalea, 1, 01004 Vitoria-Gasteiz, Araba','pintabocas.jpg','Italiana, Española, Opciones vegetarianas, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud,calle, foto,descripcion)" +
                " VALUES ('Tomate Cafe',656759177,0,42.85114033630614,-2.66917013799289,'Plaza San Anton 7 Bajo, 01002 Vitoria-Gasteiz, Álava','tomate.jpg','Cafe bar, sirven hamburguesas, bocadillos, ensaladas, comida oriental, y tienen opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud,calle, foto,descripcion)" +
                " VALUES ('La Pintozzeria',945124390,0,42.84745,-2.670354,'Pintore Kalea, 1, 01001 Vitoria-Gasteiz, Araba','pintozzeria.jpg','Italiana, Pizza, Opciones vegetarianas, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud,calle, foto,descripcion)" +
                " VALUES ('Dolomiti',945233426,0,42.84324195947408,-2.67562588114583,'Santiago Ramon y Cajal Kalea, 1, 01007 Vitoria-Gasteiz, Araba','dolomiti.jpd','Un mural de Venecia preside este cálido y moderno restaurante con pasta fresca y pizzas al horno de leña.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud,calle, foto,descripcion)" +
                " VALUES ('Kotarro',945132297,0,42.84762031069491,-2.68009406374077,'Sancho el Sabio Kalea, 11, 01008 Vitoria-Gasteiz, Araba','kotarro.jpg','Taberna actual de aire industrial con terraza donde degustar arroz cremoso o pescado más tapas y pintxos.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud,calle, foto,descripcion)" +
                " VALUES ('Kaskagorri',945149263,0,42.84735997299865,-2.67186794725004,'Machete Plaza, 6, 01001 Vitoria-Gasteiz, Araba','kaskagorri.jpg','Platos tradicionales vascos con toque creativo en un espacio elegante con paredes de piedra y techo abovedado.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud,calle, foto,descripcion)" +
                " VALUES ('El Clarete',945263874,0,42.84885173233667,-2.67570798092549,'Zerkabarren Kalea, 18, 01001 Vitoria-Gasteiz, Araba','clarete.jpg','Menú degustación con platos de autor y carta de vinos en un reformado restaurante de 1927 con barra de tapeo.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud,calle, foto,descripcion)" +
                " VALUES ('Asador Sagartoki',945288676,0,42.8459757,-2.6751414,'El Prado Kalea, 18, 01005 Vitoria-Gasteiz, Araba','sagartoki.jpg','Pintxos y platos vanguardistas de autor en un bar-sidrería con tortilla de patatas y laboratorio gastronómico.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud,calle, foto,descripcion)" +
                " VALUES ('La Posada del Duende',945287931,0,42.84768052016656,-2.66002661558036,'Av. Santiago, 44, 01003 Vitoria-Gasteiz, Álava','duende.jpg','Comida Española, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud,calle, foto,descripcion)" +
                " VALUES ('Erdizka taberna',945283418,0,42.84804085833809,-2.67078429521149,'Aiztogile Kalea, 11, 01001 Vitoria-Gasteiz, Araba','erdizka.jpg','Comida Mediterránea, Opciones vegetarianas, Opciones sin gluten.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud,calle, foto,descripcion)" +
                " VALUES ('El Siete',945272298,0,42.84754412930911,-2.67077458681371,'Aiztogile Kalea, 3, 01001 Vitoria-Gasteiz, Araba','siete.jpg','Acogedora y desenfadada taberna con mesas de madera y terraza que sirve pintxos, bocadillos y cocina vasca.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud,calle, foto,descripcion)" +
                " VALUES ('Restaurante Olarizu',945217500,0,42.850588600737666 ,-2.6836532895313496,'Avenida Beato Tomás de Zumárraga, 54, 01009 Vitoria-Gasteiz, Araba','olarizu.jpg','Menús de cocina vasco-española en refinado restaurante con comedores para bodas y banquetes y sala de baile.')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud,calle, foto,descripcion)" +
                " VALUES ('PASTELERÍA MI POSTRE',945046679,1,42.84822986802399,-2.6752331507206293,'Calle Sierva de Jesús 9 Bajo, 01001 Vitoria-Gasteiz, Álava','postre.jpg','Pasteleria creativa, vegana, sin azúcar, sin gluten, sin lactosa')");

        db.execSQL("INSERT INTO lugar (nombre, telefono, tipo,latitud, longitud,calle, foto,descripcion)" +
                " VALUES ('Artepan',945278888,1,42.843853,-2.6669702,'Calle Jesús Guridi, 2, 01004 Vitoria-Gasteiz, Álava','artepan.jpg','Luminoso local de sencilla decoración moderna que vende panes variados, bollería artesana, tartas y bombones. Variedad de productos sin gluten.')");

        //db.execSQL("UPDATE lugar SET latitud=42.851140336306145, longitud=-2.669170137992893 where nombre='Tomate Cafe'");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
