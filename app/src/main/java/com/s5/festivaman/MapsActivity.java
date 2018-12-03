package com.s5.festivaman;

        import android.content.Intent;
        import android.support.design.widget.NavigationView;
        import android.support.v4.app.FragmentActivity;
        import android.os.Bundle;
        import android.support.v4.view.GravityCompat;
        import android.support.v4.widget.DrawerLayout;
        import android.view.MenuItem;

        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.OnMapReadyCallback;
        import com.google.android.gms.maps.SupportMapFragment;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    protected DrawerLayout mDrawerLayout;
    protected NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

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
                                //TODO logout user
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sherbrooke and move the camera
        LatLng sherbrooke = new LatLng(45.3781, -71.9261);
        mMap.addMarker(new MarkerOptions().position(sherbrooke).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sherbrooke));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sherbrooke, 16 ));

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
}



