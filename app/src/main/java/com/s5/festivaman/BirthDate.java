package com.s5.festivaman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.s5.festivaman.Socket.DatabaseQueries;

public class BirthDate extends AppCompatActivity {
  CalendarView calendarView;
  TextView myDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birth_date);

        calendarView = findViewById(R.id.calendarView);
        myDate = findViewById(R.id.myDate);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String date = year + "/" + (month+1) + "/" + dayOfMonth;
                myDate.setText(date);
            }
        });
    }

    public boolean send_birthdate() {
        String data = ((EditText)findViewById(R.id.modification)).getText().toString();
        return new DatabaseQueries().modifAccount("birthday",data);
    }
}
