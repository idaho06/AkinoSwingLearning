package org.akinosoft.akinolooks;

import javax.swing.*;
import java.awt.*;

public class AkinoLooks {


    // function that creates the window (JFrame) and populates it with swing widgets
    public void startup()
    // "setLookAndFeel" returns exceptions, so we have to declare it for return
            throws
            ClassNotFoundException,
            UnsupportedLookAndFeelException,
            InstantiationException,
            IllegalAccessException {

        // using the strings returned by "getInstalledLookAndFeels()", we tell swing to use a skin
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Let Swing decide LookAndFeel

        // Tabs
        JTabbedPane tabp = new JTabbedPane();
        tabp.add("One", new JTextField("Once", 16));
        tabp.add("Two", new JTextField("Twice", 16));

        // Combo
        JComboBox<String> combo = new JComboBox<String>(new String[]{"one", "two", "three"});

        // Button
        JButton button = new JButton("do it!");

        JScrollPane scroll = new JScrollPane(new JTextArea(UIManager.getLookAndFeel().toString(), 3, 16));

        JSlider slider = new JSlider();

        JLabel greeting = new JLabel("Hello, Akino!!!", JLabel.CENTER);
        greeting.setFont(new Font("serif", Font.PLAIN, 32));
        greeting.setForeground(Color.red);

        JFrame frame = new JFrame("AkinoLook: " + UIManager.getLookAndFeel().getName().toString());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));
        frame.getContentPane().add(tabp);
        frame.getContentPane().add(combo);
        frame.getContentPane().add(button);
        frame.getContentPane().add(scroll);
        frame.getContentPane().add(slider);
        frame.setSize(240, 300);
        frame.setVisible(true);
    }

    /* Program start */
    public static void main(String[] args) {
        // First, we list the available Looks
        for (UIManager.LookAndFeelInfo lafi : UIManager.getInstalledLookAndFeels()) {
            System.out.println(lafi);
        }

        // now we call the window in a safe way
        // even if we are invoking the window AFTER the loop for printing available looks,
        // The window appear BEFORE the printings!!!!!

        SwingUtilities.invokeLater(
                // lambda function. jdk 8 or higher
                // We create a nameless function and pass it to "invokeLater"
                () -> {
                    // as "AkinoLooks().startup()" can return exceptions, we MUST catch them
                    try {
                        new AkinoLooks().startup();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (UnsupportedLookAndFeelException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

    }
}
