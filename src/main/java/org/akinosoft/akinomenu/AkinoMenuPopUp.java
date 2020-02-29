package org.akinosoft.akinomenu;

import javax.swing.*;
import java.awt.*;

public class AkinoMenuPopUp implements Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new AkinoMenuPopUp());
    }

    @Override
    public void run() {
        JMenu toastMenu = new JMenu("Toast");
        JMenuItem toastWheat = new JMenuItem("Wheat toast");
        JMenuItem toastWhite = new JMenuItem("White toast");
        toastWheat.addActionListener(e -> System.out.println("Wheat Toast"));
        toastWhite.addActionListener(e -> System.out.println("White Toast"));
        toastMenu.add(toastWheat);
        toastMenu.add(toastWhite);

        //JMenu breadMenu = new JMenu("Bread"); // This is the menu we want to convert to PopUp
        JPopupMenu breadMenu = new JPopupMenu(); // No label needed
        JMenuItem breadPancakes = new JMenuItem("Pancakes");
        JMenuItem breadWaffle = new JMenuItem("Waffle");
        JMenuItem breadBiscuit = new JMenuItem("Biscuit");
        breadPancakes.addActionListener(e -> System.out.println("Pancakes"));
        breadWaffle.addActionListener(e -> System.out.println("Waffle"));
        breadBiscuit.addActionListener(e -> System.out.println("Biscuit"));
        breadMenu.add(breadPancakes);
        breadMenu.add(breadWaffle);
        breadMenu.add(breadBiscuit);
        breadMenu.add(toastMenu); // Nested Menu!!

        // We are not using menu bar here...
//        JMenuBar menuBar = new JMenuBar();
//        menuBar.add(breadMenu);

        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        JLabel greeting = new JLabel("Welcome to the Akino Cafeteria", JLabel.CENTER);
        mainPanel.add(greeting);

        JButton button = new JButton("Click Me!"); // buttons don't show PopUp menus from their parents...
        //button.setInheritsPopupMenu(true); // ...Unless you force to it. But usually wouldn't do this.
        mainPanel.add(button);

        // We can add The popUp menu to a single widget...
        //greeting.setComponentPopupMenu(breadMenu);

        // Or the the whole panel
        mainPanel.setComponentPopupMenu(breadMenu);

        // We can show the PopUp with the action from the button
        //button.addActionListener( e -> breadMenu.show(greeting, 0,0)); // this shows the PopUp appearing
        // in 0,0 of the greeting JLabel
        // but usually we specify the same button
        button.addActionListener(e -> breadMenu.show(button, 10, 20));

        JFrame frame = new JFrame("Akino PopUp Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        //frame.setJMenuBar(menuBar); // No menu bars in this example
        frame.setSize(240, 240);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

    }
}
