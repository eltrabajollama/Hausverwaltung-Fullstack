package dev.bsinfo.ressource.ablesungen;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

// get list of all dates before a specific date
@Path("test/ablesungen")
@Produces("application/json")
public class AblesungenGetOld {
    @GET
    public String ablesungenGetOld() {
        return "get old";
    }
}


