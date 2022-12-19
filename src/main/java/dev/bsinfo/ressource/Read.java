package dev.bsinfo.ressource;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("test")
public class Read {
    @Path("/read")
    @GET
    public static List<String> getCSV() throws IOException {
        File inputFile = new File("Hausverwaltung.csv");
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        String line;
        reader.readLine();
        List<String> result = new ArrayList<>();
        while((line = reader.readLine()) != null){
            result = Arrays.asList(line.split("\\s*,\\s*"));
            System.out.print(result);
        }
        return result;
    }
}
