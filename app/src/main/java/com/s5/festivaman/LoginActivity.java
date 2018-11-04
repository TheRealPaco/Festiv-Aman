package com.s5.festivaman;

import android.app.AlertDialog;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

public class LoginActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Change color and hide widget
        progressBar = findViewById(R.id.progressBar);
        progressBar.getIndeterminateDrawable().setColorFilter((int)R.color.colorPrimary,
                android.graphics.PorterDuff.Mode.MULTIPLY);
        progressBar.setVisibility(View.GONE);
    }

    public void login(View view)
    {
        //set progress circle visible till connection is successful or fails
        findViewById(R.id.progressBar).setVisibility(View.VISIBLE);

        if (checkUserPassword()) {
            // Start Activity
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);

            //Close the login activity because it's not needed anymore
            finish();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Login failed")
                    .setMessage("Wrong username and password")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    })
                    .show();

            // Hide progress bar, not needed if check was successful since activity would have been killed
            findViewById(R.id.progressBar).setVisibility(View.GONE);
        }
    }

    public void newUser(View view)
    {
        Intent intent = new Intent(this, NewUserActivity.class);
        startActivity(intent);
    }

    private boolean checkUserPassword() {
        //TODO Hash password and check in DB if good, remove dummy check
        return !isEditTextEmpty(findViewById(R.id.editTextUserName)) &&
                !isEditTextEmpty(findViewById(R.id.editTextPassword));
    }

    private boolean isEditTextEmpty(View view) {
        return ((EditText)view).getText().toString().isEmpty();
    }
}
