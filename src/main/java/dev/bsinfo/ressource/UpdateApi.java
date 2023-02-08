package dev.bsinfo.ressource;


import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

@Path("test")
public class UpdateApi {
    @Path("/update/{entry_id}")
    @PUT
    public static void updateCSV(@PathParam("entry_id") int propertyId, int lineNumber, List<String> newValues) {
                try (BufferedReader br = new BufferedReader(new FileReader("Hausverwaltung.csv"))) {
                    List<String> lines = new ArrayList<>();
                    String line;
                    while ((line = br.readLine()) != null) {
                        lines.add(line);
                    }
                    br.close();

                    StringBuilder updatedLine = new StringBuilder();
                    for (String value : newValues) {
                        updatedLine.append(value).append(",");
                    }
                    updatedLine.deleteCharAt(updatedLine.length() - 1);
                    lines.set(lineNumber, updatedLine.toString());

                    FileWriter writer = new FileWriter("Hausverwaltung.csv");
                    for (String updatedLine : lines) {
                        writer.write(updatedLine + System.lineSeparator());
                    }
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }
