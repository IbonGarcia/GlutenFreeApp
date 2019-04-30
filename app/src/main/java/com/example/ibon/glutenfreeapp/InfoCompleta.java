package com.example.ibon.glutenfreeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoCompleta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_completa);

        // RECOJEMOS EL OBJETO CON LA INFORMACION
        Lugar lug = (Lugar) getIntent().getSerializableExtra("Info");

        ImageView iv = findViewById(R.id.foto);
        String image = lug.getFoto();
        String[] nomimg = image.split("\\.");
        int id = getResources().getIdentifier(nomimg[0], "drawable", getPackageName());
        iv.setImageResource(id);

        TextView nombre = findViewById(R.id.nombreTitulo);
        nombre.setText(lug.getNombre());

        TextView tipo = findViewById(R.id.tipo);
        if(lug.getTipo()==0){
            tipo.setText("Restaurante");
        }
        else{
            tipo.setText("Comercio");
        }

        TextView telefono = findViewById(R.id.telefono);
        telefono.setText(telefono.getText()+" "+lug.getTelefono());


        TextView calle = findViewById(R.id.calle);
        calle.setText(calle.getText()+" "+lug.getCalle());


        TextView desc = findViewById(R.id.descripcion);
        desc.setText(lug.getDescripcion());
    }
}
