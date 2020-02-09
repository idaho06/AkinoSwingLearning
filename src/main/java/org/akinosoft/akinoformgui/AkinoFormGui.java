package org.akinosoft.akinoformgui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AkinoFormGui extends JFrame {
    private JLabel akinoTitle;
    private JButton sayHelloButton;
    private JLabel ImageCuernos;
    private JPanel mainPanel;

    public AkinoFormGui(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();


        sayHelloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello, Akino!!!");
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new AkinoFormGui("Akino GUI Form");
        frame.setVisible(true);
    }
}
