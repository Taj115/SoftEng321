package src;

import java.util.logging.Logger;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import javax.swing.JTextArea;

public class Approver {

    static Approver approver;
    static DHSaccount acc;

    Logger logger = Logger.getLogger(getClass().getName());

    //Private Variables
    private JFrame frame;
    private JPanel panel;
    private JButton acceptButton;
    private JButton denyButton;
    private JTextArea label;

    public Approver() {
        frame = new JFrame("Approver Window");

        panel = new JPanel();
        acceptButton = new JButton("ACCEPT");
        denyButton = new JButton("DENY");

        //Set Sizes of the two buttons
        acceptButton.setPreferredSize(new Dimension(100, 100));
        denyButton.setPreferredSize(new Dimension(100, 100));

        //Change the colors of the button for better clarity
        acceptButton.setBackground(Color.GREEN);
        denyButton.setBackground(Color.RED);

        // Structures it so that they are on top of each other going down
        panel.add(acceptButton);
        panel.add(denyButton);

        // Specific Button Interaction
        acceptButton.addActionListener(event -> {
            logger.info("Immigrant Status Change Accepted, notifying immigrant...");

            // Kills current Window
            frame.dispose();

            //New Frame for accept button
            frame = new JFrame();

            //Text with an appropriate size
            label = new JTextArea("IMMIGRANT STATUS APPROVED");
            label.setFont(new Font(null, Font.PLAIN, 20));
            label.setSize(300, 200);

            //If text is too long, wraps to the next line
            label.setWrapStyleWord(true);
            label.setLineWrap(true);
            label.setOpaque(false);
            
            //Sets the frame to the middle, not resizable, and a fixed size
            createFrame(frame, 400, 150);
            frame.add(label);
        });

        // Specific Button Interaction
        denyButton.addActionListener(event -> {
            logger.info("Immigrant Status Change Denied, sending back to Reviewer...");

            // Kills current Window
            frame.dispose();

            //Creates new frame for deny button
            frame = new JFrame();
            
            //Text with an appropriate size
            label = new JTextArea("SENT BACK TO REVIEWER FOR FURTHER REVIEW");
            label.setFont(new Font(null, Font.PLAIN, 20));
            label.setSize(300, 200);

            //If text is too long, wraps to the next line
            label.setWrapStyleWord(true);
            label.setLineWrap(true);
            label.setOpaque(false);
        
            //Sets the frame to the middle, not resizable, and a fixed size
            createFrame(frame, 400, 150);
            frame.add(label);
        });

        //Sets the size and puts the frame in the middle
        
        createFrame(frame, 350, 200);
        frame.add(panel);

    }

    private static void createWindow() {
        approver = new Approver();
    }

    private static void createFrame(JFrame frame, int width, int height)
    {
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }


    public static void main(String[] args) {
        acc = new DHSaccount("Tester123", "12379850326", 111, "ImmigrantGuy");
        createWindow();
    }
}
