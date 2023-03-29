package dev.bsinfo.server;


import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class mainGui extends JFrame implements ActionListener {

    JLabel Kundennummerl;
    JLabel Zählerartl;
    JLabel Zählernummerl;
    JLabel Zählerstandl;
    JLabel Kommentarl;

    JButton button;

    JButton buttonDelete;
    JTextField Kundennummer;
    JTextField Zählerart;
    JTextField Zählernummer;
    JFormattedTextField Datum;
    JCheckBox neu_eingebaut;
    JTextField Zählerstand;
    JTextField Kommentar;

    mainGui() throws IOException {
        System.out.println(getHausverwaltungList());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());

        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        button = new JButton("submit");
        button.addActionListener(this);
        Kundennummerl = new JLabel("Kundennummer");
        Kundennummer = new JTextField();
        Kundennummer.setPreferredSize(new Dimension(250, 40));
        Zählerartl = new JLabel("Zählerart");
        Zählerart = new JTextField();
        Zählerart.setPreferredSize(new Dimension(250, 40));
        Zählernummerl = new JLabel("Zählernummer");
        Zählernummer = new JTextField();
        Zählernummer.setPreferredSize(new Dimension(250, 40));
        Datum = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));
        Datum.setValue(new Date());
        Datum.setPreferredSize(new Dimension(250, 40));
        neu_eingebaut = new JCheckBox("neu eingebaut");
        neu_eingebaut.setPreferredSize(new Dimension(250, 40));
        Zählerstandl = new JLabel("Zählerstand");
        Zählerstand = new JTextField();
        Zählerstand.setPreferredSize(new Dimension(250, 40));
        Kommentarl = new JLabel("Kommentar");
        Kommentar = new JTextField();
        Kommentar.setPreferredSize(new Dimension(250, 40));

        p1.add(button);
        p1.add(Kundennummerl);
        p1.add(Kundennummer);
        p1.add(Zählerartl);
        p1.add(Zählerart);
        p1.add(Zählernummerl);
        p1.add(Zählernummer);
        p1.add(Datum);
        p1.add(neu_eingebaut);
        p1.add(Zählerstandl);
        p1.add(Zählerstand);
        p1.add(Kommentarl);
        p1.add(Kommentar);
        //add the table to the frame

        JLabel deleteLabel = new JLabel("Bitte wählen Sie eine ID zum Löschen");
        JButton deleteButton = new JButton("Löschen");

        JLabel editLable = new JLabel("Bitte wählen Sie eine ID zum Bearbeiten");
        JButton editButton = new JButton("Edit");

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hausverwaltung", "root", "root");

            // Execute a SELECT statement to retrieve data from the database
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id FROM Hausverwaltungdata");

            ArrayList choices = new ArrayList<>();
            while (rs.next()) {
                choices.add(rs.getInt("id"));
            }
            final JComboBox cb = new JComboBox(choices.toArray());

            final JComboBox editList = new JComboBox(choices.toArray());
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        URL url = new URL("http://localhost:8080/rest/delete/kunden/" + cb.getSelectedItem().toString());
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setRequestMethod("DELETE");

                        int responseCode = con.getResponseCode();
                        System.out.println("Response code: " + responseCode);

                    } catch (Exception error) {
                        error.printStackTrace();
                    }
                }
            });

            p2.add(editLable);
            p2.add(editList);
            p2.add(editButton);

            p3.add(deleteLabel);
            p3.add(cb);
            p3.add(deleteButton);
            cb.setVisible(true);
            deleteLabel.setVisible(true);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Create the tab container
        JTabbedPane tabs = new JTabbedPane();
        //Set tab container position
        tabs.setBounds(40, 20, 300, 300);
        //Associate each panel with the corresponding tab
        tabs.add("Submit Form", p1);
        tabs.add("List", p2);
        tabs.add("Delete", p3);

        this.add(tabs);
        this.setSize(2000, 2000);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent log) {
        if (log.getSource() == button) {
            String KundennummerValue = Kundennummer.getText();
            String ZähleartValue = Zählerart.getText();
            String ZählernummerValue = Zählernummer.getText();
            String DatumValue = Datum.getText();
            String neu_eingebautValue = String.valueOf(neu_eingebaut.isSelected());
            String modifiedNeu_eingebautValue = checkCheckbox(neu_eingebautValue, neu_eingebautValue);
            String ZählerstandValue = Zählerstand.getText();
            String KommentarValue = Kommentar.getText();

            try {
                URL url = new URL("http://localhost:8080/rest/save/kunden");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("kundennummer", KundennummerValue);
                jsonObject.put("Zähleart", ZähleartValue);
                jsonObject.put("Zählernummer", ZählernummerValue);
                jsonObject.put("Datum", DatumValue);
                jsonObject.put("Neu_eingebaut", modifiedNeu_eingebautValue);
                jsonObject.put("Zählerstand", ZählerstandValue);
                jsonObject.put("Kommentar", KommentarValue);
                String jsonBody = jsonObject.toString();

                OutputStream os = conn.getOutputStream();
                os.write(jsonBody.getBytes());
                os.flush();

                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));

                String output;
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                }

                conn.disconnect();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String checkCheckbox(String valuetoChange, String checkbox) {

        if (Objects.equals(checkbox, "true")) {
            valuetoChange = "1";
        } else {
            valuetoChange = "0";
        }

        return valuetoChange;
    }

    public String getHausverwaltungList() throws IOException {
        try {
            URL url = new URL("http://localhost:8080/rest/list/kunden"); // Replace with your API URL
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // create a BufferedReader to read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            // read the response into a StringBuilder
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(response);
                response.append(line);
            }
            in.close();

            // parse the response into a JSONObject
            JSONObject jsonObject = new JSONObject(response.toString());

            // access individual properties of the object using their keys
            String name = jsonObject.getString("data");

            return "not working";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
