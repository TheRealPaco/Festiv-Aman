package com.s5.festivaman.modifaccount;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.s5.festivaman.R;
import com.s5.festivaman.Socket.DatabaseQueries;
import com.s5.festivaman.activities.DrawerActivity;

public class email extends DrawerActivity {
    private AlertDialog.Builder ErrorDialog;
    @Override
    protected void startActivity() {
        setContentView(R.layout.activity_modif_account);
        ((TextView) findViewById(R.id.modification_name)).setText("Email");
        EditText password = findViewById(R.id.modification);
        password.setHint("Email");
        password.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        ErrorDialog = new AlertDialog.Builder(this)
                .setTitle("Erreur")
                .setMessage("Échec de la Modification")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });

        Button button = findViewById(R.id.buttonModif);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (send_Email()) {
                    finish();
                } else {
                    ErrorDialog.show();

                }
            }
        });

    }

    protected boolean send_Email() {
        String data = ((EditText)findViewById(R.id.modification)).getText().toString();
        return new DatabaseQueries().modifAccount("email",data);
    }

}