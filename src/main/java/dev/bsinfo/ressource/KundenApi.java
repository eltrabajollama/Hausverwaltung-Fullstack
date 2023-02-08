package dev.bsinfo.ressource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("test")
public class KundenApi {
    int uniqueId = 0;
    @Path("/kunden")
    @GET
     public Object main(@PathParam("kunden") Object KundenData) throws IOException {
        FileWriter fw = new FileWriter("Hausverwaltung.csv", true);
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            Map<String, Integer> map = new HashMap<>();
            map.put("Kundennummer", 45);
            map.put("Datum", 113);
            map.put("Zählerart ", 400);
            map.put("Zählernummer ", 400);
            map.put("Zählerstand ", getUniqueId());

            List<Integer> targetList = new ArrayList<>(map.values());

            targetList.toString().split(",");

            bw.write(targetList.toString());
            bw.newLine();
            bw.close();
            return "another day another slay";
        } catch (Exception e) {
            return "slay";
        }
    }

    int getUniqueId()
    {
        return uniqueId++;
    }
}


