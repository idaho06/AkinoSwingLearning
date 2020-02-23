package org.akinosoft.akinomenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class AkinoMenu implements Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new AkinoMenu());
    }

    @Override
    public void run() {

        //Let's build JMenuItems first!
        JMenuItem abubillaMenuItem = new JMenuItem("Akino Abubilla");
        // JMenuItem is similar to JButton. You can create Action Listeners on the JMenuItem
        abubillaMenuItem.addActionListener(e -> System.out.println("Akino Abubilla!!"));
        // Also mnemonics
        abubillaMenuItem.setMnemonic(KeyEvent.VK_A); // This auto-creates alt-A shortcut...
        // but only works when the menuItem is visible.
        abubillaMenuItem.setDisplayedMnemonicIndex(6);
        // And of course, accelerators
        abubillaMenuItem.setAccelerator(KeyStroke.getKeyStroke('A', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        // In order to get "command" key in mac and "ctrl" key in windows, we have to use
        // Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx(). (Since 10!!)
        // to get the correct modifier

        JMenuItem kilimanjaroMenuItem = new JMenuItem("Akino Kilimanjaro");
        kilimanjaroMenuItem.addActionListener(e -> System.out.println("Fallen From Kilimanjaro!!"));
        kilimanjaroMenuItem.setMnemonic(KeyEvent.VK_K);
        kilimanjaroMenuItem.setAccelerator(KeyStroke.getKeyStroke('K',
                InputEvent.SHIFT_DOWN_MASK | InputEvent.CTRL_DOWN_MASK)); // we can force the modifiers this way

        // Now we add the JMenuItems to a JMenu...
        JMenu akinoMenu = new JMenu("Akino Items");
        akinoMenu.setMnemonic(KeyEvent.VK_I); // This auto-creates the alt-I shortcut
        akinoMenu.setDisplayedMnemonicIndex(6);
        akinoMenu.add(abubillaMenuItem);
        akinoMenu.add(kilimanjaroMenuItem);

        // Let's make another menu
        JMenuItem docMenuItem = new JMenuItem("Documentation");
        //docMenuItem.setMnemonic(KeyEvent.VK_F1);
        docMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        docMenuItem.addActionListener(e -> System.out.println("Help!!"));
        JMenuItem aboutMenuItem = new JMenuItem("About");
        JMenuItem upgradeMenuItem = new JMenuItem("Look for Upgrades");

        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        helpMenu.add(docMenuItem);
        helpMenu.add(aboutMenuItem);
        helpMenu.addSeparator(); // Separator between help and look for upgrades
        helpMenu.add(upgradeMenuItem);

        // Now, the menu needs a JMenuBar to live within
        JMenuBar akinoMenuBar = new JMenuBar();
        akinoMenuBar.add(akinoMenu);
        //akinoMenuBar.add(helpMenu); // We can add menus to the menu bar or....
        akinoMenu.add(helpMenu); // we can nest menus in menus


        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 8));
        mainPanel.add(new JLabel("Hello, Akino!!"));
        // We could add the menu to the main component of the frame...
        //mainPanel.add(akinoMenuBar); // But this adds the menu to mainPanel, not to the application

        JFrame frame = new JFrame("Akino Menus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(mainPanel);
        frame.setJMenuBar(akinoMenuBar); // The menu belongs to the window frame, not to the internal components.
        frame.setSize(240, 240);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

    }
}
