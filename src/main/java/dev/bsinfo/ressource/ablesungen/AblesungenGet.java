package dev.bsinfo.ressource.ablesungen;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("test/ablesungen/{id}")
@Produces("application/json")
public class AblesungenGet {
    @GET
    public String getAblesungen() {
        return "get one";
    }
}


