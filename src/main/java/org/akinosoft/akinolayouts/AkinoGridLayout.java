package org.akinosoft.akinolayouts;

import javax.swing.*;
import java.awt.*;

public class AkinoGridLayout {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AkinoGridLayout().startup());
    }

    public void startup() {
        JPanel mainPanel = new JPanel(new GridLayout(3, 0, 8, 8));
        //JPanel mainPanel = new JPanel(new GridLayout(0, 3, 8, 8));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        mainPanel.add(new JButton("One"));
        mainPanel.add(new JButton("Two"));
        mainPanel.add(new JButton("Three"));
        mainPanel.add(new JButton("Four"));
        mainPanel.add(new JButton("Five"));
        //mainPanel.add(new JButton("Six"));
        //mainPanel.add(new JButton("Seven"));
        //mainPanel.add(new JButton("Eight"));
        //mainPanel.add(new JButton("Nine"));

        JFrame frame = new JFrame("Grid Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(mainPanel);

        frame.setSize(400, 200);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}
