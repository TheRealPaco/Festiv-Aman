package com.s5.festivaman;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.s5.festivaman.Socket.DatabaseQueries;
import com.s5.festivaman.user.User;

import java.util.ArrayList;
import java.util.List;

public class EventsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    protected DrawerLayout mDrawerLayout;
    protected NavigationView navigationView;

    protected List<userMarker> markerList;
    protected int currentMarker = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        markerList = new ArrayList<>();

        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        mDrawerLayout.closeDrawers();
                        switch (menuItem.getItemId()) {
                            case R.id.nav_accueil: {

                                startIntent(HomeActivity.class, true);
                                break;
                            }
                            case R.id.nav_amis: {
                                startIntent(FriendsActivity.class, true);
                                break;
                            }
                            case R.id.nav_groups: {
                                startIntent(GroupsActivity.class, true);
                                break;
                            }
                            case R.id.nav_events: {
                                startIntent(EventsActivity.class, true);
                                break;
                            }
                            case R.id.nav_meetings: {
                                startIntent(MeetingsActivity.class, true);
                                break;
                            }
                            case R.id.nav_carte: {
                                startIntent(MapsActivity.class, true);
                                break;
                            }
                            case R.id.nav_compte_utilisateur: {
                                startIntent(AccountInfoActivity.class, true);
                                break;
                            }
                            case R.id.nav_logout: {
                                User.logOut();
                                startIntent(LoginActivity.class, true);
                                finish();
                                break;
                            }
                            default: {
                            }
                            ;
                        }
                        return true;
                    }
                });
    }

    private void startIntent(Class<?> tClass, boolean clearTop) {
        Intent intent = new Intent(this, tClass);
        if (clearTop) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        }
        startActivity(intent);
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
    protected int zoom = 15;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        List<String> list = new DatabaseQueries().getEventsPosition();

        LatLng marker = null;
        if (list != null) {
            for (String pos: list) {
                String[] userPos = pos.split(";");
                marker = new LatLng(Float.parseFloat(userPos[1]),Float.parseFloat(userPos[2]));
                mMap.addMarker(new MarkerOptions().position(marker).title(userPos[0]));
                markerList.add(new userMarker(userPos[0], marker));
            }
        }  else {
            //Set a default marker to udes engineer faculty
            marker = new LatLng(45.3781, -71.9261);
            mMap.addMarker(new MarkerOptions().position(marker));
            markerList.add(new userMarker("Default", marker));
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLng(marker));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker, zoom ));
        currentMarker = markerList.size()-1;
        ((TextView)findViewById(R.id.eventTextView)).setText(markerList.get(currentMarker).getUser());
    }

    public void pastMarker(View view) {
        if (currentMarker <= 0) {
            currentMarker = markerList.size() -1;
        } else {
            currentMarker --;
        }
        LatLng toFocusMarker = markerList.get(currentMarker).getMarker();
        ((TextView)findViewById(R.id.eventTextView)).setText(markerList.get(currentMarker).getUser());
        mMap.moveCamera(CameraUpdateFactory.newLatLng(toFocusMarker));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(toFocusMarker, zoom ));

    }

    public void nextMarker(View view) {
        if (currentMarker >= markerList.size()-1) {
            currentMarker = 0;
        } else {
            currentMarker++;
        }
        LatLng toFocusMarker = markerList.get(currentMarker).getMarker();
        ((TextView)findViewById(R.id.eventTextView)).setText(markerList.get(currentMarker).getUser());

        mMap.moveCamera(CameraUpdateFactory.newLatLng(toFocusMarker));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(toFocusMarker, zoom ));

    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawers();
        } else {
            startIntent(HomeActivity.class, true );
            //super.onBackPressed();
        }
    }

    private class userMarker {

        private String user;
        private LatLng marker;

        public userMarker(String user, LatLng marker) {
            this.marker = marker;
            this.user = user;
        }

        public LatLng getMarker() {
            return marker;
        }

        public String getUser() {
            return user;
        }

    }
}
