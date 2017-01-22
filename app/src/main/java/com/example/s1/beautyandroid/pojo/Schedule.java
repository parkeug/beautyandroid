package com.example.s1.beautyandroid.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Time;
import java.util.Date;

/**
 * Created by s1 on 1/22/2017.
 */

public class Schedule {
    @SerializedName("scheduledate")
    @Expose
    private Date scheduledate;

    /**
     * @return The scheduledate
     */
    public Date getScheduledate() {
        return scheduledate;
    }

    /**
     * @param scheduledate The scheduledate
     */
    public void setScheduledate(Date scheduledate) {
        this.scheduledate = scheduledate;
    }
}
