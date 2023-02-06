package dev.bsinfo.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class mainGui implements  ActionListener   {


    public static void inputGUI() {
        String[] labels = {"Kundennummer: ", "Zählerart: ", "Zählernummer: ", "Datum: ", "neu eingebaut: ", "Zählerstand: ", "Kommentar: "};
        int numPairs = labels.length;


        JPanel p = new JPanel(new SpringLayout());
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            p.add(l);
            JTextField textField = new JTextField(10);
            l.setLabelFor(textField);
            p.add(textField);
        }
        JPanel buttonPanel = new JPanel();
        JButton button = new JButton("submit");
        buttonPanel.add(button);
        p.add(buttonPanel);




        inputUtilities.makeCompactGrid(p,
                numPairs, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad

        JFrame frame = new JFrame("Input Form");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p.setOpaque(true);
        frame.setContentPane(p);
        frame.setVisible(true);


    }
    public void actionPerformed(ActionEvent e) {

        System.out.println("Button pressed!");

    }

    public static void mains(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                mainGui.inputGUI();
            }
        });
    }
}
