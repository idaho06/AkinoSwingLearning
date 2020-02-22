package org.akinosoft.akinopanes;

import org.akinosoft.ballicon.BallIcon;

import javax.swing.*;
import java.awt.*;

public class AkinoJTabPane implements Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new AkinoJTabPane());
    }

    public static JPanel createRadioPanel(String... choices) {
        JPanel buttonPanel = new JPanel(new GridLayout());
        ButtonGroup buttonGroup = new ButtonGroup(); // we only want a choice, we need to group the radio buttons
        for (String choice : choices) {
            JRadioButton b = new JRadioButton(choice);
            buttonPanel.add(b);
            buttonGroup.add(b);
        }
        JPanel outerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        outerPanel.add(buttonPanel);
        return outerPanel;
    }

    @Override
    public void run() {
        JLabel topLabel = new JLabel("Select your character!", JLabel.LEFT);

        JPanel namesPanel = createRadioPanel("Idaho", "Rivitas", "Palo", "Ikky");
        namesPanel.setName("Name");
        JPanel hairColorsPanel = createRadioPanel("Brown", "Blonde", "Bald");
        hairColorsPanel.setName("Hair color");
        JPanel complexionsPanel = createRadioPanel("Thin", "Fat", "Athletic");
        complexionsPanel.setName("Complexion");

        JButton hairButton = new JButton("Go to hair");
        namesPanel.add(hairButton);

        // Now we create the tabs with each JPanel
        JTabbedPane tabbedPane = new JTabbedPane();
        //tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT); // creates a scroll if tabbs are wider than widget
        //tabbedPane.setTabPlacement(JTabbedPane.LEFT); // Configures placement of tabs
        tabbedPane.addTab("Name", namesPanel);
        tabbedPane.addTab("Hair Color", hairColorsPanel);
        tabbedPane.addTab("Complexion", complexionsPanel);
        tabbedPane.setIconAt(0, new BallIcon(8, Color.RED)); // Names has a red dot
        tabbedPane.setEnabledAt(2, false); // Complexions are disabled

        // We can detect when we change tabs
        //tabbedPane.addChangeListener(e -> topLabel.setText("Choosing: "+tabbedPane.getSelectedIndex()));
        tabbedPane.addChangeListener(e -> topLabel.setText("Choosing: " + tabbedPane.getSelectedComponent().getName()));

        //hairButton.addActionListener( e -> tabbedPane.setSelectedIndex(1)); // When clicked, the tabs pane select "Hair"
        hairButton.addActionListener(e -> tabbedPane.setSelectedComponent(hairColorsPanel)); // When clicked, the tabs pane select "Hair"

        JPanel mainPanel = new JPanel(new BorderLayout(8, 8));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        mainPanel.add(topLabel, BorderLayout.NORTH);
        mainPanel.add(tabbedPane, BorderLayout.CENTER);


        JFrame frame = new JFrame("Akino JTabPAne");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(mainPanel);

        frame.setSize(300, 300);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

    }
}
