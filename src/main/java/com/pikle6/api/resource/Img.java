package com.pikle6.api.resource;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.pikle6.api.core.ImageExtractor;
import com.pikle6.api.core.ImagePair;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by pikle6 on 7/10/2015.
 * API call to get all image data
 */

@Path("/image")
@Produces(MediaType.APPLICATION_JSON)
public class Img {

    public Img() {
    }

    @GET
    @Timed
    public ImagePair getImages() {
        return ImageExtractor.getImages("");
    }
}
