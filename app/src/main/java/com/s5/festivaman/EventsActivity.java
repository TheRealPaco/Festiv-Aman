package com.s5.festivaman;

import com.s5.festivaman.activities.DrawerActivity;

public class EventsActivity extends DrawerActivity {

    @Override
    protected void startActivity() {
        setContentView(R.layout.activity_events);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
    }
}
