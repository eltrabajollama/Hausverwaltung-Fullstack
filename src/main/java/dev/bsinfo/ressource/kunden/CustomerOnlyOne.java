package dev.bsinfo.ressource.kunden;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import java.sql.*;

@Path("list/only/kunden/{id}")
@Produces("application/json")
public class CustomerOnlyOne {
    @GET
    public String getOneCustomer(@PathParam("id") int id) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode response = mapper.createObjectNode();

        String url = "jdbc:mysql://localhost:3306/Hausverwaltung?autoReconnect=true&useSSL=false";
        String user = "root";
        String password = "root";
        String QUERY = "SELECT * FROM Hausverwaltungdata where id =" + id;

        // Open a connection
        try(Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "SELECT FROM Hausverwaltungdata " +
                    "WHERE id =" + id;
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            response.put("data", rs.next());
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);

    }
}


