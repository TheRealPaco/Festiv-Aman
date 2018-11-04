package com.s5.festivaman;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class AccountInfoActivity extends AppCompatActivity {
    //TODO Check activity instantiate multiple times
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(MenuItem menuItem) {

                        mDrawerLayout.closeDrawers();
                        switch (menuItem.getItemId()) {
                            case R.id.nav_accueil: {
                                break;
                            }
                            case R.id.nav_amis: {
                                break;
                            }
                            case R.id.nav_carte: {
                                break;
                            }
                            case R.id.nav_compte_utilisateur: {
                                break;
                            }
                            case R.id.nav_logout: {
                                break;
                            }
                            default:{};
                        }

                        return true;
                    }
                });
    }

    /*
     * If drawer is open close it instead of going back when back button is pressed
     */
    @Override
    public void onBackPressed() {
       if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
           mDrawerLayout.closeDrawers();
       }
       else {
           super.onBackPressed();
       }
    }
}