package org.akinosoft.akinopanes;

import org.akinosoft.ballicon.BallIcon;

import javax.swing.*;
import java.awt.*;

public class AkinoJScrollPane implements Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new AkinoJScrollPane());
    }

    public JPanel createButtonPanel(int count) { // returns a panel filled with "count" buttons stacked vertically
        JPanel panel = new JPanel(new GridLayout(0, 1, 0, 8)); // Single column grid layout
        for (int j = 1; j <= count; j += 1) {
            panel.add(new JButton("Button " + j));
        }
        panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        return panel;
    }

    public void startup() {

        JPanel verticalButtonPanel = createButtonPanel(15);


        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //mainPanel.add(verticalButtonPanel, BorderLayout.CENTER); // If we add the widget without the scroll pane, the result is ugly as hell
        //mainPanel.add(new JScrollPane(verticalButtonPanel), BorderLayout.CENTER); // This is much better, now we have scroll bars around the widget.
        // The buttons resize to their preferred size inside the scroll pane
        // Any component can be inside JScrollPane, but some components are meant to be used within it:
        // JList
        // JTable
        // JTree
        // JTextArea
        // JTextPane
        // JEditorPane

        JScrollPane scrollPane = new JScrollPane(verticalButtonPanel);
        // we can configure how the scrollbars appear
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // we can add a component in the little square in the bottom right
        JButton cornerButton = new JButton(new BallIcon(8, Color.GREEN));
        cornerButton.addActionListener(e -> System.out.println("AkinoCorner!!"));
        scrollPane.setCorner(JScrollPane.LOWER_RIGHT_CORNER, cornerButton);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JFrame frame = new JFrame("Akino ScrollPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.setSize(200, 300);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    @Override
    public void run() {
        startup();
    }
}
