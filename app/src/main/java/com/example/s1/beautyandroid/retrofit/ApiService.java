package com.example.s1.beautyandroid.retrofit;

import com.example.s1.beautyandroid.pojo.MediaList;
import com.example.s1.beautyandroid.pojo.Schedule;
import com.example.s1.beautyandroid.pojo.ScheduleList;
import com.example.s1.beautyandroid.pojo.StoreDetails;
import com.example.s1.beautyandroid.pojo.StoreMembership;
import com.example.s1.beautyandroid.pojo.StoreMembershipList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of ContactList
    */
    @GET("/Content/media.json")
    Call<MediaList> getMyJSON();

    @GET("/Content/storememberships.json")
    Call<StoreMembershipList> getStoreMembershipsJSON();

    @GET("/Content/storemembership.json")
    Call<StoreMembership> getStoreMembershipJSON(long id);

    @GET("/Content/schedule.json")
    Call<ScheduleList> getSchedulesJSON(long id);

    @GET("/Content/storedetails.json")
    Call<StoreDetails> getStoreDetailsJSON(long id);

    @POST("/Content/createschedule.json")
    Call<Schedule> createSchedule(@Body Schedule schedule);
}
