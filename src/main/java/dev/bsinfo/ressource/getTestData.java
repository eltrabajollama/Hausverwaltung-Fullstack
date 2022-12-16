package dev.bsinfo.ressource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.json.JSONObject;


@Path("test")
public class getTestData {
	//JSONObject obj = new JSONObject(  );
	//JSONObject jsonWh = obj.getJSONObject("json");

	@Path("data")
	@GET
	public String getHelloWorld() {
		return "Daten";
	}
}