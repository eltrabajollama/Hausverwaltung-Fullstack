package dev.bsinfo.ressource;


import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.io.*;
import java.util.*;

@Path("test")
public class CreateApi {
    int uniqueId = 0;
    @Path("/create")
    @POST
     public Object main() throws IOException {
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


