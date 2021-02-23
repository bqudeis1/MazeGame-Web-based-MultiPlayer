package com.example.WNA_MazeGame_Online;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class HelloApplication extends Application {

    @POST
    @Produces("text/json")
    public String hello() {
        return "Hello, World!";
    }

    @GET
    @Produces("text/json")
    public String helloo() {
        return "Hello, World!";
    }



}
