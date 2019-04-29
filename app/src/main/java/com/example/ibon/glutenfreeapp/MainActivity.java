package com.example.ibon.glutenfreeapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

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
    }
}
