package org.akinosoft.akinolistsandcombos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AkinoListEvents implements Runnable {

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
        SwingUtilities.invokeLater(new AkinoListEvents());
    }

    @Override
    public void run() {

        JList<String> jList = new JList<>(states);
        jList.setLayoutOrientation(JList.VERTICAL_WRAP);
        jList.setVisibleRowCount(0);
        jList.setPrototypeCellValue("District of Columbia  ");

        // Let's capture the events created by the JList when the selection changes
        // Listeners can be added to an internal object of JList called "ListSelectionModel"
        jList.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                System.out.println("Selection change: " + jList.getSelectedValuesList());
            }
        });

        // What about a mouse event, like a double click in an element of the list?
        jList.addMouseListener(new MouseAdapter() { // Lambda notation does not work with this, we have to create an anonymous MouseAdapter object
            @Override
            public void mouseClicked(MouseEvent e) { // We override the mouseClicked to capture click events
                //super.mouseClicked(e);
                if (e.getClickCount() == 2) { // if double click...
                    int clickIndex = jList.locationToIndex(e.getPoint()); // we get the index from the point clicked
                    String clickItem = jList.getModel().getElementAt(clickIndex); // And the element string, using the index, asking to the Model object of the JList
                    System.out.println("Double click at: " + clickItem);
                }
                // let's detect click on elements, and only when the click is inside the element. Click on white space in the list is ignored
                if (e.getClickCount() == 1) { // if click
                    int clickIndex = jList.locationToIndex(e.getPoint()); // we get the index from the point clicked
                    String clickItem = jList.getModel().getElementAt(clickIndex); // And the element string, using the index, asking to the Model object of the JList
                    boolean inBounds = jList.getCellBounds(clickIndex, clickIndex).contains(e.getPoint());
                    if (inBounds) { // if the Cell bounds for the element clicked contains the point clicked...
                        System.out.println("Single click at: " + clickItem);
                    }
                }
                // A note of caution on locationToIndex method. If the JList is empty, this will return -1, causing troubles to getElementAt and getCellBounds
            }
        });


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
        frame.setSize(750, 300);
        frame.setVisible(true);


    }
}
