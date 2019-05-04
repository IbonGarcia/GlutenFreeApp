package com.example.ibon.glutenfreeapp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;


public class Mapa extends AppCompatActivity implements LocationListener, MapboxMap.OnMarkerClickListener {

    private MapView mapView;
    private double latitude;
    private double longitude;
    private LocationManager lm;
    private Criteria criteria;
    private boolean inMarker;
    private Location location;
    private static final int MAP_ANIMATION_TIME = 700;
    private SQLiteDatabase db;
    private CameraPosition lastCp;
    private RelativeLayout rlTitulo,rlControles;
    private TextView titulo;
    private String telefono;
    private String nombre;
    private MapboxMap mapboxMap;
    private Marker marker;


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

        Mapbox.getInstance(this, getString(R.string.mapbox_key));
        setContentView(R.layout.activity_mapa);
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        LugaresSQLiteHelper lsq = new LugaresSQLiteHelper(this, "BBDD", null, 1);
        db = lsq.getWritableDatabase();

        mapView.getMapAsync(new OnMapReadyCallback() {

            public void onMapReady(@NonNull MapboxMap mapboxMap) {

                mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {

                    public void onStyleLoaded(@NonNull Style style) {
                    }
                });

                mapboxMap.setOnMarkerClickListener(Mapa.this);
                mapboxMap.getUiSettings().setLogoEnabled(false);
                mapboxMap.getUiSettings().setCompassEnabled(false);
                mapboxMap.getUiSettings().setAttributionEnabled(false);

                getLocation();

                CameraPosition cp = new CameraPosition.Builder()
                        .target(new LatLng(latitude, longitude)) // Sets the new camera position
                        .zoom(17) // Sets the zoom
                        .bearing(180) // Rotate the camera
                        .tilt(30) // Set the camera tilt
                        .build(); // Creates a CameraPosition from the builder

                mapboxMap.setCameraPosition(cp);
                mapboxMap.setMaxZoomPreference(20.05);
                mapboxMap.setMinZoomPreference(15.05);

                mapboxMap.clear();

                Cursor c = db.rawQuery("SELECT idlugar,nombre,telefono,tipo,latitud,longitud,calle,foto,descripcion FROM lugar ", null);

                if (c.moveToFirst()) {

                    do {
                        IconFactory factory = IconFactory.getInstance(Mapa.this);
                        double lat = c.getDouble(4);
                        double lon = c.getDouble(5);

                        if (c.getInt(3) == 0) {
                            // RESTAURANTE
                            mapboxMap.addMarker(new MarkerOptions().position(new LatLng(lat, lon)).setTitle(c.getString(1)));
                        } else {
                            // COMERCIO
                            mapboxMap.addMarker(new MarkerOptions().position(new LatLng(lat, lon)).setTitle(c.getString(1)));
                            // mapboxMap.addMarker(new MarkerOptions().position(new LatLng(lat, lon)).setIcon(factory.fromResource(R.drawable.ic_marker_v)));
                        }

                    } while (c.moveToNext());
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

    public void getLocation() {

        lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        criteria = new Criteria();
        String bestProvider = String.valueOf(lm.getBestProvider(criteria, true)).toString();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location location = lm.getLastKnownLocation(bestProvider);
        if (location != null) {
            this.location = location;
            latitude = location.getLatitude();
            longitude = location.getLongitude();
        } else {
            Toast toast1 = Toast.makeText(getApplicationContext(), " LOCATION UPDATES ", Toast.LENGTH_SHORT);
            toast1.show();
            lm.requestLocationUpdates(bestProvider, 1000, 0, (LocationListener) this);
        }
    }

    public void onLocationChanged(Location location) {

        //remove location callback:
        // lm.removeUpdates(this);

        latitude = location.getLatitude();
        longitude = location.getLongitude();

        mapView.getMapAsync(new OnMapReadyCallback() {

            public void onMapReady(@NonNull MapboxMap mapboxMap) {

                CameraPosition cp = new CameraPosition.Builder()
                        .target(new LatLng(latitude, longitude)) // Sets the new camera position
                        .zoom(17) // Sets the zoom
                        .bearing(180) // Rotate the camera
                        .tilt(30) // Set the camera tilt
                        .build(); // Creates a CameraPosition from the builder

                mapboxMap.setCameraPosition(cp);
            }
        });
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    public void onProviderEnabled(String provider) {

    }

    public void onProviderDisabled(String provider) {

    }

    // METODO QUE CONTROLA EL EVENTO QUE SUCEDE CUANDO SE HACE CLICK SOBRE EL BOTON ATRAS
    // SI LA CAMARA ESTA 'SITUADA' EN UN MARCADOR AL HACER CLICK SOBRE EL BOTON SE SITUA LA CAMARA DONDE ESTABA ANTES DE PULSAR EL MARCADOR
    // SI LA CAMARA NO ESTA SITUADA EN NINGUN MARCADOR DARLE AL BOTON ATRAS CIERRA LA ACTIVIDAD ACTUAL Y VUELVE A EL MENU PRINCIPAL
    public void back(View view) {

        if (inMarker) {

            inMarker = false;
            marker.hideInfoWindow();
            mapView.getMapAsync(new OnMapReadyCallback() {

                public void onMapReady(@NonNull MapboxMap mapboxMap) {

                    // mapboxMap.setCameraPosition(cp);
                    mapboxMap.animateCamera( CameraUpdateFactory.newCameraPosition(lastCp), MAP_ANIMATION_TIME );
                    mapboxMap.getUiSettings().setAllGesturesEnabled(true);
                }
            });
            rlTitulo = findViewById(R.id.layoutTitulo);
            rlTitulo.setVisibility(View.INVISIBLE);

            rlControles = findViewById(R.id.layoutControles);
            rlControles.setVisibility(View.INVISIBLE);
        }
        else {

            Intent intento = new Intent(this, MainActivity.class);
            startActivity(intento);
            finish();
        }
    }

    public void restoreCameraButton(View view) {

        rlTitulo = findViewById(R.id.layoutTitulo);
        rlTitulo.setVisibility(View.INVISIBLE);

        rlControles = findViewById(R.id.layoutControles);
        rlControles.setVisibility(View.INVISIBLE);

        getLocation();
        mapView.getMapAsync(new OnMapReadyCallback() {

            public void onMapReady(@NonNull MapboxMap mapboxMap) {

                CameraPosition cp = new CameraPosition.Builder()
                        .target(new LatLng(latitude, longitude)) // Sets the new camera position
                        .zoom(17) // Sets the zoom
                        .bearing(180) // Rotate the camera
                        .tilt(30) // Set the camera tilt
                        .build(); // Creates a CameraPosition from the builder

                mapboxMap.animateCamera( CameraUpdateFactory.newCameraPosition( cp ), MAP_ANIMATION_TIME );
                mapboxMap.getUiSettings().setAllGesturesEnabled(true);

            }
        });
    }

    // LISTENER PARA LOS MARCADORES
    public boolean onMarkerClick(@NonNull final Marker marker) {

        this.marker = marker;

        nombre = marker.getTitle();

        Cursor c =  db.rawQuery("SELECT idlugar,nombre,telefono,tipo,latitud,longitud,calle,foto,descripcion FROM lugar WHERE nombre = '"+nombre+"' ", null);

        if (c.moveToFirst()) {

            telefono = c.getString(2);

            rlTitulo = findViewById(R.id.layoutTitulo);
            rlTitulo.setVisibility(View.VISIBLE);

            rlControles = findViewById(R.id.layoutControles);
            rlControles.setVisibility(View.VISIBLE);

            titulo = findViewById(R.id.lugarName);
            titulo.setText(c.getString(1));

            moveCameraTo(c.getDouble(4),c.getDouble(5));
        }
        return false;
    }

    public void moveCameraTo(final double lat, final double lon){

        inMarker = true;
        mapView.getMapAsync(new OnMapReadyCallback() {

            public void onMapReady(@NonNull MapboxMap mapboxMap) {

                lastCp = mapboxMap.getCameraPosition();

                CameraPosition cp = new CameraPosition.Builder()
                        .target(new LatLng(lat, lon)) // Sets the new camera position
                        .zoom(18) // Sets the zoom
                        .bearing(180) // Rotate the camera
                        .tilt(30) // Set the camera tilt
                        .build(); // Creates a CameraPosition from the builder

                // mapboxMap.setCameraPosition(cp);
                mapboxMap.animateCamera( CameraUpdateFactory.newCameraPosition( cp ), MAP_ANIMATION_TIME );
                mapboxMap.getUiSettings().setAllGesturesEnabled(false);
            }
        });
    }

    // METODOS PARA LOS CONTROLES
    public void llamarLugar(View view) {

        if (ActivityCompat.checkSelfPermission(Mapa.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        String llamada = "tel:"+telefono;
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(llamada)));
    }
    public void verInfo(View view) {

        Cursor c =  db.rawQuery("SELECT idlugar,nombre,telefono,tipo,latitud,longitud,calle,foto,descripcion FROM lugar WHERE nombre = '"+nombre+"' ", null);
        if(c.moveToFirst()){

            Lugar lug = new Lugar(c.getInt(0),
                    c.getString(1),
                    c.getString(2),
                    c.getInt(3),
                    c.getDouble(4),
                    c.getDouble(5),
                    c.getString(6),
                    c.getString(7),
                    c.getString(8));
            Intent intento = new Intent(view.getContext(),InfoCompleta.class);
            intento.putExtra("Info",lug);
            startActivity(intento);
        }
    }
}