package dev.bsinfo.gui;
import java.awt.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CsvToTable {
    private JFrame frame;
    private JTable table;
    private JScrollPane scrollPane;

    public CsvToTable() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        table = new JTable();
        scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
    }

    public void showTable(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            List<String[]> rows = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                rows.add(row);
            }
            String[] columnNames = rows.get(0);
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            for (int i = 1; i < rows.size(); i++) {
                String[] row = rows.get(i);
                model.addRow(row);
            }
            table.setModel(model);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CsvToTable csvToTable = new CsvToTable();
        csvToTable.showTable("testdata.csv");
        csvToTable.frame.setVisible(true);
    }
}

