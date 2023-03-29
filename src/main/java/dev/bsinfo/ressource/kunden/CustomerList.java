package dev.bsinfo.ressource.kunden;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("list/kunden")
@Produces("application/json")
public class CustomerList {
    @GET
    public String listCustomer() throws JsonProcessingException {
        Map<String, Object> response = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(response);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hausverwaltung", "root", "root");

            // Execute a SELECT statement to retrieve data from the database
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Hausverwaltungdata");

            List<String> dataArray = new ArrayList<>();

            String processedData = null;
            while (rs.next()) {
                processedData = String.valueOf(processData(rs));
                dataArray.add(processedData);

            }
            response.put("data", dataArray);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return response.toString();
    }

    private ArrayList processData(ResultSet rs) throws SQLException {
        List procesData = new ArrayList<>();
        procesData.add(rs.getInt("Kundennummer"));
        procesData.add(rs.getString("Zählerart"));
        procesData.add(rs.getString("Zählernummer"));
        procesData.add(rs.getString("Datum"));
        procesData.add(rs.getInt("neu_eingebaut"));
        procesData.add(rs.getString("zählerstand"));
        procesData.add(rs.getString("kommentar"));
        return (ArrayList) procesData;
    }
}


