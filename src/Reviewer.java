package src;

import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Reviewer {
    static Reviewer r;

    Logger logger = Logger.getLogger(getClass().getName());

    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JTextField text;

    public Reviewer() {
        frame = new JFrame();

        panel = new JPanel();
        button = new JButton("Submit");
        text = new JTextField(20);

        panel.setBounds(300, 350, 200, 200);
        panel.setFocusable(true);
        panel.add(text);
        panel.add(button);

        button.addActionListener(event -> {
            String inText = text.getText();
            logger.info("Submitted " + inText + " to Approver...");
        });

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(panel);
    }

    private static void createWindow() {
        r = new Reviewer();
    }

    public static void main(String[] args) {
        createWindow();
    }
}
