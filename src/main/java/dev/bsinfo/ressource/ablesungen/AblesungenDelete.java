package dev.bsinfo.ressource.ablesungen;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Path("test/ablesungen/{id}")
@Produces("application/json")
public class AblesungenDelete {
    @DELETE
    public void deleteAblesungen() {
    }
}


