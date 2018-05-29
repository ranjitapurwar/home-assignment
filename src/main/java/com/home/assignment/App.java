package com.home.assignment;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;

/**
 * Created by ranjitapurwar on 5/13/18.
 */
@ApplicationPath("api")
public class App extends ResourceConfig{

    public App() {
        // Register resources and providers using package-scanning.
        packages("com.home.assignment");

    }

}
