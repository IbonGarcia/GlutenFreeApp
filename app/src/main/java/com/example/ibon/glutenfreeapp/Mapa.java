package com.example.ibon.glutenfreeapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Icon;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.model.Marker;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

import java.util.ArrayList;


public class Mapa extends AppCompatActivity implements LocationListener{

    private MapView mapView;
    private double latitude;
    private double longitude;
    private LocationManager lm;
    private MapboxMap mapboxMap;
    private Criteria criteria;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 0;

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

            } else {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
            }
        }

        Mapbox.getInstance( this,getString( R.string.mapbox_key ) );
        setContentView(R.layout.activity_mapa);
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        LugaresSQLiteHelper lsq = new LugaresSQLiteHelper(this,"BBDD",null,1);
        final SQLiteDatabase db = lsq.getWritableDatabase();

        mapView.getMapAsync(new OnMapReadyCallback() {

            public void onMapReady(@NonNull MapboxMap mapboxMap) {
                mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {

                    public void onStyleLoaded(@NonNull Style style) {
                    }
                });
                mapboxMap.getUiSettings().setLogoEnabled( false );
                mapboxMap.getUiSettings().setCompassEnabled( false );
                mapboxMap.getUiSettings().setAttributionEnabled( false );

                getLocation();

                CameraPosition cp = new CameraPosition.Builder()
                        .target(new LatLng(latitude, longitude)) // Sets the new camera position
                        .zoom(17) // Sets the zoom
                        .bearing(180) // Rotate the camera
                        .tilt(30) // Set the camera tilt
                        .build(); // Creates a CameraPosition from the builder

                mapboxMap.setCameraPosition(cp);

                mapboxMap.clear();


                Cursor c = db.rawQuery("SELECT idlugar,nombre,telefono,tipo,latitud,longitud,calle,foto,descripcion FROM lugar ", null);


                if (c.moveToFirst()){

                    do{
                        IconFactory factory = IconFactory.getInstance(  Mapa.this );
                        double lat = c.getDouble(4);
                        double lon = c.getDouble(5);
                        if(c.getInt(3) == 0){
                            mapboxMap.addMarker(new MarkerOptions().position(new LatLng(lat,lon)));
                        }
                        else{
                            mapboxMap.addMarker(new MarkerOptions().position(new LatLng(lat, lon)).setIcon(factory.fromResource(R.drawable.ic_marker_v)));

                        }

                    }while(c.moveToNext());
                }
            }
        });
    }

    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    public void getLocation(){

        lm = (LocationManager)  this.getSystemService(Context.LOCATION_SERVICE);
        criteria = new Criteria();
        String bestProvider = String.valueOf(lm.getBestProvider(criteria, true)).toString();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location location = lm.getLastKnownLocation(bestProvider);
        if(location!=null){
            latitude = location.getLatitude();
            longitude = location.getLongitude();
        }
        else {
            lm.requestLocationUpdates(bestProvider, 1000, 0, (LocationListener) this);
        }
    }

    public void onLocationChanged(Location location) {

        //remove location callback:
        lm.removeUpdates(this);

        latitude = location.getLatitude();
        longitude = location.getLongitude();

        CameraPosition cp = new CameraPosition.Builder()
                .target(new LatLng(latitude, longitude)) // Sets the new camera position
                .zoom(17) // Sets the zoom
                .bearing(180) // Rotate the camera
                .tilt(30) // Set the camera tilt
                .build(); // Creates a CameraPosition from the builder

        mapboxMap.setCameraPosition(cp);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
