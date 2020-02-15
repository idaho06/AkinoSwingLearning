package org.akinosoft.akinolayouts;

import javax.swing.*;
import java.awt.*;

public class AkinoFlowLayout {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AkinoFlowLayout().startup());
    }

    public void startup() {
        JButton tallerButton = new JButton("Three");
        tallerButton.setFont(new Font("sanserif", Font.PLAIN, 48));

        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        mainPanel.add(new JButton("One"));
        mainPanel.add(new JButton("Two"));
        //mainPanel.add(new JButton("Three"));
        mainPanel.add(tallerButton);
        mainPanel.add(new JButton("Four"));
        mainPanel.add(new JButton("Five"));
        mainPanel.add(new JButton("Six"));
        mainPanel.add(new JButton("Seven"));
        mainPanel.add(new JButton("Eight"));
        mainPanel.add(new JButton("Nine"));


        JFrame frame = new JFrame("Akino example of Flow Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(mainPanel);

        //frame.setSize(400, 200);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

}
