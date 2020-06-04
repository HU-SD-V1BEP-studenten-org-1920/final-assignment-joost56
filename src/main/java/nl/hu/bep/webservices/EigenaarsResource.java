package nl.hu.bep.webservices;

import com.azure.core.annotation.Post;
import nl.hu.bep.model.Eigenaar;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.AbstractMap;
import java.util.List;

@Path("/eigenaren")
public class EigenaarsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Eigenaar> getEigenaars(){
        return Eigenaar.getAlleEigenaren();
    }

    @POST
    @Path("nojackson")
    @Produces(MediaType.APPLICATION_JSON)
    public String createEigenaarOld(@FormParam("name") String nm){
        Eigenaar newEigenaar  = Eigenaar.createEigenaar(nm);
        JsonObjectBuilder job = Json.createObjectBuilder();
        if (newEigenaar != null) {
            job.add("id", newEigenaar.getId());
            job.add("name", newEigenaar.getname());
        }else{
            job.add("error", "klant is niet gemaakt");
        }
        return job.build().toString();
    }

    @POST
    @Path("jackson")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEigenaar(@FormParam("name") String nm){
        Eigenaar newEigenaar = Eigenaar.createEigenaar(nm);
        if (newEigenaar == null){
            return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("result", "Eigenaar bestaat al")).build();
        }
        return Response.ok(newEigenaar).build();
    }
    }

