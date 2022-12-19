package dev.bsinfo.ressource;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;


@Path("test")
public class Delete {

    @Path("/delete/{entry_id}")
    @DELETE
    public Object main(@PathParam("entry_id") int propertyId, String[] args) throws IOException {
        File inputFile = new File("Hausverwaltung.csv");
        File tempFile = new File("tempHausverwaltung.csv");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String line;
            try {
                String header = reader.readLine();
                writer.write(header + System.getProperty("line.separator"));
                while((line = reader.readLine()) != null){
                    List<String> result = Arrays.asList(line.split("\\s*,\\s*"));
                    int currentId = Integer.parseInt(result.get(4));
                    if(currentId == propertyId) {
                        continue;
                    }
                    writer.write(line + System.getProperty("line.separator"));
                }
                writer.close();
                reader.close();
                tempFile.renameTo(inputFile);
            } catch (Exception e){
                System.out.println(e);
            }
        return null;
    }

}

