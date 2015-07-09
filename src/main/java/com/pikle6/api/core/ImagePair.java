package com.pikle6.api.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by pikle6 on 7/9/2015.
 * class created to multiplex the next param to be sent for more images
 */
public class ImagePair {
    private String nextSetParam;
    private List<Image> image;
    public ImagePair(List<Image> image)
    {
        this.image = image;
        this.nextSetParam = image.get(image.size() - 1).getId() + "," +
                image.get(image.size() - 2).getId() + "," +
                image.get(image.size() - 3).getId();
    }

    @JsonProperty
    public String getNextSetParam() {
        return nextSetParam;
    }

    @JsonProperty
    public List<Image> getImage() {
        return image;
    }
}
