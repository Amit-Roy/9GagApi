package com.pikle6.api.core;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pikle6 on 7/8/2015.
 * this class holds the image data
 */
public class Image {
    private String id;
    private String url;
    private String title;
    private String type;

    public Image(String id, String url, String title, String type) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @JsonProperty
    public String getId() {
        return id;
    }

    @JsonProperty
    public String getUrl() {
        return url;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public String getType() {
        return type;
    }
}
