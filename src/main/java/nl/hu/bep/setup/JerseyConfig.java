package nl.hu.bep.setup;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
    packages("nl.hu.bep.webservices, nl.hu.bep.security");
    register(RolesAllowedDynamicFeature.class);

        //@TODO koppel hier met je web-resource packages
    }
}