package com.example.s1.beautyandroid.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by s1 on 1/16/2017.
 */

public class MediaList {

    @SerializedName("medias")
    @Expose
    private ArrayList<Media> medias = new ArrayList<>();

    /**
     * @return The medias
     */
    public ArrayList<Media> getMedias() {
        return medias;
    }

    /**
     * @param medias The medias
     */
    public void setMedias(ArrayList<Media> medias) {
        this.medias = medias;
    }
}