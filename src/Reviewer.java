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
    Logger logger;

    DHSaccount acc;
    workflow table;

    private JFrame frame;
    private JPanel panel;
    private JButton button;

    public Reviewer(DHSaccount acc, workflow table, String version) {
        logger = Logger.getLogger(getClass().getName());

        this.acc = acc;
        this.table = table;

        frame = new JFrame(version);
        panel = new JPanel();
        button = new JButton("Submit");

        createWindow();
    }

    private JPanel componentAdd(int textCol, String labelTag, int flow, JButton button) {
        JPanel ret = new JPanel();
        JLabel label = new JLabel(labelTag + ":");
        JTextField text = new JTextField(textCol);

        ret.setLayout((flow == 0) ? new FlowLayout(FlowLayout.LEFT) : new FlowLayout(FlowLayout.RIGHT));
        ret.add(label);
        ret.add(text);

        if (button != null) {
            // Specific Button Interaction
            button.addActionListener(event -> {
                String inText = text.getText(); // Grabs whats in Text Box
                logger.info("Submitted " + inText + " to Approver...");

                // Updates Status => if valid continue if not do nothing...
                if (!acc.sendImmigrantStatus(inText))
                    return;

                // Kills current Window
                frame.dispose();

                frame = new JFrame();
                JLabel finale = new JLabel("SUBMITTED TO APPROVER");

                finale.setFont(new Font(null, Font.PLAIN, 15));

                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setSize(300, 100);
                frame.setLayout(new FlowLayout(FlowLayout.CENTER)); // Makes Sure items are centered with no weird gaps
                frame.setVisible(true);
                frame.setResizable(false);
                frame.add(finale);
            });
        }

        return ret;
    }

    private void createWindow() {
        // Structures it so that they are on top of each other going down
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(componentAdd(20, "Immigrant ID", 1, null));
        panel.add(componentAdd(20, "Immigrant Status", 1, button));
        panel.add(button);

        // Normal Field Settings
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER)); // Makes Sure items are centered with no weird gaps
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(panel);
    }

    public static void main(String[] args) {
        Reviewer r = new Reviewer(
            new DHSaccount("null", "null", 0, "null"),
            new workflow(0, "null"),
            "Reviewer BETA"
        );
    }
}
