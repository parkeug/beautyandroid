package com.example.s1.beautyandroid.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by s1 on 1/18/2017.
 */

public class StoreMembershipList {

    @SerializedName("storememberships")
    @Expose
    private ArrayList<StoreMembership> storememberships = new ArrayList<>();

    /**
     * @return The storememberships
     */
    public ArrayList<StoreMembership> getStoreMemberships() {
        return storememberships;
    }

    /**
     * @param storememberships The storememberships
     */
    public void setStoreMemberships(ArrayList<StoreMembership> storememberships) {
        this.storememberships = storememberships;
    }
}
