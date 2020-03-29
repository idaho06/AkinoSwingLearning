package org.akinosoft.akinolistsandcombos;

import javax.swing.*;
import java.awt.*;

public class AkinoListColumns implements Runnable {

    private String[] states = {"Alabama", "Alaska", "Arizona", "Arkansas", "California",
            "Colorado", "Connecticut", "Delaware", "District of Columbia", "Florida",
            "Georgia", "Guam", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
            "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan",
            "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
            "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina",
            "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico",
            "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas",
            "Utah", "Vermont", "Virgin Islands", "Virginia", "Washington", "West Virginia",
            "Wisconsin", "Wyoming"};


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new AkinoListColumns());
    }

    @Override
    public void run() {
        JList<String> jList = new JList<>(states);
        //jList.setLayoutOrientation(JList.HORIZONTAL_WRAP); // this makes the list to spread horizontal, with 8 rows
        //jList.setVisibleRowCount(0); // This makes the list to change the rows to adapt to the JList current size
        jList.setLayoutOrientation(JList.VERTICAL_WRAP); // this makes the list to spread vertical and wrap to next column when reaches the bottom of the size of the JList
        jList.setVisibleRowCount(0); // This makes the list to change the rows to adapt to the JList current size, fer vertical too

        // to avoid text of columns touch each other...
        //jList.setFixedCellWidth(150); // We can force the width of the column to a number of pixels
        //jList.setFixedCellHeight(22); // and also the height, although it's pretty ugly
        jList.setPrototypeCellValue("District of Columbia  "); // another way is by using the longest value and adding a couple of spaces


        JButton button = new JButton("Click Me!");
        button.addActionListener(e -> System.out.println("Select values are " + jList.getSelectedValuesList()));

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.add(button, BorderLayout.SOUTH);
        mainPanel.add(new JScrollPane(jList), BorderLayout.CENTER);

        JFrame frame = new JFrame("AkinoList, columns");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.setLocationByPlatform(true);
        //frame.pack();
        frame.setSize(750, 300);
        frame.setVisible(true);

    }
}
