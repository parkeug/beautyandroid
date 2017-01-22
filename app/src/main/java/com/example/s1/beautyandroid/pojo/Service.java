package com.example.s1.beautyandroid.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by s1 on 1/22/2017.
 */

public class Service {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("price")
    @Expose
    private int price;

    @SerializedName("duration")
    @Expose
    private int duration;


    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * @param thumbnail The thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price The price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return The duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration The duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

}
