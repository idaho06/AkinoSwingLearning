package org.akinosoft.akinorangecomponents;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.text.ParseException;

public class AkinoSpinSlideReact implements Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new AkinoSpinSlideReact());
    }

    @Override
    public void run() {
        JSlider slide = new JSlider(0, 25, 10);
        slide.setMajorTickSpacing(5);
        slide.setMinorTickSpacing(1);
        slide.setPaintTicks(true);
        slide.setPaintLabels(true);

        JSpinner spin = new JSpinner(new SpinnerNumberModel(10, 0, 25, 1));

        // Let's change the slide when the spin is updated:
        spin.addChangeListener(e -> slide.setValue((Integer) spin.getValue())); // Value of spin needs to be casted
        // and the spin when the slide is updated:
        //slide.addChangeListener( e -> spin.setValue(slide.getValue())); // no need to cast or call utility function
        // Bad thing is that slider fires lots of events... There is another way:
        slide.addChangeListener(e -> {
            if (!slide.getValueIsAdjusting()) {
                spin.setValue(slide.getValue());
            }
        });

        // We have to be careful not creating never ending looping calling actions!!!!!

        JButton button = new JButton("Print");
        button.addActionListener(e -> {
            System.out.println("Slider is: " + slide.getValue());
            System.out.println("Spinner is: " + spin.getValue());
            //int delta = slide.getValue() - spin.getValue(); // This does not compile...
            int delta = slide.getValue() - getSpinnerValue(spin);
            System.out.println("Difference is: " + delta);

            // We are going to wait 2 seconds and get again some values...
            Timer t = new Timer(2000, v -> System.out.println("Now spin is: " + getSpinnerValue(spin)));
            t.setRepeats(false);
            t.start();
        });

        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.add(slide);
        mainPanel.add(spin);
        mainPanel.add(button);

        JFrame frame = new JFrame("Akino-reacting to changes in Spinner and Slider");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.setSize(200, 250);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static int getSpinnerValue(JSpinner spin) {
        // Under certain circumstances, the value of the spin appear changed in the GUI, but it's not updated in the object
        try {
            spin.commitEdit(); // This forces to update the value in the spin before getting it
        } catch (ParseException e) {
            //e.printStackTrace();
            // If the commit returns exception for an invalid value...
            ((ChangeListener) spin.getEditor()).stateChanged(new ChangeEvent(spin)); // This is ugly, but returns it to the last valid value
        }
        Number value = (Number) spin.getValue();
        return value.intValue();
    }
}
