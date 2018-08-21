package com.test.hein.seatscreen;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class CalenderviewDialog  extends DialogFragment{


//    public CalenderviewDialog(@NonNull Context context) {
//        super(context);
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.my_calendar_view);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getDialog().getWindow() != null)
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View rootView = inflater.inflate(R.layout.my_calendar_view, container, false);
////        et_customer_name = rootView.findViewById(R.id.et_customer_name);
////        et_customer_age = rootView.findViewById(R.id.et_customer_age);
////        et_customer_nrcno = rootView.findViewById(R.id.et_customer_nrcno);
////        et_customer_address = rootView.findViewById(R.id.et_customer_address);
////        et_customer_phone = rootView.findViewById(R.id.et_customer_phone);
////        et_customer_email = rootView.findViewById(R.id.et_customer_email);
//        btn_ok = rootView.findViewById(R.id.btnOk);
//        btn_cancel = rootView.findViewById(R.id.btnCancel);
//
//
//
//        btn_cancel.setOnClickListener(v -> dismiss());
        CalendarView simpleCalendarView = (CalendarView) rootView.findViewById(R.id.simpleCalendarView); // get the reference of CalendarView
        simpleCalendarView.setFocusedMonthDateColor(Color.RED); // set the red color for the dates of  focused month
        simpleCalendarView.setUnfocusedMonthDateColor(Color.BLUE); // set the yellow color for the dates of an unfocused month
        simpleCalendarView.setWeekSeparatorLineColor(Color.GREEN); // green color for the week separator line

        // perform setOnDateChangeListener event on CalendarView
        simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // display the selected date by using a toast
                Toast.makeText(getContext(), dayOfMonth + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
            }
        });


        return rootView;
    }
}
