package org.akinosoft.akinolayouts;

import org.akinosoft.ballicon.BallIcon;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class AkinoBordersOnComponents {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AkinoBordersOnComponents().startup());
    }

    public void startup() {
        //JComponent button0 = new JButton("button");
        //button0.setBorder(BorderFactory.createEmptyBorder()); // Empty border of no width. Do not do this on buttons. This erases the button decoration...
        // Instead, put the button in a panel and add border to the panel
        JComponent button0 = new JPanel(new BorderLayout());
        button0.add(new JButton("button within panel"), BorderLayout.CENTER);
        button0.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JComponent comp0 = new JLabel("compound", JLabel.CENTER);
        comp0.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createRaisedBevelBorder(),
                //BorderFactory.createLineBorder(Color.YELLOW) // hard to distinguish, lets separate with another compound
                BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(5, 5, 5, 5),
                        BorderFactory.createLineBorder(Color.YELLOW)
                )
        ));

        JLabel lab1 = new JLabel("etched", JLabel.CENTER);
        lab1.setBorder(BorderFactory.createEtchedBorder());
        //lab1.setBackground(Color.RED); // The Etched Border respects the background, so this is an easy way to make borders in colors

        JLabel lab2 = new JLabel("raised bevel", JLabel.CENTER);
        lab2.setBorder(BorderFactory.createRaisedBevelBorder());
        //lab2.setBackground(Color.GREEN);

        JLabel lab3 = new JLabel("lowered bevel", JLabel.CENTER);
        lab3.setBorder(BorderFactory.createLoweredBevelBorder());
        //lab3.setBackground(Color.BLUE);

        JLabel lab4 = new JLabel("titled", JLabel.CENTER);
        TitledBorder borderlab4 = BorderFactory.createTitledBorder("Hello, Akino.");
        borderlab4.setTitleJustification(TitledBorder.RIGHT);
        borderlab4.setTitlePosition(TitledBorder.BOTTOM);
        lab4.setBorder(borderlab4);// Lot's of interesting options to configure the Title border


        JLabel lab5 = new JLabel("line", JLabel.CENTER);
        lab5.setBorder(BorderFactory.createLineBorder(Color.PINK, 8)); // Only can set one value for all sides of the border

        JLabel lab6 = new JLabel("matte", JLabel.CENTER);
        lab6.setBorder(BorderFactory.createMatteBorder(5, 10, 15, 20, Color.MAGENTA)); // any value for each side

        JLabel lab7 = new JLabel("matte (tiled icon)", JLabel.CENTER);
        lab7.setBorder(BorderFactory.createMatteBorder(15, 15, 15, 15, new BallIcon(15, Color.GREEN)));

        JPanel mainPanel = new JPanel(new GridLayout(0, 1, 20, 8));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.add(button0);
        mainPanel.add(comp0);
        mainPanel.add(lab1);
        mainPanel.add(lab2);
        mainPanel.add(lab3);
        mainPanel.add(lab4);
        mainPanel.add(lab5);
        mainPanel.add(lab6);
        mainPanel.add(lab7);

        JFrame frame = new JFrame("Akino Borders showcase");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);

        //frame.setSize(200, 400);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

    }
}
