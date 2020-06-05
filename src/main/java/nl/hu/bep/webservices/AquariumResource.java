package nl.hu.bep.webservices;

import nl.hu.bep.model.Aquarium;
import nl.hu.bep.model.Eigenaar;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/aquarium")
public class AquariumResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAquariums() {
        return Json.createObjectBuilder().add("error", "this request was not intended").build().toString();
    }

    @DELETE
    @RolesAllowed("eigenaar")
    @Path("{aquariumid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAquarium(@PathParam("aquariumid") int id){
        if (Aquarium.removeAquarium(id)) return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();

    }

}
