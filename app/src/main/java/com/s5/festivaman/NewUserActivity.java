package com.s5.festivaman;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.s5.festivaman.Socket.DatabaseQueries;

public class NewUserActivity extends AppCompatActivity {

    String password;
    String confirmation;
    String email;
    String username;

    private AlertDialog.Builder newUserErrorDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        // Prebuild dialog to display possible future error
        newUserErrorDialog = new AlertDialog.Builder(this)
                .setTitle("User Creation failed")
                .setMessage("User Creation failed")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
    }

    public void newUser(View view)
    {
        if (isUserInfoValid() && createNewUser()) {

            Intent intent = new Intent(this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    }

    private boolean createNewUser() {
        boolean successful = new DatabaseQueries().createNewUser(username,password,email);
        if (!successful) {
            newUserErrorDialog.setMessage("Creation failed")
                    .show();
        }
        return successful;
    }

    private boolean isUserInfoValid() {

        return (!isAnyFieldEmpty() && isUsernameAvailable() && isPasswordSame() && isEmailFormatValid());

    }

    private boolean isAnyFieldEmpty() {
        password = ((EditText)findViewById(R.id.editTextPasswordNewUser)).getText().toString();
        confirmation = ((EditText)findViewById(R.id.editTextPasswordConfirmation)).getText().toString();
        email = ((EditText)findViewById(R.id.editTextEmailNewUser)).getText().toString();
        username = ((EditText)findViewById(R.id.editTextNewUser)).getText().toString();

        if (password.isEmpty() || confirmation.isEmpty() || email.isEmpty() || username.isEmpty()) {

            newUserErrorDialog.setMessage("Please fill all fields")
                    .show();
            return true;
        }
        return false;
    }

    private boolean isPasswordSame() {

        if (password.isEmpty() || confirmation.isEmpty() || !password.equals(confirmation)) {

            newUserErrorDialog.setMessage("Password and confirmation must be the same")
                    .show();
            return false;
        }
        return true;
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
        if (!new DatabaseQueries().isUserNameAvailable(username)) {
            newUserErrorDialog.setMessage("Username not available")
                    .show();
            return false;
        }
        return true;
    }
}
