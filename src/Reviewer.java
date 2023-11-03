package src;

import java.util.logging.Logger;

import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

// clear;javac -d . ./src/Reviewer.java; java src.Reviewer
public class Reviewer {
    static Reviewer r;
    static DHSaccount acc;

    Logger logger = Logger.getLogger(getClass().getName());

    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JTextField text1;
    private JTextField text2;
    private JLabel label1;
    private JLabel label2;

    public Reviewer() {
        frame = new JFrame("Reviewer BETA");

        panel = new JPanel();
        button = new JButton("Submit");
        text1 = new JTextField(20);
        text2 = new JTextField(20);
        label1 = new JLabel("Immigrant ID:");
        label2 = new JLabel("Immigrant Status:");

        // Aligns These Elements to the Right side
        JPanel tranPanel1 = new JPanel();
        tranPanel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
        tranPanel1.add(label1);
        tranPanel1.add(text1);

        // Aligns These Elements to the Right Side
        JPanel tranPanel2 = new JPanel();
        tranPanel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        tranPanel2.add(label2);
        tranPanel2.add(text2);

        // Structures it so that they are on top of each other going down
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(tranPanel1);
        panel.add(tranPanel2);
        panel.add(button);

        // Specific Button Interaction
        button.addActionListener(event -> {
            String inText = text2.getText(); // Grabs whats in Text Box
            logger.info("Submitted " + inText + " to Approver...");

            // Updates Status => if valid continue if not do nothing...
            if (!acc.sendImmigrantStatus(inText))
                return;

            // Kills current Window
            frame.dispose();

            frame = new JFrame();
            label1 = new JLabel("SUBMITTED TO APPROVER");

            label1.setBounds(10, 10, 400, 30);
            label1.setFont(new Font(null, Font.PLAIN, 15));

            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(300, 100);
            frame.setVisible(true);
            frame.setResizable(false);
            frame.add(label1);
        });

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER)); // Makes Sure items are centered with no weird gaps
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(panel);

    }

    private static void createWindow() {
        r = new Reviewer();
    }

    public static void main(String[] args) {
        acc = new DHSaccount("a", "z", 123123, null);
        createWindow();
    }
}
