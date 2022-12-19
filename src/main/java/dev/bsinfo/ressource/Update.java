package dev.bsinfo.ressource;


import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("test")
public class Update {
    @Path("/update/{entry_id}")
    @DELETE
    public static void updateCSV(@PathParam("entry_id") int propertyId) {

    }
}
