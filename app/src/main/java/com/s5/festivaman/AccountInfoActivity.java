package com.s5.festivaman;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;

import com.s5.festivaman.activities.DrawerActivity;
import com.s5.festivaman.modifaccount.bracelet;
import com.s5.festivaman.modifaccount.email;
import com.s5.festivaman.modifaccount.password;

public class AccountInfoActivity extends DrawerActivity {

    @Override
    protected void startActivity() {
        setContentView(R.layout.activity_account_info);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

    }



    public void onClic_userName(View view) {

        new AlertDialog.Builder(this)
                .setTitle("Modification du nom d'utilisateur")
                .setMessage("Désoler la fonctionnalité n'est pas encore implémentée")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                }).show();
//        Intent intent = new Intent(this, user_name.class);
//        startActivity(intent);

    }

    public void onClic_password(View view)
    {
        Intent intent = new Intent(this, password.class);
        startActivity(intent);
    }

    public void onClic_email(View view)
    {
        Intent intent = new Intent(this, email.class);
        startActivity(intent);
    }

    public void onClic_date(View view)
    {
        Intent intent = new Intent(this, BirthDate.class);
        startActivity(intent);
    }

    public void onClic_bracelet(View view)
    {
        Intent intent = new Intent(this, bracelet.class);
        startActivity(intent);
    }
}