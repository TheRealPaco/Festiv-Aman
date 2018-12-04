package com.s5.festivaman.modifaccount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.TextView;

import com.s5.festivaman.R;
import com.s5.festivaman.Socket.DatabaseQueries;
import com.s5.festivaman.activities.DrawerActivity;

public class password extends DrawerActivity {

    @Override
    protected void startActivity() {
        setContentView(R.layout.activity_modif_account);
        ((TextView) findViewById(R.id.modification_name)).setText("Mot de passe");
        EditText password = findViewById(R.id.modification);
        password.setHint("Mot de passe");
        password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
    }

    protected boolean send_password() {
        String data = ((EditText)findViewById(R.id.modification)).getText().toString();
        return new DatabaseQueries().modifAccount("password",data);
    }

}