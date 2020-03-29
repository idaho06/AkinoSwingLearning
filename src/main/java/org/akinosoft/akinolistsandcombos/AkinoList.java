package org.akinosoft.akinolistsandcombos;

import javax.swing.*;
import java.awt.*;
import java.time.Month;
import java.util.Arrays;

public class AkinoList implements Runnable {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new AkinoList());
    }

    @Override
    public void run() {

        /*
        // Lists can use ArrayList or Vectors. Let's use Vector here
        Vector<String> akinoVector = new Vector<>();
        akinoVector.add("Abubilla");
        akinoVector.add("Kilimanjaro");
        akinoVector.add("Aer!");
        akinoVector.add("Ear!");
        JList<String> jList = new JList<>(akinoVector);
        // jList.setSelectedValue();  // ??
        jList.setSelectedIndex(1);
        */

        Month[] months = Month.values();
        JList<Month> jList = new JList<>(months);
        //jList.setVisibleRowCount(4); // By default, the JList wants to show 8 elements of the list. With BorderLayout, we can make it resizable
        // Stuff we can change:
        //jList.setFont(); // Font
        //jList.setForeground(); // Color of the text
        //jList.setBackground(); // Background of the text
        jList.setSelectionForeground(Color.RED); // Color of the selected text
        jList.setSelectionBackground(Color.MAGENTA); // Background color of the selected text
        //jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Default selection mode
        //jList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); // Forces selecting one contiguous interval
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Forces selection of one value


        JButton button = new JButton("Get it!");
        button.addActionListener(e -> {
            //System.out.println("Selected values are: " + jList.getSelectedValue()); // This returns an Array. It's not printable
            System.out.println("Selected values are: " + jList.getSelectedValuesList());
            System.out.println("Selected indices are: " + Arrays.toString(jList.getSelectedIndices())); // result is always in increasing order
            // in case selection on the list is forced to "SINGLE_SELECTION", we can get the value like this:
            //System.out.println("Selected value is: " + jList.getSelectedValue());
            //System.out.println("Selected indices are: " + jList.getSelectedIndex());
        });


        //JPanel mainPanel = new JPanel(new FlowLayout()); // JPanel uses FlowLayout by default. JList will not resize
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10)); // With Border Layout, we can make it resizable

        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.add(button, BorderLayout.SOUTH);
        //mainPanel.add(jList); // Not a good idea. It should be always be enclosed in a ScrollPane
        mainPanel.add(new JScrollPane(jList), BorderLayout.CENTER);

        JFrame frame = new JFrame("Akino Lists");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.setSize(320, 240);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}
