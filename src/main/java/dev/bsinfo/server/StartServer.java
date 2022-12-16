package dev.bsinfo.server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.sun.net.httpserver.HttpServer;

public class StartServer {

	public static void main(final String[] args) {
		final String pack = "dev.bsinfo.ressource";
		String url = "http://localhost:8080/rest";
		System.out.println("Start server");
		System.out.println(url);
		//final ResourceConfig rc = new ResourceConfig().packages(pack).register(AuthenticationFilter.class);
		final ResourceConfig rc = new ResourceConfig().packages(pack);
		final HttpServer server = JdkHttpServerFactory.createHttpServer(URI.create(url), rc);
		System.out.println("Ready for Requests....");
		saveCSV();

	}

	public static void saveCSV(){
		try {

			File idea = new File("Hausverwaltung.csv");

			if (idea.exists()){
				//do nothing
			}
			else {
				FileWriter myWriter = new FileWriter("Hausverwaltung.csv");
				myWriter.write("Kundennummer, Datum, Zählerart, Zählernummer, Zählerstand,");
				myWriter.close();
				System.out.println("Successfully wrote to the file.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
