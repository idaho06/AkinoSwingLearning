package org.akinosoft.akinorangecomponents;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

public class AkinoSpinner implements Runnable {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new AkinoSpinner());
    }

    @Override
    public void run() {

        JSpinner spin0 = new JSpinner();
        spin0.setValue(4); // We can set initial value of the spinner

        JSpinner spin1 = new JSpinner(new SpinnerNumberModel(4, -10, 10, 0.5));
        // But it's better to configure default, minimum, maximum and step size directly
        //JSpinner spin1 = new JSpinner(new SpinnerNumberModel(0.5,0,null,0.1));
        // It is possible to use floats. null in the minimum or maximum removes the limit.
        spin1.setEditor(new JSpinner.NumberEditor(spin1, "0.0;negative(0.0)"));

        JSpinner spin2 = new JSpinner(new SpinnerDateModel()); // This is a spinner for selecting a date
        spin2.setEditor(new JSpinner.DateEditor(spin2, "dd/MM/yyyy - HH:mm:ss")); // setting the format of the spinner
        // We cannot set a default date in the constructor, we have to create a date and set it:
        LocalDateTime ldt = LocalDateTime.of(2020, 03, 13, 15, 00);
        Date date = Date.from(ldt.atZone(java.time.ZoneOffset.systemDefault()).toInstant());
        spin2.setValue(date); // Setting the date is ugly as hell

        // Spinner of list of strings
        ArrayList<String> modes = new ArrayList<>();
        modes.add("Kilimanjaro");
        modes.add("Abubilla");
        modes.add("#malos");
        modes.add("Idaho");
        modes.add("Rx");
        modes.add("Palo");
        JSpinner spin3 = new JSpinner(new SpinnerListModel(modes));
        spin3.setValue(modes.get(3)); // "Idaho" is the fourth element. ArrayList starts at 0
        //spin3.setValue("Idaho"); // We can also set the raw element

        ChronoUnit[] units = ChronoUnit.values();
        JSpinner spin4 = new JSpinner(new SpinnerListModel(units));
        spin4.setValue(ChronoUnit.HOURS); // Other types also work for SpinnerListModel. They have to have a "toString" method

        JPanel northPanel = new JPanel(new GridLayout(0, 1, 0, 10));
        northPanel.add(spin0); // The spinner is going to end in the NORTH of a BorderLayout
        northPanel.add(spin1);
        northPanel.add(spin2);
        northPanel.add(spin3);
        northPanel.add(spin4);

        JPanel mainPanel = new JPanel(new BorderLayout()); // NORTH and SOUTH sides of BorderLayout are nice to Spinners
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.add(northPanel, BorderLayout.NORTH);


        JFrame frame = new JFrame("Akino Spinners");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.setSize(200, 250);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}
