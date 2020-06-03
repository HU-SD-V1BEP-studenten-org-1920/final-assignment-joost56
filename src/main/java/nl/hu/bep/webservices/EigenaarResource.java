package nl.hu.bep.webservices;

import nl.hu.bep.model.Eigenaar;

import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@Path("/eigenaar")
public class EigenaarResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getEigenaar(){
        return Json.createObjectBuilder().add("error", "this request was not intended").build().toString();
    }

    @GET
    @Path("{eigenaarid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEigenaar(@PathParam("eigenaarid") int id){
        Eigenaar eigenaar = Eigenaar.getEigenaarById(id);
        if (eigenaar == null){
            Map<String, String> messages = new HashMap<>();
            messages.put("error", "eigenaar bestaat niet");
            messages.put("requestId", Integer.toString(id));
            return Response.status(409).entity(messages).build();
        }
        return Response.ok(eigenaar).build();
    }

//    @PUT
//    @Path("/{eigenaarid}")
//    @Produces("application/json")
//    public Response updateCustomer(@PathParam("eigenaarid") int id, @FormParam("name") String name){
//        Eigenaar replaced = Eigenaar.updateEigenaar(new Eigenaar(id, name));
//
//    }
}
