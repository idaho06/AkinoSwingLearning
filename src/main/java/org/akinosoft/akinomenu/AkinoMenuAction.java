package org.akinosoft.akinomenu;

import org.akinosoft.ballicon.BallIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AkinoMenuAction implements Runnable {

    private JLabel greeting = new JLabel("Hello, Akino!");
    private Action redAction = new RedAction();
    private Action blueAction = new BlueAction();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new AkinoMenuAction());
    }

    @Override
    public void run() {
        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        mainPanel.add(greeting);
        mainPanel.add(new JButton(redAction));
        mainPanel.add(new JButton(blueAction));

        JMenu colorMenu = new JMenu("Color");
        colorMenu.add(new JMenuItem(redAction));
        colorMenu.add(new JMenuItem(blueAction));

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(colorMenu);

        JFrame frame = new JFrame("Akino Menu Action");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);

        frame.setJMenuBar(menuBar);

        frame.setSize(240, 240);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }


    // Extending "AbstractAction" is a very convenient way of creating buttons or menu items that performs actions
    // instead of defining listeners and creating methods
    class RedAction extends AbstractAction {
        private static final long serialVersionUID = 1L;

        public RedAction() {
            putValue(NAME, "Red");
            putValue(SMALL_ICON, new BallIcon(10, Color.RED));
            putValue(LARGE_ICON_KEY, new BallIcon(14, Color.RED));
            //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // deprecated
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            greeting.setForeground(Color.RED);
        }
    }

    class BlueAction extends AbstractAction {
        private static final long serialVersionUID = 1L;

        public BlueAction() {
            putValue(NAME, "Blue");
            putValue(SMALL_ICON, new BallIcon(10, Color.BLUE));
            putValue(LARGE_ICON_KEY, new BallIcon(14, Color.BLUE));
            //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_B, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // deprecated
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_B, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            greeting.setForeground(Color.BLUE);
            //redAction.setEnabled(false); you can change actions from actions!!!
        }
    }

}
