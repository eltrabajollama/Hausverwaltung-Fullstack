import javax.swing.*;

public class mainGui {
    private static void inputGUI() {
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

    public static void mains(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                inputGUI();
            }
        });
    }
}
