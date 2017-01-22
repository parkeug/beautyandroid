package com.example.s1.beautyandroid.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by s1 on 1/22/2017.
 */

public class Employee {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("displayname")
    @Expose
    private String displayname;

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

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
     * @return The displayname
     */
    public String getDisplayname() {
        return displayname;
    }

    /**
     * @param displayname The displayname
     */
    public void setDisplayname(String displayname) {
        this.displayname = displayname;
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
}
