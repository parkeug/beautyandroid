package com.example.s1.beautyandroid.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by s1 on 1/16/2017.
 */

public class StoreMembership {
    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("logo")
    @Expose
    private String logo;

    @SerializedName("lat")
    @Expose
    private String lat;

    @SerializedName("lon")
    @Expose
    private String lon;

    @SerializedName("hours")
    @Expose
    private String hours;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("address2")
    @Expose
    private String address2;

    @SerializedName("website")
    @Expose
    private String website;

    @SerializedName("customer_id")
    @Expose
    private long customer_id;

    @SerializedName("points")
    @Expose
    private int points;

    @SerializedName("stamps")
    @Expose
    private String stamps;

    @SerializedName("stampdesc")
    @Expose
    private String stampdesc;

    /**
     * @return The id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The name
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo The logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * @return The lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * @param lat The lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * @return The lon
     */
    public String getLon() {
        return lon;
    }

    /**
     * @param lon The lon
     */
    public void setLon(String lon) {
        this.lon = lon;
    }

    /**
     * @return The hours
     */
    public String getHours() {
        return hours;
    }

    /**
     * @param hours The hours
     */
    public void setHours(String hours) {
        this.hours = hours;
    }

    /**
     * @return The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return The address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return The address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * @param address2 The address2
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * @return The website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website The website
     */
    public void setWebsite(String website) {
        this.website = website;
    }


    /**
     * @return The customer_id
     */
    public long getCustomer_id() {
        return customer_id;
    }

    /**
     * @param customer_id The customer_id
     */
    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    /**
     * @return The points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param points The points
     */
    public void setPoints(int points) {
        this.points = points;
    }


    /**
     * @return The stamps
     */
    public String getStamps() {
        return stamps;
    }

    /**
     * @param stamps The stamps
     */
    public void setStamps(String stamps) {
        this.stamps = stamps;
    }

    /**
     * @return The stampdesc
     */
    public String getStampdesc() {
        return stampdesc;
    }

    /**
     * @param stampdesc The stampdesc
     */
    public void setStampdesc(String stampdesc) {
        this.stampdesc = stampdesc;
    }

}