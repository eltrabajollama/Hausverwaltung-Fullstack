package dev.bsinfo.ressource;

import com.opencsv.CSVWriter;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


@Path("test")
public class postTestData {

    public static void writeCSV(String[] dataArray) {
        // first create file object for file placed at location
        // specified by filepath
        File file = new File("Hausverwaltung.csv");
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            writer.writeNext(dataArray);
            System.out.println("added data");


            // closing writer connection
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @POST
    @Path("/{param}")
    public Response postMsg(@PathParam("param") String msg) {
        String output = "POST:Jersey say : " + msg;
        return Response.status(200).entity(output).build();
    }
}
