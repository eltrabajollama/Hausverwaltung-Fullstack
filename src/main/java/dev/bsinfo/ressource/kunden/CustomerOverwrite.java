package dev.bsinfo.ressource.kunden;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("test/kunden")
@Produces("text/plain")
@Consumes("application/json")
public class CustomerOverwrite {
    @PUT
    public void overwriteCustomer() {
    }
}


