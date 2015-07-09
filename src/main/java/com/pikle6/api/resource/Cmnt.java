package com.pikle6.api.resource;

import com.codahale.metrics.annotation.Timed;
import com.pikle6.api.core.Comment;
import com.pikle6.api.core.CommentExtractor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by pikle6 on 7/10/2015.
 * API call to get all comment data
 */
@Path("/comment/{id}")
@Produces(MediaType.APPLICATION_JSON)
public class Cmnt {

    public Cmnt() {
    }

    @GET
    @Timed
    public List<Comment> getComments(@PathParam("id") String id) {
        return CommentExtractor.getComments(id==null?"aXXweob":id);
    }
}