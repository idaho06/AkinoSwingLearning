package org.akinosoft.akinohello;

import javax.swing.*;
import java.awt.*;

public class HelloAkino {
    public static void main(String[] args)
            throws ClassNotFoundException,
            UnsupportedLookAndFeelException,
            InstantiationException,
            IllegalAccessException {

        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        SwingUtilities.invokeLater(() -> new HelloAkino().startup());
    }

    public void startup() {
        JLabel greeting = new JLabel("Hello, Akino!!!", JLabel.CENTER);
        greeting.setFont(new Font("serif", Font.PLAIN, 32));
        greeting.setForeground(Color.red);

        JFrame frame = new JFrame("AkinoFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(greeting);
        frame.setSize(320, 240);
        frame.setVisible(true);
    }
}


