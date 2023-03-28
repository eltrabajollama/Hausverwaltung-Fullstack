package dev.bsinfo.ressource.kunden;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("test/kunden/{id}")
@Produces("application/json")
public class CustomerOnlyOne {
    @GET
    public String getOneCustomer() {
        return "only one";
    }
}


