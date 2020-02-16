package org.akinosoft.akinolayouts;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AkinoComposingLayouts {

    private String[] dimensionChoices = {"pixels", "points"};
    private String[] sizeChoices = {"inches", "cm", "mm"};
    private String[] resolutionChoices = {"pixels/inch", "pixels/cm"};
    private String[] resampleChoices = {"Bicubic (Best for smooth gradients)", "Nearest Neighbor", "Bilinear"};

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AkinoComposingLayouts().startup());
    }

    public void startup() {
        // Buttons on the right side
        JPanel rightButtonPanel = new JPanel(new GridLayout(0, 1, 0, 8));
        rightButtonPanel.add(new JButton("OK"));
        rightButtonPanel.add(new JButton("Cancel"));
        rightButtonPanel.add(new JButton("Auto..."));

        // eastPanel will have the buttons
        JPanel eastPanel = new JPanel(new BorderLayout(8, 8));
        eastPanel.add(rightButtonPanel, BorderLayout.NORTH);

        // Checkboxes
        JPanel checkboxPanel = new JPanel(new GridLayout(0, 1, 0, 8));
        checkboxPanel.add(new JCheckBox("Scale Styles", true)); // selected by default
        checkboxPanel.add(new JCheckBox("Constraints Proportions", true));
        checkboxPanel.add(new JCheckBox("Resample image:", true));


        JPanel innerSettingsPanel = new JPanel(new BorderLayout(8, 8));
        innerSettingsPanel.add(createDocumentPanel(), BorderLayout.NORTH);  // createDocumentPanel() returns a JPanel
        innerSettingsPanel.add(checkboxPanel, BorderLayout.CENTER);
        innerSettingsPanel.add(new JComboBox<String>(resampleChoices), BorderLayout.SOUTH);

        // The settingsPanel will hold the options to be changed
        JPanel settingsPanel = new JPanel(new BorderLayout(8, 8));
        // Now a new trick! As the construction of this parts is fairly complex, we separate them to methods
        settingsPanel.add(createDimensionsPanel(), BorderLayout.NORTH); // createDimensionsPanel() returns a JPanel
        settingsPanel.add(innerSettingsPanel, BorderLayout.CENTER);

        // The outerPanel will hold everything
        JPanel outerPanel = new JPanel(new BorderLayout(20, 8));
        outerPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8)); // Some space to the edge of the frame
        outerPanel.add(eastPanel, BorderLayout.EAST); // Panel to the right with buttons
        outerPanel.add(settingsPanel, BorderLayout.CENTER); // Main options


        JFrame frame = new JFrame("Akino dialog composition with layouts");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(outerPanel); // Everything is inside the outerPanel

        //frame.setSize(425, 340);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private JPanel createDimensionsPanel() {

        JPanel westPanel = new JPanel(new GridLayout(0, 1, 0, 8));
        JPanel centerPanel = new JPanel(new GridLayout(0, 1, 0, 8));
        JPanel eastPanel = new JPanel(new GridLayout(0, 1, 0, 8));

        westPanel.add(new JLabel("Width:", JLabel.RIGHT));
        centerPanel.add(new JTextField("1440"));
        eastPanel.add(new JComboBox<String>(dimensionChoices));

        westPanel.add(new JLabel("Height:", JLabel.RIGHT));
        centerPanel.add(new JTextField("900"));
        eastPanel.add(new JComboBox<String>(dimensionChoices));

        JPanel mainPanel = new JPanel(new BorderLayout(8, 8));
        mainPanel.add(westPanel, BorderLayout.WEST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(eastPanel, BorderLayout.EAST);

        JPanel farEastPanel = new JPanel(); // The default Layout is FlowLayout
        JToggleButton toggle = new JToggleButton("]", true);
        toggle.setPreferredSize(new Dimension(40, 50)); // we force the height of the button
        farEastPanel.add(toggle);

        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.setBorder(BorderFactory.createTitledBorder("Pixel Dimensions"));
        panel.add(mainPanel, BorderLayout.CENTER);
        panel.add(farEastPanel, BorderLayout.EAST);
        return panel;
    }

    private JPanel createDocumentPanel() {
        JPanel westPanel = new JPanel(new GridLayout(0, 1, 0, 8));
        JPanel centerPanel = new JPanel(new GridLayout(0, 1, 0, 8));
        JPanel eastPanel = new JPanel(new GridLayout(0, 1, 0, 8));

        westPanel.add(new JLabel("Width:", JLabel.RIGHT));
        centerPanel.add(new JTextField("20.05"));
        eastPanel.add(new JComboBox<String>(sizeChoices));

        westPanel.add(new JLabel("Height:", JLabel.RIGHT));
        centerPanel.add(new JTextField("12.503"));
        eastPanel.add(new JComboBox<String>(sizeChoices));

        westPanel.add(new JLabel("Resolution:", JLabel.RIGHT));
        centerPanel.add(new JTextField("72"));
        eastPanel.add(new JComboBox<String>(resolutionChoices));

        JPanel mainPanel = new JPanel(new BorderLayout(8, 8));
        mainPanel.add(westPanel, BorderLayout.WEST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(eastPanel, BorderLayout.EAST);

        JPanel farEastPanel = new JPanel(); // The default Layout is FlowLayout
        JToggleButton toggle = new JToggleButton("]", true);
        toggle.setPreferredSize(new Dimension(40, 50)); // we force the height of the button
        farEastPanel.add(toggle);


        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.setBorder(BorderFactory.createTitledBorder("Document Size"));
        panel.add(mainPanel, JLabel.CENTER);
        panel.add(farEastPanel, BorderLayout.EAST);
        return panel;
    }
}
