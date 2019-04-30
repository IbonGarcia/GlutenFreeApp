package com.example.ibon.glutenfreeapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Lista extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        LugaresSQLiteHelper lsq = new LugaresSQLiteHelper(this,"BBDD",null,1);

        final SQLiteDatabase db = lsq.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT idlugar,nombre,telefono,tipo,latitud,longitud,calle,foto,descripcion FROM lugar ",null);

        ArrayList<Lugar> info = new ArrayList<Lugar>();

        if (c.moveToFirst()){

            do{
                int id= c.getInt(0);
                String nom = c.getString(1);
                String telef = c.getString(2);
                int tipo = c.getInt(3);
                double latitud = c.getDouble(4);
                double longitud = c.getDouble(5);
                String calle = c.getString(6);
                String foto = c.getString(7);
                String desc = c.getString(8);

                Lugar l = new Lugar(id,nom,telef,tipo,latitud,longitud,calle,foto,desc);
                info.add(l);

            }while(c.moveToNext());
        }

        Lugar[] datos = info.toArray(new Lugar[0]);

        final AdaptadorLugares adaptador = new AdaptadorLugares(this,datos);

        final ListView lista = findViewById(R.id.listaLugar);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Lugar lug = (Lugar) lista.getItemAtPosition(position);
                Intent intento = new Intent(view.getContext(),InfoCompleta.class);

                intento.putExtra("Info",lug);
                startActivity(intento);

                db.close();
            }
        });
    }
}
