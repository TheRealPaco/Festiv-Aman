package com.s5.festivaman.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.s5.festivaman.AccountInfoActivity;
import com.s5.festivaman.EventsActivity;
import com.s5.festivaman.FriendsActivity;
import com.s5.festivaman.GroupsActivity;
import com.s5.festivaman.HomeActivity;
import com.s5.festivaman.LoginActivity;
import com.s5.festivaman.MapActivity;
import com.s5.festivaman.MeetingsActivity;
import com.s5.festivaman.R;

public class DrawerActivity extends AppCompatActivity {

    protected DrawerLayout mDrawerLayout;
    protected NavigationView navigationView;

    protected void startActivity() {
        setContentView(R.layout.activity_app_loading);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.startActivity();

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
                                startIntent(MapActivity.class, true);
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

    /*
     * If drawer is open close it instead of going back when back button is pressed
     */
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
