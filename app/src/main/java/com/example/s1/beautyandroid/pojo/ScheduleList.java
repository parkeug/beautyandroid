package com.example.s1.beautyandroid.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by s1 on 1/22/2017.
 */

public class ScheduleList {
    @SerializedName("schedules")
    @Expose
    private ArrayList<Schedule> schedules = new ArrayList<>();

    /**
     * @return The schedules
     */
    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    /**
     * @param schedules The schedules
     */
    public void setSchedules(ArrayList<Schedule> schedules) {
        this.schedules = schedules;
    }
}
