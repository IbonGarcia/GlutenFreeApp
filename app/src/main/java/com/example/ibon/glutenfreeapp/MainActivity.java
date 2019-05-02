package com.example.ibon.glutenfreeapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv = findViewById(R.id.btnLista);
        iv.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN){

                    ImageView iv = findViewById(R.id.btnLista);
                    iv.setImageResource(R.drawable.ic_mainhover);
                }
                else{
                    if(event.getAction() == MotionEvent.ACTION_UP){
                        ImageView iv = findViewById(R.id.btnLista);
                        iv.setImageResource(R.drawable.ic_mainbtn);

                        Intent intento = new Intent(v.getContext(),Lista.class);
                        startActivity(intento);
                        finish();
                    }
                }
                return true;
            }
        });

        final ImageView mapa = findViewById(R.id.mapa);
        mapa.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN){
                        mapa.setImageResource(R.drawable.ic_mainhover);
                }
                else{
                    if(event.getAction()==MotionEvent.ACTION_UP){

                        mapa.setImageResource(R.drawable.ic_mainbtn);
                        Intent intento = new Intent(v.getContext(),Mapa.class);
                        startActivity(intento);
                        finish();
                    }
                }

                return true;
            }
        });

        final ImageView salir = findViewById(R.id.salir);
        salir.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    salir.setImageResource(R.drawable.ic_mainhover);
                }
                else{

                    if(event.getAction() == MotionEvent.ACTION_UP){
                        salir.setImageResource(R.drawable.ic_mainbtn);
                        finish();
                    }
                }
                return true;
            }
        });
    }

    public static void solicitarPermiso(final String permiso, String justificacion, final int requestCode, final Activity actividad) {

        ActivityCompat.requestPermissions(actividad,new String[]{permiso}, requestCode);

        if (ActivityCompat.shouldShowRequestPermissionRationale(actividad, permiso)) {

            //Informamos al usuario para qué y por qué se necesitan los permisos
            new AlertDialog.Builder(actividad).setTitle("Solicitud de permiso").setMessage(justificacion).setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            ActivityCompat.requestPermissions(actividad,
                                    new String[]{permiso}, requestCode);
                        }
                    })
                    .show();
        } else {
            //Muestra el cuadro de dialogo para la solicitud de los permisos
            // y registra el permiso según respuesta del usuario
            ActivityCompat.requestPermissions(actividad,new String[]{permiso}, requestCode);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        if (requestCode == 1){
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            }
            else {
                Toast.makeText(this, "Sin el permiso, no puedo realizar llamadas",Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == 2){
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            }
            else {
                Toast.makeText(this, "Sin el permiso, no puedo mostrar el mapa",Toast.LENGTH_SHORT).show();
            }
        }
    }



}
