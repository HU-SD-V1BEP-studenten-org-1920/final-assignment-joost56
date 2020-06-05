package nl.hu.bep.webservices;

import nl.hu.bep.model.Aquarium;
import nl.hu.bep.model.Eigenaar;

import javax.annotation.security.RolesAllowed;
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
    public List<Aquarium> getAquaria() {
        return Aquarium.getAlleAquaria();
    }


    @POST
    @Path("nojackson")
    @Produces(MediaType.APPLICATION_JSON)
    public String createAquariumOld(@FormParam("name") String nm, @FormParam("lengte") double len, @FormParam("breedte") double bre, @FormParam("hoogte") double hoo, @FormParam("bodemsoort") String bod, @FormParam("watersoort") String wat) {
        Aquarium newAquarium = Aquarium.createAquarium(nm, len, bre, hoo, bod, wat);
        JsonObjectBuilder job = Json.createObjectBuilder();
        if (newAquarium != null) {
            job.add("name", newAquarium.getNaam());
            job.add("lengte", newAquarium.getLengte());
            job.add("breedte", newAquarium.getBreedte());
            job.add("hoogte", newAquarium.getHoogte());
            job.add("bodemsoort", newAquarium.getBodemsoort());
            job.add("watersoort", newAquarium.getWatersoort());
        } else {
            job.add("error", "aquarium is niet gemaakt");
        }
        return job.build().toString();
    }

    @POST
    @Path("jackson")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAquarium(@FormParam("name") String nm, @FormParam("lengte") double len, @FormParam("breedte") double bre, @FormParam("hoogte") double hoo, @FormParam("bodemsoort") String bod, @FormParam("watersoort") String wat) {
        Aquarium newAquarium = Aquarium.createAquarium(nm, len, bre, hoo, bod, wat);
        if (newAquarium == null) {
            return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("result", "Aquarium bestaat al")).build();
        }
        return Response.ok(newAquarium).build();
    }
}
