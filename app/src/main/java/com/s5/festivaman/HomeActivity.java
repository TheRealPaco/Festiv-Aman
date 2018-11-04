package com.s5.festivaman;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BulletSpan;
import android.view.MenuItem;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    public void onBackPressed() {

        mDrawerLayout.closeDrawers();
        super.onBackPressed();
    }

    public void ImagePage(View view) {
        Intent intent = new Intent( this, LoginActivity.class);
        startActivity(intent);
    }

    public void friendPage(View view) {
        Intent intent = new Intent( this, LoginActivity.class);
        startActivity(intent);
    }

    public void UserAccount(View view) {
        Intent intent = new Intent( this, AccountInfoActivity.class);
        startActivity(intent);
    }


    protected void startAccountInfoActivity() {
        Intent intent = new Intent( this, AccountInfoActivity.class);
        startActivity(intent);
    }
}
