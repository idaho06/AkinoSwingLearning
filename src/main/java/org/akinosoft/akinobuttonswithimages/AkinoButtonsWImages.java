package org.akinosoft.akinobuttonswithimages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AkinoButtonsWImages {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(() -> new AkinoButtonsWImages().startup());
    }

    public void startup() {

        // button creation
        JButton buttonCopy = new JButton("Copy", new ImageIcon(ClassLoader.getSystemResource("copy-24.png")));
        JButton buttonCut = new JButton("Cut", new ImageIcon(ClassLoader.getSystemResource("cut-24.png")));
        // text is optional
        //JButton buttonPaste = new JButton("Paste", new ImageIcon(ClassLoader.getSystemResource("paste-24.png")));
        JButton buttonPaste = new JButton(new ImageIcon(ClassLoader.getSystemResource("paste-24.png")));
        // by default, text go right to the image in the button, Lets put the text down in all buttons
        buttonCopy.setHorizontalTextPosition(JButton.CENTER);
        buttonCopy.setVerticalTextPosition(JButton.BOTTOM);
        buttonCut.setHorizontalTextPosition(JButton.CENTER);
        buttonCut.setVerticalTextPosition(JButton.BOTTOM);
        buttonPaste.setHorizontalTextPosition(JButton.CENTER);
        buttonPaste.setVerticalTextPosition(JButton.BOTTOM);
        // Now we want to disable Focus indication on the Copy button
        buttonCopy.setFocusPainted(false);
        // and add a tooltip for clarity in the Paste Button
        buttonPaste.setToolTipText("This is for paste stuff, DUH!");

        // Another way to configure a button is using java.awt.event.ActionEvent
        JButton buttonBeep = new JButton(new BeepAction());

        JFrame frame = new JFrame("Let's do some buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(new FlowLayout());

        // Now we add the buttons to the Content Pane of the frame
        frame.getContentPane().add(buttonCopy);
        frame.getContentPane().add(buttonCut);
        frame.getContentPane().add(buttonPaste);
        frame.getContentPane().add(buttonBeep);

        //frame.setSize(100,100);
        frame.pack(); // Smaller size possible
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    // This class does not have to be inner to AkinoButtonsWImages
    static class BeepAction extends AbstractAction {
        private static final long serialVersionUID = 1L; // "be polite", we should declare this

        public BeepAction() {  // constructor
            putValue(NAME, "Beep");
            //putValue(MNEMONIC_KEY, 'b'); // Dont do this!!!
            putValue(MNEMONIC_KEY, KeyEvent.VK_B);
            //putValue(DISPLAYED_MNEMONIC_INDEX_KEY, 0);
            putValue(SMALL_ICON, new ImageIcon(ClassLoader.getSystemResource("speaker-24.png")));
            putValue(LARGE_ICON_KEY, new ImageIcon(ClassLoader.getSystemResource("speaker-48.png")));
            putValue(SHORT_DESCRIPTION, "Beep");
            putValue(LONG_DESCRIPTION, "This action produces a sound.");
            //putValue(ACTION_COMMAND_KEY, something);

        }

        @Override
        public void actionPerformed(ActionEvent e) { // AbstractAction override, needed.
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
