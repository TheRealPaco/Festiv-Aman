package com.s5.festivaman;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.s5.festivaman.modifaccount.bracelet;

public class LoginActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private AlertDialog.Builder loginErrorDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Prebuild dialog to display possible future error
        loginErrorDialog = new AlertDialog.Builder(this)
                                    .setTitle("Login failed")
                                    .setMessage("Login failed")
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                        }
                                    });

        //TODO link keyboard done to connection button

        // Change color and hide progressBar
        progressBar = findViewById(R.id.progressBar);
 //       progressBar.getIndeterminateDrawable().setColorFilter((int)R.color.colorPrimary,
  //              android.graphics.PorterDuff.Mode.MULTIPLY);
        progressBar.setVisibility(View.GONE);
    }

    public void login(View view)
    {
        //set progress circle visible till connection is successful or fails
        findViewById(R.id.progressBar).setVisibility(View.VISIBLE);

        try {
            if (checkUserPassword()) {
                // Start Activity
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);

                //Close the login activity because it's not needed anymore
                finish();
            } else {
                // PopUp to display the error
                loginErrorDialog.setMessage("Wrong username and password")
                        .show();

                // Hide progress bar, not needed if check was successful since activity would have been killed
                findViewById(R.id.progressBar).setVisibility(View.GONE);
            }
        } catch (Exception e) {
            loginErrorDialog.setMessage("Error accessing the database")
                    .show();
        }
    }

    public void newUser(View view)
    {
        Intent intent = new Intent(this, NewUserActivity.class);
        startActivity(intent);
    }

    private boolean checkUserPassword() {
        return true;
        //TODO Hash password and check in DB if good, remove dummy check
        //return !isEditTextEmpty(findViewById(R.id.editTextUserNameLogin)) &&
        //        !isEditTextEmpty(findViewById(R.id.editTextPasswordLogin));
    }

    private boolean isEditTextEmpty(View view) {
        return ((EditText)view).getText().toString().isEmpty();
    }

    public void forgottenPassword(View view)
    {
        Intent intent = new Intent(this, ForgottenPasseword.class);
        startActivity(intent);
    }

}
