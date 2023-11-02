package src;

import java.awt.Font;
import java.util.logging.Logger;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

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

            frame.dispose();

            frame = new JFrame();
            JLabel label = new JLabel("SUBMITTED TO APPROVER");

            label.setBounds(10, 10, 400, 30);
            label.setFont(new Font(null, Font.PLAIN, 15));

            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(300, 100);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.add(label);

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
