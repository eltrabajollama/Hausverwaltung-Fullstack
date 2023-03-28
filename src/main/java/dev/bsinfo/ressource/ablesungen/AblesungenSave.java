package dev.bsinfo.ressource.ablesungen;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Path("test/ablesungen")
@Produces("application/json")
@Consumes("application/json")
public class AblesungenSave {
    @POST
    public void saveAblesungen() {
    }
}


