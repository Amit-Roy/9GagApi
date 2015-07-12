package com.pikle6.api.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by pikle6 on 7/8/2015.
 * this class holds the image data
 */
public class Image {
    private String id;
    private String url;
    private String title;
    private String type;
    private int width;
    private int height;

    public Image(String id, String url, String title, String type, int width, int height) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.type = type;
        this.width = width;
        this.height = height;
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

    @JsonProperty
    public int getWidth() {
        return width;
    }

    @JsonProperty
    public int getHeight() {
        return height;
    }

    @JsonProperty
    public void setWidth(int width) {
        this.width = width;
    }

    @JsonProperty
    public void setHeight(int height) {
        this.height = height;
    }
}
