package com.s5.festivaman;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BulletSpan;
import android.view.MenuItem;
import android.view.View;

import com.s5.festivaman.activities.DrawerActivity;

public class HomeActivity extends DrawerActivity {

    @Override
    protected void startActivity() {
        setContentView(R.layout.activity_home);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawers();
        } else {
            finish();
        }
    }

    public void friendPage(View view) {
        Intent intent = new Intent( this, FriendsActivity.class);
        startActivity(intent);
    }

    public void UserAccount(View view) {
        Intent intent = new Intent( this, AccountInfoActivity.class);
        startActivity(intent);
    }

    public void map(View view) {
        Intent intent = new Intent( this, MapsActivity.class);
        startActivity(intent);
    }
}
