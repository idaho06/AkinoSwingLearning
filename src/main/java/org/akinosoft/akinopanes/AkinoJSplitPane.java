package org.akinosoft.akinopanes;

import javax.swing.*;
import java.awt.*;

public class AkinoJSplitPane implements Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new AkinoJSplitPane());
    }

    @Override
    public void run() {

        // First we need a couple of Panels with stuff inside....
        JPanel firstPanel = new JPanel(); // Defaults to FlowLauyout
        // As the JSplitPane separator handle honours the minimun size, we force it to being able to srink more than
        // the size of the button by configuring the minimun size
        //firstPanel.setMinimumSize(new Dimension(4,4));
        JButton button1 = new JButton("first");
        firstPanel.add(button1);

        JPanel secondPanel = new JPanel(); // Defaults to FlowLauyout
        //secondPanel.setMinimumSize(new Dimension(4,4));
        JButton button2 = new JButton("second");
        secondPanel.add(button2);

        // And now we create the split pane, that we are going to feed to the mainPanel
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, firstPanel, secondPanel);
        // one touch expandable little buttons
        splitPane.setOneTouchExpandable(true);
        // Also, moving the separation should be interactive
        splitPane.setContinuousLayout(true);

        //splitPane.setDividerLocation(0.5); // This does not work, because we still dont know how big is the frame!

        //now let's make the buttons do stuff
        button1.addActionListener(e -> splitPane.setDividerLocation(75)); // integer values are pixels
        button2.addActionListener(e -> splitPane.setDividerLocation(0.75)); // double values are proportional

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.add(splitPane);

        JFrame frame = new JFrame("Akino JSplitPAne");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(mainPanel);

        frame.setSize(300, 300);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        splitPane.setDividerLocation(0.5); // Now we know  where the middle is exactly
    }
}
