package com.example.s1.beautyandroid.retrofit;

import com.example.s1.beautyandroid.pojo.MediaList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of ContactList
    */
    @GET("/Content/media.json")
    Call<MediaList> getMyJSON();
}
