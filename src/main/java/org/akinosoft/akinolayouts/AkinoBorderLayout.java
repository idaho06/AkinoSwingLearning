package org.akinosoft.akinolayouts;

import javax.swing.*;
import java.awt.*;

public class AkinoBorderLayout {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AkinoBorderLayout().startup());
    }

    public void startup() {

        JPanel mainPanel = new JPanel(new BorderLayout(8, 8));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        // You can put widgets in NORTH, SOUTH, EAST, WEST, CENTER
        //mainPanel.add(new JButton("north"), BorderLayout.NORTH);
        //mainPanel.add(new JButton("east"), BorderLayout.EAST);
        mainPanel.add(new JButton("west"), BorderLayout.WEST);
        //mainPanel.add(new JButton("center"), BorderLayout.CENTER);
        mainPanel.add(new JButton("center")); // no need to set for CENTER
        //mainPanel.add(new JButton("south"), BorderLayout.SOUTH);
        //mainPanel.add(new JButton("yonder"), BorderLayout.SOUTH); // IF you add a widget a second time to a border,
        // it gets replaced instead of added.
        // It's best to add another Panel
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        southPanel.add(new JButton("south"));
        southPanel.add(new JButton("yonder"));

        mainPanel.add(southPanel, BorderLayout.SOUTH);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(mainPanel);

        frame.setSize(400, 200);
        //frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

    }
}
