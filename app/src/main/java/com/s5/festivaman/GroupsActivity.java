package com.s5.festivaman;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.s5.festivaman.activities.DrawerActivity;
import com.s5.festivaman.modifaccount.bracelet;

public class GroupsActivity extends DrawerActivity {

    @Override
    protected void startActivity() {
        setContentView(R.layout.activity_groups);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
    }
    public void newGroup(View view)
    {
        Intent intent = new Intent(this, NewGroup.class);
        startActivity(intent);
    }

}
