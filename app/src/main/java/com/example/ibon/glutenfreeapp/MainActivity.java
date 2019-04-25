package com.example.ibon.glutenfreeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void lista (View view){

        Intent intento=new Intent(this,Lista.class);
        startActivity(intento);
        finish();
    }


}
