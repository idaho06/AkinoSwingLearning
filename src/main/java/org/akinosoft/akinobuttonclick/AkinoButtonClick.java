package org.akinosoft.akinobuttonclick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.ExecutionException;

public class AkinoButtonClick {

    // We need statusLAbel to be available to the methods
    private JLabel statusLabel = new JLabel(" status ", JLabel.CENTER);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AkinoButtonClick().startup());
    }

    public void startup() {
        //JLabel statusLabel = new JLabel(" status ", JLabel.CENTER);
        // As we need the methods of the class to change statusLabel, it has to be declared outside.
        statusLabel.setFont(new Font("sansseriff", Font.PLAIN, 18));
        statusLabel.setBorder(BorderFactory.createEtchedBorder());
        statusLabel.setPreferredSize(statusLabel.getPreferredSize());

        JButton buttonA = new JButton("Change color");
        buttonA.addActionListener(e -> System.out.println(e));
        buttonA.addActionListener(e -> handleB1(e));
        buttonA.addActionListener(e -> System.out.println("3rd Listerner, may be executed first"));

        JButton buttonB = new JButton("Calculate...");
        //buttonB.addActionListener( e -> statusLabel.setForeground(Color.RED));
        buttonB.addActionListener(e -> handleB(e));


        JFrame frame = new JFrame("Clicking buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        frame.getContentPane().add(buttonA);
        frame.getContentPane().add(statusLabel);
        frame.getContentPane().add(buttonB);

        frame.setSize(240, 120);
        //framme.pack()
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    // This method is called by buttonB.addActionListener( e -> handleB(e) );
    public void handleB1(ActionEvent e) {
        // Let's detect modifiers (click+Ctrl and so on)
        //System.out.println(e.getModifiers() & ActionEvent.CTRL_MASK);
        //System.out.println(ActionEvent.CTRL_MASK);
        if ((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {
            // getModifiers returns a bit mask. We apply an AND function with CTRL_MASK and check if result is that mask
            System.out.println("Black");
            statusLabel.setForeground(Color.black);
        } else {
            System.out.println("Red");
            statusLabel.setForeground(Color.RED);
        }
    }

    public void handleB(ActionEvent e) {
        statusLabel.setText("..."); // We are about to think something big
        //int result = fakeNumberCrunch(); // BAD!!! Any call should LOCK UP the EDT like this
        //statusLabel.setText(String.valueOf(result));

        //Instead, we create a SwingWorker
        new SwingWorker<Integer, Void>() {
            @Override
            protected Integer doInBackground() throws Exception {
                // Will be called by another thread, not the main EDT, so the application is protected from blocking
                return fakeNumberCrunch();
            }

            @Override
            protected void done() {
                // Will be called on the EDT again
                Integer result = null;
                try {
                    result = get(); //<-- MUST be in try-catch.
                    statusLabel.setText(String.valueOf(result)); // Now, finally, we have the result
                } catch (InterruptedException ex) {
                    // ex.printStackTrace(); // no need to print... maybe to debug?
                    Thread.currentThread().interrupt();
                } catch (ExecutionException ex) {
                    ex.printStackTrace();
                    throw new RuntimeException(ex.getCause()); //<-- Ooops, something went wrong
                }

                super.done();
            }

        }.execute(); // <-- execute() runs the SwingWorker inmediatly

    }

    public int fakeNumberCrunch() {
        // Sleep for 5 seconds to simulate a lengthy computation
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
        return 42; // Meaning of life, universe, and everything
    }
}
