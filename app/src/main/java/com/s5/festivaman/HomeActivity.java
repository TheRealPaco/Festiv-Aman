package com.s5.festivaman;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
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
        Intent intent = new Intent(this, FriendsActivity.class);
        startActivity(intent);
    }

    public void UserAccount(View view) {
        Intent intent = new Intent(this, AccountInfoActivity.class);
        startActivity(intent);
    }

    public void map(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void event(View view) {
        Intent intent = new Intent(this, EventsActivity.class);
        startActivity(intent);

    }

    public void groupe (View view) {
        Intent intent = new Intent(this, GroupsActivity.class);
        startActivity(intent);

    }

    public void meeting (View view) {
        Intent intent = new Intent(this, MeetingsActivity.class);
        startActivity(intent);

    }

}

