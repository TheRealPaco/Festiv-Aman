package com.s5.festivaman.modifaccount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.TextView;

import com.s5.festivaman.R;
import com.s5.festivaman.activities.DrawerActivity;

public class date extends DrawerActivity {

    @Override
    protected void startActivity() {
        setContentView(R.layout.activity_modif_account);
        ((TextView) findViewById(R.id.modification_name)).setText("Date de naissance");
        EditText password = findViewById(R.id.modification);
        password.setHint("AAAA/MM/JJ");
        password.setInputType(InputType.TYPE_DATETIME_VARIATION_TIME);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
    }

    protected boolean send_password() {
        //TODO send the modification of the username to the database
        return true;

    }

}