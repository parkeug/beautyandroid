package com.example.s1.beautyandroid.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by s1 on 1/22/2017.
 */

public class ServiceList {
    @SerializedName("services")
    @Expose
    private ArrayList<Service> services = new ArrayList<>();

    /**
     * @return The services
     */
    public ArrayList<Service> getServices() {
        return services;
    }

    /**
     * @param services The services
     */
    public void setEmployees(ArrayList<Service> services) {
        this.services = services;
    }
}
