package src;

import java.util.ArrayList;

import java.util.logging.Logger;

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
    private Logger logger;

    private DHSaccount acc;
    private workflow table;

    private ArrayList<JTextField> args;

    private JFrame frame;
    private JPanel panel;
    private JButton button;

    public Reviewer(DHSaccount acc, workflow table, String version) {
        logger = Logger.getLogger(getClass().getName());

        this.acc = acc;
        this.table = table;

        args = new ArrayList<>();

        frame = new JFrame(version);
        panel = new JPanel();
        button = new JButton("Submit");

        createWindow();
    }

    private JPanel componentAdd(String preset, int textCol, String labelTag, int flow, JButton button) {
        JPanel ret = new JPanel();
        JLabel label = new JLabel(labelTag + ":");
        JTextField text = new JTextField(preset, textCol);

        args.add(text);

        ret.setLayout((flow == 0) ? new FlowLayout(FlowLayout.LEFT) : new FlowLayout(FlowLayout.RIGHT));
        ret.add(label);
        ret.add(text);

        if (button != null) {
            // Specific Button Interaction
            button.addActionListener(event -> {
                String ID = args.get(0).getText();
                String upStatus = args.get(1).getText();

                if (ID.isEmpty() || upStatus.isEmpty())
                    return;


                // Updates Status => if valid continue if not do nothing...
                if (!acc.validateImmigrantStatus(upStatus))
                    return;

                if (!acc.validateImmigrantID(ID))
                    return;

                logger.info("Submitted " + upStatus + " with ID of " + ID + " to Approver...");

                // Kills current Window
                frame.dispose();

                table.pushToApprover(acc);
            });
        }

        return ret;
    }

    private void createWindow() {
        // Structures it so that they are on top of each other going down
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(componentAdd(acc.getImmigrantID(), 20, "Immigrant ID", 1, null));
        panel.add(componentAdd(acc.getimmigrantStatus(), 20, "Immigrant Status", 1, button));
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
        // Reviewer r = new Reviewer(
        // new DHSaccount("null", "null", 0, "null"),
        // new workflow(),
        // "Reviewer BETA"
        // );
    }
}
