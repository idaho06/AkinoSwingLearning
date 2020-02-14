package org.akinosoft.akinocontentpane;

import javax.swing.*;
import java.awt.*;

public class AkinoContentPane {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AkinoContentPane().startup());
    }

    public void startup() {

        JLabel content = new JLabel("Fallen from Kilimanjaro!!!", JLabel.CENTER);

        JPanel mainPanel = new JPanel(new BorderLayout()); // By default, JPanel uses FlowLayout!!
        mainPanel.setBorder((BorderFactory.createLineBorder(Color.CYAN, 24)));
        mainPanel.add(content);

        JFrame frame = new JFrame("Akino Content Pane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //frame.getContentPane().setLayout(new FlowLayout()); // This gives no flexibility
        //frame.getContentPane().add(content);

        // frame.getContentPane().add(mainPanel); // needless nesting... instead, we can just substitute the Content pane

        frame.setContentPane(mainPanel);

        frame.setSize(400, 200);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}
