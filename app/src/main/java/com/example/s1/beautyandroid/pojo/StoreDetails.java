package com.example.s1.beautyandroid.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by s1 on 1/22/2017.
 */

public class StoreDetails {
    @SerializedName("employees")
    @Expose
    private ArrayList<Employee> employees = new ArrayList<>();

    @SerializedName("services")
    @Expose
    private ArrayList<Service> services = new ArrayList<>();

    /**
     * @return The employees
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * @param employees The employees
     */
    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    /**
     * @return The services
     */
    public ArrayList<Service> getServices() {
        return services;
    }

    /**
     * @param services The services
     */
    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }
}
