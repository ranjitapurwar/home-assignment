package com.home.assignment.controller;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.home.assignment.service.CounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.MessageFormat;

/**
 * Created by ranjitapurwar on 5/13/18.
 */
@Controller
@Path("/increment")
public class CounterController {

    private static final Logger log = LoggerFactory.getLogger(CounterController.class);

    @Autowired
    CounterService counterService;

    @GET
    @Path("/{currentCount}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON})
    public Response incrementCounter(@PathParam("currentCount") long currentCount) {

        Response response;

        if (currentCount < 0) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        log.info(MessageFormat.format("Current count is {0}", currentCount));
        long nextCount = counterService.getNextCount(currentCount);
        response = Response.ok(nextCount).build();
        log.info(MessageFormat.format("Count was incremented to {0}", nextCount));

        return response;
    }

    public void setCounterService(CounterService counterService) {
        this.counterService = counterService;
    }

}
