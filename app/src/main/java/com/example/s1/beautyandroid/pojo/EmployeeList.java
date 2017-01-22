package com.example.s1.beautyandroid.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by s1 on 1/22/2017.
 */

public class EmployeeList {
    @SerializedName("employees")
    @Expose
    private ArrayList<Employee> employees = new ArrayList<>();

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
}
