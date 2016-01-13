package com.ocampojohny.medellinapp;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Jumbo_la_65 extends FragmentActivity implements OnMapReadyCallback {





    private GoogleMap mMap;
    private CameraUpdate mcam;

    public Button btactual;
    public Button btsitio;

    public double lat;
    public  double lon;

    LocationManager locationManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puerta_norte_);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btactual = (Button) findViewById(R.id.btnActual);
        btsitio = (Button) findViewById(R.id.btnsitio);

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                updatePosition(location);
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
        };

        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
    }



    public void click(View v) {
        Toast.makeText(getApplicationContext(), "Aquí estás tu", Toast.LENGTH_SHORT).show();
        updatePosition();
        mcam = CameraUpdateFactory.newLatLngZoom(new LatLng(lat,lon),15);
        mMap.animateCamera(mcam);
    }

    public void ir (View v){
        //lat= Double.parseDouble(latitud.getText().toString());
        lat= 6.252125;
        //lon= Double.parseDouble(longitud.getText().toString());
        lon= -75.5875487;
        setmMarker(new LatLng(lat, lon), "Jumbo la 65", "CC");
        mcam = CameraUpdateFactory.newLatLngZoom(new LatLng(lat,lon),15);
        mMap.animateCamera(mcam);

    }

    public void updatePosition() {

        Location loc = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        updatePosition(loc);
    }

    public void updatePosition(Location location){
        if (location!= null){
            lat = location.getLatitude();
            lon= location.getLongitude();
            // data.setText(lat+"/"+lon+new java.util.Date(System.currentTimeMillis()).toString());

        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMyLocationEnabled(true);
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);
        Location myLocation = locationManager.getLastKnownLocation(provider);

        // Get latitude of the current location
        double latitude = myLocation.getLatitude();

        // Get longitude of the current location
        double longitude = myLocation.getLongitude();

        // Create a LatLng object for the current location
        LatLng latLng = new LatLng(latitude, longitude);

        // Show the current location in Google Map
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        // Zoom in the Google Map
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14));
        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("You are here!").snippet("Consider yourself located"));

        LatLng myCoordinates = new LatLng(latitude, longitude);
        CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(myCoordinates, 12);
        mMap.animateCamera(yourLocation);
    }

    private void setmMarker(LatLng position, String titulo, String info){
        mMap.addMarker(new MarkerOptions()

                        .position(position)
                        .title(titulo)
                        .snippet(info)
                // .icon(BitmapDescriptorFactory.fromResource(icon))
        );
    }
}







