package com.example.ibon.glutenfreeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class AppInfo extends AppCompatActivity {

    private String activity;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_app_info);

        activity = getIntent().getStringExtra("activity");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.back_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.AppInfoBack:
                backToActivity();
                return true;
        }
        return true;
    }

    public void backToActivity(){

        if(activity.equals("mapa")){
            Intent intento = new Intent(getApplicationContext(), Mapa.class);
            intento.putExtra("filtro",2);
            startActivity(intento);
            finish();
        }
        if(activity.equals("lista")){
            Intent intento = new Intent(getApplicationContext(), Lista.class);
            intento.putExtra("filtro",2);
            startActivity(intento);
            finish();
        }
    }
}
