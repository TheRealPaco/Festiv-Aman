package com.s5.festivaman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BulletSpan;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SpannableString string = new SpannableString("Text with\nBullet point");
        string.setSpan(new BulletSpan(), 10, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        setContentView(R.layout.activity_home);
    }

    public void onClickImage(View view) {
        Intent intent = new Intent( this, LoginActivity.class);
        startActivity(intent);
    }

    public void friendPage(View view) {
        Intent intent = new Intent( this, LoginActivity.class);
        startActivity(intent);
    }

    public void UserAccount(View view) {
        Intent intent = new Intent( this, AccountInfoActivity.class);
        startActivity(intent);
    }
}
