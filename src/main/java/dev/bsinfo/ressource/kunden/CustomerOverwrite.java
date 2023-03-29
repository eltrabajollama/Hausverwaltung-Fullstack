package dev.bsinfo.ressource.kunden;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.ws.rs.*;

import java.sql.*;

@Path("test/kunden")
@Produces("text/plain")
@Consumes("application/json")
public class CustomerOverwrite {
    @PUT
    public ObjectNode overwriteCustomer(@PathParam("id") int id) {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode response = mapper.createObjectNode();

        String url = "jdbc:mysql://localhost:3306/Hausverwaltung?autoReconnect=true&useSSL=false";
        String user = "root";
        String password = "root";
        String QUERY = "SELECT * FROM Hausverwaltungdata where id =" + id;

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

        return response;
    }
}


