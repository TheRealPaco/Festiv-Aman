package com.s5.festivaman;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.s5.festivaman.activities.DrawerActivity;

public class AccountInfoActivity extends DrawerActivity {

    @Override
    protected void startActivity() {
        setContentView(R.layout.activity_account_info);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
    }
}