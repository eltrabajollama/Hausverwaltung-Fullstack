package dev.bsinfo.ressource.kunden;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.ws.rs.*;
import org.json.JSONObject;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("save/kunden")
@Produces("application/json")
@Consumes("application/json")
public class CustomerSave {
    @POST
    public String saveCustomer(String responseData) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        // Convert the JSON string to a JSON object
        JsonNode jsonNode = objectMapper.readTree(responseData);
        String kundennummerValue = String.valueOf(jsonNode.get("kundennummer"));
        String ZähleartValue = String.valueOf(jsonNode.get("Zähleart"));
        String ZählernummerValue = String.valueOf(jsonNode.get("Zählernummer"));
        String Neu_eingebautValue = String.valueOf(jsonNode.get("Neu_eingebaut"));
        String ZählerstandValue = String.valueOf(jsonNode.get("Zählerstand"));
        String KommentarValue = String.valueOf(jsonNode.get("Kommentar"));

        String url = "jdbc:mysql://localhost:3306/Hausverwaltung?autoReconnect=true&useSSL=false";
        String user = "root";
        String password = "root";

        try {
            // Connection to database
            Connection myConn = DriverManager.getConnection(url, user, password);

            //Creating the mysql statement
            Statement myStmt = myConn.createStatement();

            //Executing the mysql query
            String sql = "INSERT INTO Hausverwaltungdata (Kundennummer, Zählerart, Zählernummer, Datum, neu_eingebaut, zählerstand, kommentar)" + "Values(" + kundennummerValue + ", '" + ZähleartValue + "', '" + ZählernummerValue + "', DATE_FORMAT(CURDATE(), '%m/%d/%Y'), "+ Neu_eingebautValue +", '" + ZählerstandValue + "', '" + KommentarValue + "');";

            myStmt.execute(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ("Insert Complete.");
    }
}


