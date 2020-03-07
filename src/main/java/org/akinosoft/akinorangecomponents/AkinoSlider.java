package org.akinosoft.akinorangecomponents;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class AkinoSlider implements Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new AkinoSlider());
    }

    @Override
    public void run() {
        // Jslider!!
        //JSlider s0 = new JSlider();
        // By default, the slider is horizontal, no decorations, minimum 0, maximum 100
        JSlider s0 = new JSlider(JSlider.HORIZONTAL, 0, 100, 75); // min and max has to be integers
        // Let's draw ticks
        s0.setMajorTickSpacing(25); // Big ticks each 25 units
        s0.setMinorTickSpacing(5); // Small Ticks each 5
        s0.setPaintTicks(true); // And we want to see them
        s0.setPaintLabels(true); // Also some numbers to see

        // Another example
        JSlider s1 = new JSlider(JSlider.VERTICAL, 0, 10, 5);
        s1.setMajorTickSpacing(2);
        s1.setMinorTickSpacing(1);
        s1.setPaintTicks(true);
        s1.setPaintLabels(true);

        //Another way for labels
        JSlider s2 = new JSlider(JSlider.VERTICAL, 0, 8, 3);
        s2.setMinorTickSpacing(1);
        s2.setPaintTicks(true);
        Hashtable<Integer, JLabel> labels2 = new Hashtable<>();
        labels2.put(0, new JLabel("mute"));
        labels2.put(1, new JLabel("soft"));
        labels2.put(8, new JLabel("loud"));
        s2.setLabelTable(labels2);
        s2.setPaintLabels(true);

        // JSlider return integers, but we can fake decimals
        JSlider s3 = new JSlider(JSlider.VERTICAL, 0, 1000, 500);
        s3.setMajorTickSpacing(250);
        s3.setMinorTickSpacing(50);
        s3.setPaintTicks(true);
        Hashtable<Integer, JLabel> labels3 = new Hashtable<>();
        labels3.put(0, new JLabel("0.00"));
        labels3.put(250, new JLabel("0.25"));
        labels3.put(500, new JLabel("0.50"));
        labels3.put(750, new JLabel("0.75"));
        labels3.put(1000, new JLabel("1.00"));
        s3.setLabelTable(labels3);
        s3.setPaintLabels(true);
        s3.setInverted(true); // We can turn around the slider!!

        // A LAbel to show some text..
        JLabel messageLabel = new JLabel("AkinoSoft!");
        // A button to update that text..
        JButton updateButton = new JButton("Update");
        //updateButton.addActionListener(e -> messageLabel.setText("Updated!"));
        //updateButton.addActionListener(e -> messageLabel.setText("s0 is set to "+s0.getValue())); // When button is clicked, We get the value
        updateButton.addActionListener(e -> messageLabel.setText("s3 is set to " + s3.getValue() / 1000.0)); // When button is clicked, We get the value

        // Border Layout to be in the NORTH of the mainPanel Layout
        JPanel northPanel = new JPanel(new BorderLayout(20, 20)); // Border Layout is the best
        northPanel.add(updateButton, BorderLayout.WEST);
        northPanel.add(messageLabel, BorderLayout.CENTER);
        northPanel.add(s0, BorderLayout.SOUTH); // A nice simple slider

        JPanel gridPanel = new JPanel(new GridLayout(1, 0, 10, 0));
        gridPanel.add(s1);
        gridPanel.add(s2);
        gridPanel.add(s3);

        JPanel mainPanel = new JPanel(new BorderLayout(20, 40));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(gridPanel, BorderLayout.CENTER);

        JFrame frame = new JFrame("AkinoSliders!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.setSize(400, 400);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}
