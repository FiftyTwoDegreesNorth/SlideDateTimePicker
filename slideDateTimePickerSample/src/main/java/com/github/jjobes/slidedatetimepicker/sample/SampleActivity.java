package com.github.jjobes.slidedatetimepicker.sample;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.github.jjobes.slidedatetimepicker.SlideDateTimeListener;
import com.github.jjobes.slidedatetimepicker.SlideDateTimePicker;

/**
 * Sample test class for SlideDateTimePicker.
 *
 * @author jjobes
 *
 */
@SuppressLint("SimpleDateFormat")
public class SampleActivity extends FragmentActivity
{
    private SimpleDateFormat mFormatter = new SimpleDateFormat("MMMM dd yyyy hh:mm aa");
    private Button mButton;

    private SlideDateTimeListener listener = new SlideDateTimeListener() {

        @Override
        public void onDateTimeSet(Date date)
        {
            Toast.makeText(SampleActivity.this,
                    mFormatter.format(date), Toast.LENGTH_SHORT).show();
        }

        // Optional cancel listener
        @Override
        public void onDateTimeCancel()
        {
            Toast.makeText(SampleActivity.this,
                    "Canceled", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onDateTimeTurnedOff() {
            Toast.makeText(SampleActivity.this,
                    "Turned off", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sample);

        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.MINUTE, 10);
                Date startDate = cal.getTime();

                new SlideDateTimePicker.Builder(getSupportFragmentManager())
                    .setShowTimeFirst(true)
                    .setListener(listener)
                    .setInitialDate(new Date())
                    .setTurnOffText("Turn off")
                    .setTurnOffable(true)
                    .setMinDate(new Date())
                    .setInitialDate(startDate)
                    //.setMaxDate(maxDate)
                    //.setIs24HourTime(true)
                    //.setTheme(SlideDateTimePicker.HOLO_DARK)
                    //.setIndicatorColor(Color.parseColor("#990000"))
                    .build()
                    .show();
            }
        });
    }
}
