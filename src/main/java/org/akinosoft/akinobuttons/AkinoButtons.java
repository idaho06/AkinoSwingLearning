package org.akinosoft.akinobuttons;

import javax.swing.*;
import java.awt.*;

public class AkinoButtons {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(() -> new AkinoButtons().startup());
    }

    public void startup() {
        // first we create the buttons objects and the we add them to the ContentPane
        JButton button01 = new JButton("Button One");
        JButton button02 = new JButton("Button Two");
        JButton button03 = new JButton("Button Three");

        // change font and color
        //button01.setFont(new Font("serif", Font.ITALIC, 24));
        //button01.setForeground(Color.RED);

        // disable button
        //button02.setEnabled(false);

        // set size of the buttons
        //button01.setSize(); // Dont use this
        button01.setPreferredSize(button03.getPreferredSize());
        button02.setPreferredSize(button03.getPreferredSize());
        //button03.setPreferredSize(button01.getPreferredSize());

        // Let's set (Johny) Mnemonics
        button01.setMnemonic('o'); // By default, marks the first occurence of "o", case insensitive
        button01.setDisplayedMnemonicIndex(7); // for setting the underscore in the correct place
        button02.setMnemonic('t');
        button02.setDisplayedMnemonicIndex(7);
        button03.setMnemonic('h');

        JFrame frame = new JFrame("Let's do some buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setDefaultButton(button03); // Sets the button marked by default. Does not work??

        frame.getContentPane().setLayout(new FlowLayout());
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html

        frame.getContentPane().add(button01); // Buttons added to the Content Pane
        frame.getContentPane().add(button02);
        frame.getContentPane().add(button03);


        //frame.setSize(100,100);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}
