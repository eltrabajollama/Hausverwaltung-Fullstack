package dev.bsinfo.ressource.ablesungen;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;


// get specific cutomser with id and date
@Path("test/ablesungen/{date}/{id}")
@Produces("application/json")
public class AblesungenGetSpecificDate {
    @GET
    public int ablesungenGetSpecificDate() {
        return 1;
    }
}


