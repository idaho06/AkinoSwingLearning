package org.akinosoft.akinocheckbox;

import org.akinosoft.ballicon.BallIcon;

import javax.swing.*;
import java.awt.*;

public class AkinoCheckBox {

    JCheckBox option1 = new JCheckBox("Bitches go around"); // as this buttons are used in several methods
    JCheckBox option2 = new JCheckBox("Aer!");              // they have to be declared as class members
    JCheckBox option3 = new JCheckBox("Ear!");
    JCheckBox option4 = new JCheckBox("Ouros...");
    JCheckBox option5 = new JCheckBox("Fallen from Kalimanjaro");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new AkinoCheckBox().startup();
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


    public void startup() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Let Swing decide LookAndFeel

        // Aer and Ear go together always
        option3.setModel(option2.getModel());

        // Customize checkbox
        option5.setIcon(new BallIcon(15, Color.LIGHT_GRAY));
        option5.setSelectedIcon(new BallIcon(15, Color.GREEN));

        JLabel header = new JLabel("Akino options");

        JButton goButton = new JButton("Place order");
        goButton.addActionListener(e -> placeOrder());

        JFrame frame = new JFrame("Check Boxes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));

        frame.getContentPane().add(header);
        frame.getContentPane().add(option1);
        frame.getContentPane().add(option2);
        frame.getContentPane().add(option3);
        frame.getContentPane().add(option4);
        frame.getContentPane().add(option5);
        frame.getContentPane().add(goButton);

        frame.setSize(240, 120);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private void placeOrder() {
        StringBuilder sb = new StringBuilder();
        if (option1.isSelected()) {
            sb.append("Bitches");
        }
        if (option2.isSelected()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("Aer");
        }
        if (option3.isSelected()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("Ear");
        }
        if (option4.isSelected()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("Ouros");
        }
        if (option5.isSelected()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("Kilimanjaro");
        }

        System.out.println("Order options: " + sb);
    }
}
