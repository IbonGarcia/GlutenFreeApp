package com.example.ibon.glutenfreeapp;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.ibon.glutenfreeapp.MainActivity.solicitarPermiso;

public class Lista extends AppCompatActivity {

    private Cursor c;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);


        solicitarPermiso("android.permission.CALL_PHONE", "La aplicacion necesita permisos para poder realizar llamadas.", 1, this);
        LugaresSQLiteHelper lsq = new LugaresSQLiteHelper(this, "BBDD", null, 1);

        final SQLiteDatabase db = lsq.getWritableDatabase();

        int filtro = getIntent().getIntExtra("filtro",3);

        if(filtro == 2) {
            c = db.rawQuery("SELECT idlugar,nombre,telefono,tipo,latitud,longitud,calle,foto,descripcion FROM lugar ", null);
        }
        if(filtro == 0){
            // COMERCIOS
            c = db.rawQuery("SELECT idlugar,nombre,telefono,tipo,latitud,longitud,calle,foto,descripcion FROM lugar WHERE tipo=1 ", null);
        }
        if(filtro == 1){
            // RESTAURANTES
            c = db.rawQuery("SELECT idlugar,nombre,telefono,tipo,latitud,longitud,calle,foto,descripcion FROM lugar WHERE tipo=0 ", null);
        }

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

    public void back(View view){

        Intent intento = new Intent(this,MainActivity.class);
        startActivity(intento);
        finish();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.filtro:
                openFilter();
                return true;
            case R.id.Appinfo:
                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void openFilter(){
        Intent intento = new Intent(getApplicationContext(),Filtro.class);
        intento.putExtra("activity","lista");
        startActivity(intento);
        finish();
    }
    public void openSettings(){

        Intent intento = new Intent(getApplicationContext(),AppInfo.class);
        intento.putExtra("activity","lista");
        startActivity(intento);
        finish();
    }
}
