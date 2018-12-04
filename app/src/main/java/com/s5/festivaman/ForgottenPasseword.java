package com.s5.festivaman;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ForgottenPasseword extends AppCompatActivity {

    String email;
    String username;

    private AlertDialog.Builder passewordDialog;
    private AlertDialog.Builder newUserErrorDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten_passeword);
        // Prebuild dialog to display possible future error
        passewordDialog= new AlertDialog.Builder(this)
                .setTitle("Mot de passe oublié")
                .setMessage("Un Email va vous être envoyé avec votre nouveau mot de passe")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });


        newUserErrorDialog = new AlertDialog.Builder(this)
                .setTitle("User Creation failed")
                .setMessage("User Creation failed")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
    }

    private boolean isUserInfoValid() {

        return (!isAnyFieldEmpty() && isUsernameAvailable() && isEmailFormatValid());

    }



    private boolean isAnyFieldEmpty() {

        email = ((EditText) findViewById(R.id.adresseMail)).getText().toString();
        username = ((EditText) findViewById(R.id.editTextUserNameLogin)).getText().toString();

        if (email.isEmpty() || username.isEmpty()) {

            newUserErrorDialog.setMessage("Please fill all fields")
                    .show();
            return true;
        }
        return false;

    }

    private boolean isEmailFormatValid() {
        //TODO use regex to check email validity
        if (!email.contains("@")){

            newUserErrorDialog.setMessage("Invalid email format")
                    .show();
            return false;
        }
        return true;
    }

    private boolean isUsernameAvailable() {
        //TODO check in DB if user is used

        if (false) {
            newUserErrorDialog.setMessage("Username not available")
                    .show();
            return false;
        }
        return true;
    }

    public void newPassword(View view)
    {

        try {
            if (isUserInfoValid()) {
                // Start Activity
                passewordDialog.setMessage("Un Email va vous être evoyé avec votre nouveau mot de passe").show();
                //Close the login activity because it's not needed anymore
            }
        } catch (Exception e) {
            newUserErrorDialog.setMessage("Error accessing the database")
                    .show();
        }
    }


}
