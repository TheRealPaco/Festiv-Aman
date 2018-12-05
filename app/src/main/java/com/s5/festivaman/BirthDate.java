package com.s5.festivaman;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.s5.festivaman.Socket.DatabaseQueries;

public class BirthDate extends AppCompatActivity {
    private CalendarView calendarView;
    private TextView myDate;
    private AlertDialog.Builder ErrorDialog;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birth_date);

        calendarView = findViewById(R.id.calendarView);
        myDate = findViewById(R.id.myDate);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                date = year + "/" + (month+1) + "/" + dayOfMonth;
                myDate.setText(date);
            }
        });
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
                if (send_birthdate()) {
                    finish();
                } else {
                    ErrorDialog.show();

                }
            }
        });
    }

    public boolean send_birthdate() {

        return new DatabaseQueries().modifAccount("birthdate",date);
    }
}
