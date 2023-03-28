package dev.bsinfo.ressource.ablesungen;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Path("test/ablesungen")
@Produces("text/plain")
@Consumes("application/json")
public class AblesungenOverwrite {
    @PUT
    public void ablesungenOverwrite() {
    }
}


