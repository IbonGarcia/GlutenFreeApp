package com.example.ibon.glutenfreeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Filtro extends AppCompatActivity {

    private String activity;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro);

        activity = getIntent().getStringExtra("activity");
        TextView tv = findViewById(R.id.tituloFiltro);
         if(activity.equals("mapa")){
             tv.setText(R.string.FiltroMapa);
         }
         else{
            tv.setText(R.string.FiltroLista);
         }
    }

    public void filtrar(View view){

        if(activity.equals("mapa")){

            Intent intento = new Intent(getApplicationContext(),Mapa.class);

            RadioButton rb1 = findViewById(R.id.filtro_todos);
            RadioButton rb2 = findViewById(R.id.filtro_comercios);
            RadioButton rb3 = findViewById(R.id.filtro_restaurantes);
            if(rb1.isChecked()){
                intento.putExtra("filtro",2);
            }
            if(rb2.isChecked()){
                intento.putExtra("filtro",0);
            }
            if(rb3.isChecked()){
                intento.putExtra("filtro",1);
            }

            startActivity(intento);
            finish();
        }

        if(activity.equals("lista")){
            Intent intento = new Intent(getApplicationContext(),Lista.class);

            RadioButton rb1 = findViewById(R.id.filtro_todos);
            RadioButton rb2 = findViewById(R.id.filtro_comercios);
            RadioButton rb3 = findViewById(R.id.filtro_restaurantes);
            if(rb1.isChecked()){
                intento.putExtra("filtro",2);
            }
            if(rb2.isChecked()){
                intento.putExtra("filtro",0);
            }
            if(rb3.isChecked()){
                intento.putExtra("filtro",1);
            }

            startActivity(intento);
            finish();
        }

    }

}
