package com.pikle6.api.resource;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Modified by pikle6 on 7/26/2015.
 * documentation for the API
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
                "<li><b>107.170.184.51:9000</b> - Api Url</li><br>"+
                "<li><b>/</b> - Documentation : <a href=\"http://107.170.184.51:9000/\" target=\"_blank\">Usage</a></li><br><br>"+
                "<li><b>/image</b> - Get latest 10 images : <a href=\"http://107.170.184.51:9000/image\"  target=\"_blank\">Usage</a></li><br>"+
                "<li><b>/image/nextSetParam</b> - Get the next 10 Images. <b>nextSetParam</b> - identifier returned with each image query."+
                "<br>Just send it from the previous result : <a href=\"http://107.170.184.51:9000/image/am8zq2X,azVjwOm,aMQG7RX\"  target=\"_blank\">Usage</a></li><br><br>"+
                "<li><b>/image/category</b> - Get latest 10 images <b>from specified category</b>: <a href=\"http://107.170.184.51:9000/image/wtf\"  target=\"_blank\">Usage</a></li><br>"+
                "<li><b>/image/category/nextSetParam</b> - Get the next 10 Images<b>from specified category</b>. <b>nextSetParam</b> - identifier returned with each image query."+
                "<br>Just send it from the previous result : <a href=\"http://107.170.184.51:9000/image/wtf/aojNVxm,aVX302d,abbM2BB\"  target=\"_blank\">Usage</a><br>"+
                "Example of categories are : <b>hot, fresh, wtf, comic</b><br>"+
                "if an invalid category is entered you will get a <b>408 request timed out error</b> : <a href=\"http://107.170.184.51:9000/image/wzcvzxcvzxctf/aojNVxm,aVX302d,abbM2BB\"  target=\"_blank\">Usage</a></li><br><br>"+
                "<li><b>/comment/id</b> - Get Comments for image ID : <a href=\"http://107.170.184.51:9000/comment/aMQG7RX\"  target=\"_blank\">Usage</a></li></ul>";
        return usage;
    }
}
