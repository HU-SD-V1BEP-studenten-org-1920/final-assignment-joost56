package nl.hu.bep.webservices;

import nl.hu.bep.model.Aquarium;
import nl.hu.bep.model.Eigenaar;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.List;

@Path("/aquaria")
public class AquariaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Aquarium> getAquaria(){
        return Aquarium.getAlleAquaria();
    }

}
