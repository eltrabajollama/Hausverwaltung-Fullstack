package dev.bsinfo.ressource.kunden;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.ws.rs.*;

import java.sql.*;

@Path("delete/kunden/{id}")
@Produces("application/json")
public class CustomerDelete {
    @DELETE
    public String deleteCustomer(@PathParam("id") int id) throws JsonProcessingException {

        String url = "jdbc:mysql://localhost:3306/Hausverwaltung?autoReconnect=true&useSSL=false";
        String user = "root";
        String password = "root";
        String QUERY = "SELECT * FROM Hausverwaltungdata where id =" + id;

        // Open a connection
        try(Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "DELETE FROM Hausverwaltungdata " +
                    "WHERE id =" + id;
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode response = mapper.createObjectNode();

        response.put("id", id);

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);


    }
}


