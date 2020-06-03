package nl.hu.bep.setup;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {packages("nl.hu.bep.webservices");
        //@TODO koppel hier met je web-resource packages
    }
}