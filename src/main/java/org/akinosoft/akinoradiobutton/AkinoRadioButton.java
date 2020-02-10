package org.akinosoft.akinoradiobutton;

import javax.swing.*;
import java.awt.*;

public class AkinoRadioButton {

    private ButtonGroup intButtonGroup = new ButtonGroup();
    private ButtonGroup extButtonGroup = new ButtonGroup();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AkinoRadioButton().startup());
    }

    private void startup() {
        JLabel extHeader = new JLabel("Exterior choices");
        JLabel intHeader = new JLabel("Interior choices");

        JRadioButton ext1 = new JRadioButton("Silver Ice");
        ext1.setActionCommand("Silver_Ice");
        JRadioButton ext2 = new JRadioButton("Crystal Red");
        ext2.setActionCommand("Crystal_Red");
        JRadioButton ext3 = new JRadioButton("White Diamond");
        ext3.setActionCommand("White_Diamond");
        JRadioButton ext4 = new JRadioButton("Cyber Gray");
        ext4.setActionCommand("Cyber_Gray");
        JRadioButton ext5 = new JRadioButton("Viridian Joule");
        ext5.setActionCommand("Viridian_Joule");
        JRadioButton int1 = new JRadioButton("Black Cloth", true); // selected button
        int1.setActionCommand("Black_Cloth");
        JRadioButton int2 = new JRadioButton("Black Leather");
        int2.setActionCommand("Black_Leather");
        JRadioButton int3 = new JRadioButton("Natural Leather");
        int3.setActionCommand("Natural_Leather");

        // We have to group buttons
        //ButtonGroup extButtonGroup = new ButtonGroup(); // Declared as class member
        extButtonGroup.add(ext1);
        extButtonGroup.add(ext2);
        extButtonGroup.add(ext3);
        extButtonGroup.add(ext4);
        extButtonGroup.add(ext5);
        //ButtonGroup intButtonGroup = new ButtonGroup(); // Declared as class member
        intButtonGroup.add(int1);
        intButtonGroup.add(int2);
        intButtonGroup.add(int3);

        // ext1.setSelected(true); // Another way of set the selected button

        JButton goButton = new JButton("Place Order");
        goButton.addActionListener(e -> placeOrder());


        JFrame frame = new JFrame("Radio Buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.getContentPane().add(extHeader);
        frame.getContentPane().add(ext1);
        frame.getContentPane().add(ext2);
        frame.getContentPane().add(ext3);
        frame.getContentPane().add(ext4);
        frame.getContentPane().add(ext5);
        frame.getContentPane().add(intHeader);
        frame.getContentPane().add(int1);
        frame.getContentPane().add(int2);
        frame.getContentPane().add(int3);
        frame.getContentPane().add(goButton);
        frame.setSize(175, 350);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private void placeOrder() {
        ButtonModel selectedInteriorButtonModel = intButtonGroup.getSelection();
        if (selectedInteriorButtonModel == null) { // we have to check the ButtonModel
            System.out.println("No selected interior");
        } else {
            System.out.println("interior: " + selectedInteriorButtonModel.getActionCommand());
        }
        ButtonModel selectedExteriorButtonModel = extButtonGroup.getSelection();
        if (selectedExteriorButtonModel == null) { // we have to check the ButtonModel
            System.out.println("No selected exterior");
        } else {
            System.out.println("exterior: " + selectedExteriorButtonModel.getActionCommand());
        }

    }
}
