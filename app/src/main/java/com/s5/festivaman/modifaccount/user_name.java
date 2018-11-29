package com.s5.festivaman.modifaccount;

import android.widget.EditText;
import android.widget.TextView;

import com.s5.festivaman.R;
import com.s5.festivaman.activities.DrawerActivity;

public class user_name extends DrawerActivity {

    @Override
    protected void startActivity() {
        setContentView(R.layout.activity_modif_account);
        ((TextView) findViewById(R.id.modification_name)).setText("Nom d'utilisateur");
        ((EditText) findViewById(R.id.modification)).setHint("Nom d'utilisateur");
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
    }

    protected boolean send_userName()
    {
        //TODO send the modification of the username to the database
        return true;

    }
}
