package com.pikle6.api.resource;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.pikle6.api.core.ImageExtractor;
import com.pikle6.api.core.ImagePair;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by pikle6 on 7/10/2015.
 * handle second case
 */
@Path("/image/{next}")
@Produces(MediaType.APPLICATION_JSON)
public class Img2 {

    public Img2() {
    }

    @GET
    @Timed
    public ImagePair getImages(@PathParam("next") String next) {
        return ImageExtractor.getImages(next==null?"":next);
    }
}
