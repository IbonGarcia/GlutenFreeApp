package com.example.ibon.glutenfreeapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

public class AdaptadorLugares extends ArrayAdapter<Lugar> {


    private Lugar[] datos;
    private Context contex;
    public AdaptadorLugares(Context context,Lugar[] datos) {

        super(context, R.layout.listitem_lugar, datos);
        this.contex=context;
        this.datos = datos;
    }


    public View getView(int position,View convertView, ViewGroup parent){

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_lugar, null);

        ImageView iv = item.findViewById(R.id.fotoLugar);
        String image = datos[position].getFoto();
        String[] nom = image.split("\\.");
        Log.d("nom","NOM : "+nom[0]);
        int id = contex.getResources().getIdentifier(nom[0], "drawable", contex.getPackageName());

        Log.d("ID","ID: "+id);
        Log.d("Nombre","Nombre: "+image);

        iv.setImageResource(id);

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

    public static void LoadImageFromWebOperations(String url,ImageView iv) {

        Log.d("PRUEBA","URL: "+url);
        try {

            URL newurl = new URL(url);
            Bitmap val = BitmapFactory.decodeStream(newurl.openConnection().getInputStream());
            iv.setImageBitmap(val);

        } catch (Exception e) {
            Log.d("PRUEBA","ERROR");
        }
    }

    // EL SIGUIENTE METODO SE CREO PORQUE EN UN PRINCIPIO SE GUARDABA LA URL DE LA IMAGEN DE CADA LUGAR EN LA BASE DE DATOS, CON ESTE METODO SE ACCEDIA A DICHA URL
    // Y SE CARGABA EN EL IMAGEVIEW, EL PROBLEMA ES QUE ESTO ERA MUY LENTO Y TARDA BASTANTE EN CARGAR AL LISTVIEW CON TODA LA INFORMACION
    // ASIQUE AL FINAL SE DESCARGARON LAS IMAGENES SE GUARDARON Y EN LA BBDD SOLO SE GUARDABA EL NOMBRE DE DICHA IMAGEN.
    /*
    public void cargarImagen(){

        // EL SIGUIENTE TRY CATCH SIRVE PARA CARGAR LAS
        // UTILIZA LA URL DE LA BBDD, ACCEDE A ELLA Y 'PONE' LA IMAGEN EN EL IMAGEVIEW
        try {
            Class strictMode = Class.forName("android.os.StrictMode");
            Method enableDefaults = strictMode.getMethod("enableDefaults");
            enableDefaults.invoke(null);
            Log.d("PRUEBA","URL: "+datos[position].getFoto());
            Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(datos[position].getFoto()).getContent());
            iv.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    */


}
