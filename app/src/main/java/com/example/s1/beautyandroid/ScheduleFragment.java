package com.example.s1.beautyandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarListener;

/**
 * Created by s1 on 1/19/2017.
 */

public class ScheduleFragment extends Fragment {

    public ScheduleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

    @Override
    public void onResume() {
        Log.e("DEBUG", "onResume of LoginFragment");

        /** end after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        /** start before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(getView(), R.id.calendarView)
                .startDate(startDate.getTime())
                .endDate(endDate.getTime())
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Date date, int position) {
                //do something
                Toast.makeText(getActivity().getApplicationContext(), "Your message", Toast.LENGTH_LONG).show();
            }
        });

        Bundle bundle = getArguments();
        long storemembershipid = bundle.getLong("storemembershipid") ;
        Toast.makeText(getActivity().getApplicationContext(), "Your message " + storemembershipid, Toast.LENGTH_LONG).show();


        super.onResume();
    }
}
