package org.akinosoft.akinoframelocationandsize;

import javax.swing.*;
import java.awt.*;

public class AkinoLocAndSiz {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AkinoLocAndSiz().startup());
    }

    public void startup() {
        JLabel greeting = new JLabel("Hello, Akino!!!", JLabel.CENTER);
        greeting.setFont(new Font("serif", Font.PLAIN, 32));
        greeting.setForeground(Color.red);
        //greeting.setBorder(BorderFactory.createEmptyBorder(128,128 ,128,128)); // give space around the widget
        //greeting.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        //greeting.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)); // Creates a button-like effect


        JFrame frame = new JFrame("AkinoFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(greeting);
        //frame.setSize(320,240); // custom size of the Frame
        frame.pack(); // Set the Frame at the minimum size possible.
        // You can use Borders to make room to the elements of the Frame
        //frame.setLocation(200,200);
        // Sets Frame in a fixed location on the screen (Not real pixels if screen
        // is scaled)
        //frame.setLocationRelativeTo(null); // Sets the Frame relative to other Frame. As this example has only one Frame
        // we pass null and the Frame will appear centered to the display
        frame.setLocationByPlatform(true); // Let the operating system decide

        frame.setVisible(true);
    }
}
