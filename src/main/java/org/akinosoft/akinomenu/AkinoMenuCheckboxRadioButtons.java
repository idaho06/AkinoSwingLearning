package org.akinosoft.akinomenu;

import org.akinosoft.ballicon.BallIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AkinoMenuCheckboxRadioButtons implements Runnable {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new AkinoMenuCheckboxRadioButtons());
    }

    @Override
    public void run() {
        // Coffee Menu Item
        JMenuItem coffe = new JMenuItem("Coffee");
        coffe.addActionListener(e -> System.out.println("Coffee!"));

        JCheckBoxMenuItem bacon = new JCheckBoxMenuItem("Bacon"); // With bacon? Check box in the menu!
        bacon.addActionListener(e -> System.out.println("Bacon set to " + bacon.isSelected()));

        JRadioButtonMenuItem scrambled = new JRadioButtonMenuItem("Scrambled", true);
        JRadioButtonMenuItem overeasy = new JRadioButtonMenuItem("Over Easy");
        JRadioButtonMenuItem poached = new JRadioButtonMenuItem("Poached");
        scrambled.setActionCommand("Scrambled eggs A.C.");
        overeasy.setActionCommand("Over Easy eggs A.C.");
        poached.setActionCommand("Poached eggs A.C.");
        ButtonGroup eggGroup = new ButtonGroup(); // Let's make egg cooking mutually exclusive
        eggGroup.add(scrambled);
        eggGroup.add(overeasy);
        eggGroup.add(poached);

        Action loyaltyAction = new ToggleAction();

        JMenu orderMenu = new JMenu("Order");
        orderMenu.add(coffe);
        orderMenu.add(bacon);
        orderMenu.addSeparator();
        ;
        orderMenu.add(scrambled);
        orderMenu.add(overeasy);
        orderMenu.add(poached);
        orderMenu.addSeparator();
        orderMenu.add(new JCheckBoxMenuItem(loyaltyAction));

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(orderMenu);

        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        mainPanel.add(new JLabel("Welcome to the Akino Cafeteria", JLabel.CENTER));

        JButton b = new JButton("Eggs?");
//        b.addActionListener(e -> System.out.println(
//                scrambled.isSelected() + " " +
//                overeasy.isSelected() + " " +
//                poached.isSelected() ));
        b.addActionListener(e -> System.out.println(eggGroup.getSelection().getActionCommand())); // For this to work,
        // we need to set the Action Commands of the RadioMenuItems
        mainPanel.add(b);

        mainPanel.add(new JToggleButton(loyaltyAction));
        mainPanel.add(new JCheckBox(loyaltyAction));

        JFrame frame = new JFrame("Akino Menu Toggle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.setJMenuBar(menuBar);
        frame.setSize(240, 240);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    // Actions can be used
    class ToggleAction extends AbstractAction {
        private static final long serialVersionUID = 1L;

        public ToggleAction() {
            putValue(NAME, "Loyalty");
            putValue(SHORT_DESCRIPTION, "Use Loyalty card?");
            putValue(SMALL_ICON, new BallIcon(10, Color.ORANGE));
            putValue(ACCELERATOR_KEY,
                    KeyStroke.getKeyStroke(KeyEvent.VK_L, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
            putValue(SELECTED_KEY, Boolean.FALSE); // For the action to be reflected in every widget that uses it
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            if (Boolean.TRUE.equals(getValue(SELECTED_KEY))) {
                System.out.println("Thank you for using the loyalty card!");
            } else {
                System.out.println("No loyalty card...");
            }
        }
    }

}
