package com.pikle6.api;

import com.pikle6.api.config.ApiConfiguration;
import com.pikle6.api.resource.Cmnt;
import com.pikle6.api.resource.Doc;
import com.pikle6.api.resource.Img;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * the main class as of now
 * once dropwizarded should be fine
 */
public class App extends Application<ApiConfiguration>
{
    public static void main( String[] args ) throws Exception {
        new App().run(args);
    }

    @Override
    public void initialize(Bootstrap<ApiConfiguration> bootstrap) {
    }

    @Override
    public void run(ApiConfiguration configuration, Environment environment) {
        environment.jersey().register(new Doc());
        environment.jersey().register(new Img());
        environment.jersey().register(new Cmnt());
    }
}