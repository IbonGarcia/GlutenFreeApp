package com.example.ibon.glutenfreeapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;

public class AdaptadorLugares extends ArrayAdapter<Lugar> {


    private Lugar[] datos;
    public AdaptadorLugares(Context context,Lugar[] datos) {

        super(context, R.layout.listitem_lugar, datos);
        this.datos = datos;
    }


    public View getView(int position,View convertView, ViewGroup parent){

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_lugar, null);

        ImageView iv = item.findViewById(R.id.fotoLugar);
        iv.setImageDrawable(LoadImageFromWebOperations(datos[position].getFoto()));

        TextView nombre = item.findViewById(R.id.nombreLugar);
        nombre.setText(datos[position].getNombre());

        TextView tipo = item.findViewById(R.id.tipoLugar);
        int tip = datos[position].getTipo();
        if (tip == 0){
            tipo.setText(R.string.restaurante);
        }
        else{
            tipo.setText(R.string.comercio);
        }

        TextView desc = item.findViewById(R.id.descLugar);
        desc.setText(datos[position].getDescripcion());

        return item;
    }

    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is,null);
            return d;
        } catch (Exception e) {
            return null;
        }
    }


}
