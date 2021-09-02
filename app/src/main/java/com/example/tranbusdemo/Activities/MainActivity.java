package com.example.tranbusdemo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.example.tranbusdemo.Adapters.SearchAdapter;
import com.example.tranbusdemo.Models.Locations;
import com.example.tranbusdemo.R;
import com.example.tranbusdemo.Util.Statics;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    FusedLocationProviderClient fusedLocationProviderClient;
    GoogleMap map;
    LatLng latLng;
    int j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.location_fr_map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.map_style));

            if (!success) {
                Log.e("TrackDetailsActivity", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("TrackDetailsActivity", "Can't find style. Error: ", e);
            e.printStackTrace();
        }

        for(int i=0;i< Statics.buses.size();i++){
            LatLng latLng=new LatLng(Statics.buses.get(i).getLocation().getLatitude(),Statics.buses.get(i).getLocation().getLongitude());
            MarkerOptions marker = new MarkerOptions().position(latLng).title(Statics.buses.get(i).getTrack().getTrack_name_Ar());
            marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_marker));
            googleMap.addMarker(marker);
        }

        Handler h = new Handler();
        int delay = 5 * 1000;
            h.postDelayed(new Runnable() {
                public void run() {
                    // This portion of code runs each 10s.
                    googleMap.clear();
                    for (int i = 0; i < Statics.buses.size(); i++) {
                        float f=(float) j/1000f;
                        LatLng latLng = new LatLng(Statics.buses.get(i).getLocation().getLatitude() + f, Statics.buses.get(i).getLocation().getLongitude() - f);
                        Statics.buses.get(i).setLocation(new Locations(Statics.buses.get(i).getLocation().getId(),Statics.buses.get(i).getLocation().getLatitude() + f, Statics.buses.get(i).getLocation().getLongitude() - f));
                        MarkerOptions marker = new MarkerOptions().position(latLng).title(Statics.buses.get(i).getTrack().getTrack_name_Ar());
                        marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_marker));
                        googleMap.addMarker(marker);
                    }
                    j++;
                    h.postDelayed(this, delay);
                }
            }, delay);


        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                LatLng latLng=marker.getPosition();
                for(int i=0;i< Statics.buses.size();i++) {
                    if(latLng.latitude==Statics.buses.get(i).getLocation().getLatitude()&&Statics.buses.get(i).getLocation().getLongitude()==latLng.longitude){
                        Intent intent=new Intent(getApplicationContext(),BusDetailsActivity.class);
                        intent.putExtra("id",Statics.buses.get(i).getId()+"");
                        startActivity(intent);
                        finish();

                    }

                }
                return false;
            }
        });

        latLng=new LatLng(32.012845, 35.869749);
        map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14));


        if (ActivityCompat.checkSelfPermission(this.getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this.getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        map.setMyLocationEnabled(true);
    }

    public void seeAllTracks(View view) {
        startActivity(new Intent(this,AllTracksActivity.class));
    }

    public void search(View view) {
        startActivity(new Intent(this, SearchActivity.class));
    }
}