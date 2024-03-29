package dev.bsinfo.server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.sql.*;

import com.opencsv.CSVWriter;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.sun.net.httpserver.HttpServer;

public class StartServer {

	public static void main(final String[] args) throws SQLException, IOException {
		final String pack = "dev.bsinfo.ressource";
		String url = "http://localhost:8080/rest";
		System.out.println("Start server");
		System.out.println(url);
		//final ResourceConfig rc = new ResourceConfig().packages(pack).register(AuthenticationFilter.class);
		final ResourceConfig rc = new ResourceConfig().packages(pack);
		final HttpServer server = JdkHttpServerFactory.createHttpServer(URI.create(url), rc);
		System.out.println("Ready for Requests....");
		new mainGui();


	}


	public static void writeCSV(String[] dataArray) {
		// first create file object for file placed at location
		// specified by filepath
		File file = new File("Hausverwaltung.csv");
		try {
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(file);

			// create CSVWriter object filewriter object as parameter
			CSVWriter writer = new CSVWriter(outputfile);

			// adding header to csv


			// add data to csv

			writer.writeNext(dataArray);
			System.out.println("added data");


			// closing writer connection
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void saveCSV(){
		try {

			File luka = new File("Hausverwaltung.csv");

			if (luka.exists()){
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
