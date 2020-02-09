package org.akinosoft.akinotoggle;

import org.akinosoft.ballicon.BallIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class AkinoToggleButton {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AkinoToggleButton().startup());
    }

    public void startup() {
        // Toggle button setup
        JToggleButton toggleButton = new JToggleButton("Mute", true);
        toggleButton.setIcon(new BallIcon(15, Color.LIGHT_GRAY));
        toggleButton.setSelectedIcon(new BallIcon(15, Color.RED));
        toggleButton.addItemListener(e -> hadleToggle(e));

        // Regular button
        JButton stockButton = new JButton("Check mute");
        stockButton.addActionListener(e -> System.out.println("mute state is: " + toggleButton.isSelected()));


        JFrame frame = new JFrame("AkinoToggle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        frame.getContentPane().add(toggleButton);
        frame.getContentPane().add(stockButton);

        frame.setSize(240, 120);
        //frame.pack();
        frame.setLocationByPlatform(true); // let OS decide Frame location
        frame.setVisible(true);
    }

    public void hadleToggle(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            System.out.println("mute is ON");
        } else {
            System.out.println("mute is OFF");
        }
    }
}
