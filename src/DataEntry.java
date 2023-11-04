import java.util.logging.Logger;
package src;

import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class DataEntry {
    static DataEntry d;
    static DHSaccount acc;

    Logger logger = Logger.getLogger(getClass().getName());

    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JTextField text1;
    private JTextField text2;
    private JPasswordField text3;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;

    public DataEntry() {
        frame = new JFrame("Data Entry BETA");

        panel = new JPanel();
        button = new JButton("Submit");
        text1 = new JTextField(20);
        text2 = new JTextField(20);
        text3 = new JPasswordField(20);
        label1 = new JLabel("Immigrant ID:");
        label2 = new JLabel("Immigrant Name:");
        label3 = new JLabel("DHS Password:");

        // Aligns These Elements to the Right side
        JPanel tranPanel1 = new JPanel();
        tranPanel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
        tranPanel1.add(label1);
        tranPanel1.add(text1);

        // Aligns These Elements to the Right Side
        // JPanel tranPanel2 = new JPanel();
        // tranPanel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        // tranPanel2.add(label2);
        // tranPanel2.add(text2);

        // Aligns These Elements to the Right Side
        JPanel tranPanel3 = new JPanel();
        tranPanel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        tranPanel3.add(label3);
        tranPanel3.add(text3);

        // Structures it so that they are on top of each other going down
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(tranPanel1);
        // panel.add(tranPanel2);
        panel.add(tranPanel3);
        panel.add(button);

        // Specific Button Interaction
        button.addActionListener(event -> {
            String inText = text2.getText(); // Grabs whats in Text Box
            logger.info("Submitted " + inText + " to Reviewer...");

            // Updates Status => if valid continue if not do nothing...
            if (!acc.sendImmigrantStatus(inText))
                return;

            // Kills current Window
            frame.dispose();

            frame = new JFrame();
            label1 = new JLabel("Log in successful");

            label1.setFont(new Font(null, Font.PLAIN, 15));

            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(300, 100);
            frame.setLayout(new FlowLayout(FlowLayout.CENTER)); // Makes Sure items are centered with no weird gaps
            frame.setVisible(true);
            frame.setResizable(false);
            frame.add(label1);
        });

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(450, 150);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER)); // Makes Sure items are centered with no weird gaps
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(panel);
    }


    private static void createWindow() {
        d = new DataEntry();
    }

    public static void main(String[] args) {
        acc = new DHSaccount("a", "z", 123123, null);
        createWindow();
    } 
}