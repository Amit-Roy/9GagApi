package com.pikle6.api.core;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by pikle6 on 7/10/2015.
 * to handle invalid json data
 */

public class InvalidException extends WebApplicationException {
    public InvalidException(String message) {
        super(Response.status(Response.Status.BAD_REQUEST)
                .entity(message).type(MediaType.TEXT_PLAIN).build());
    }
}