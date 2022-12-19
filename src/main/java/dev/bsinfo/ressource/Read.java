package dev.bsinfo.ressource;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("test")
public class Read {
    @Path("/read")
    @GET
    public static void getCSV() throws IOException {
        File inputFile = new File("Hausverwaltung.csv");
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        String line;
        ArrayList allEnteries = new ArrayList<>();
        while((line = reader.readLine()) != null){
            List<String> result = Arrays.asList(line.split("\\s*,\\s*"));
            allEnteries.add(line);
            System.out.print(allEnteries);
        }
    }
}
