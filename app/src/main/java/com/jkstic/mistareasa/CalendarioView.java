package com.jkstic.mistareasa;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarioView extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_view);

        List<EventDay> events = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        events.add(new EventDay(calendar, R.drawable.sample_four_icons));

        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setEvents(events);


        calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(EventDay eventDay) {
                Calendar clickedDayCalendar = eventDay.getCalendar();
                Context context = getApplicationContext();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                Toast toast = Toast.makeText(context, sdf.format(clickedDayCalendar.getTime()), Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
//https://github.com/Applandeo/Material-Calendar-View