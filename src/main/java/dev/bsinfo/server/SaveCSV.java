package dev.bsinfo.server;
import java.io.FileWriter;
import java.io.IOException;

public class SaveCSV {
    public static void main(String[] args) {
        try {
            FileWriter myWriter = new FileWriter("Hausverwaltung.csv");
            myWriter.write("Kundennummer, Datum, Zählerart, Zählernummer, Zählerstand,");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}