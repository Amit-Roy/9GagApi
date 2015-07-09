package com.pikle6.api.resource;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by pikle6 on 7/10/2015.
 */
@Path("/")
@Produces(MediaType.TEXT_HTML)
public class Doc {

    public Doc() {
    }

    @GET
    @Timed
    public String getImages() {
        String usage = "<b>Documentation</b><br>"+
                "<ul>"+
                "<li><b>107.170.184.51:8080</b> - Api Url</li>"+
                "<li><b>/</b> - Documentation : <a href=\"107.170.184.51:8080/\" target=\"_blank\">Usage</a></li><br>"+
                "<li><b>/image</b> - Get latest 10 images : <a href=\"107.170.184.51:8080/images\"  target=\"_blank\">Usage</a></li><br>"+
                "<li><b>/image/nextSetParam</b> - Get the next 10 Images. <b>nextSetParam</b> - identifier returned with each image query."+
                "<br>Just send it from the previous result : <a href=\"107.170.184.51:8080/am8zq2X,azVjwOm,aMQG7RX\"  target=\"_blank\">Usage</a></li><br>"+
                "<li><b>/comment/id</b> - Get Comments for image ID : <a href=\"107.170.184.51:8080/comment/aMQG7RX\"  target=\"_blank\">Usage</a></li>";
        return usage;
    }
}
