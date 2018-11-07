package com.s5.festivaman;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MeetingsActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetings);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        mDrawerLayout.closeDrawers();
                        switch (menuItem.getItemId()) {
                            case R.id.nav_accueil: {
                                startIntent(HomeActivity.class, false);
                                break;
                            }
                            case R.id.nav_amis: {
                                startIntent(FriendsActivity.class, false);
                                break;
                            }
                            case R.id.nav_groups: {
                                startIntent(GroupsActivity.class, false);
                                break;
                            }
                            case R.id.nav_events: {
                                startIntent(EventsActivity.class, false);
                                break;
                            }
                            case R.id.nav_meetings: {
                                startIntent(MeetingsActivity.class, false);
                                break;
                            }
                            case R.id.nav_carte: {
                                startIntent(MapActivity.class, false);
                                break;
                            }
                            case R.id.nav_compte_utilisateur: {
                                startIntent(AccountInfoActivity.class, false);
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

    /*
     * If drawer is open close it instead of going back when back button is pressed
     */
    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }

    }
}
