package org.akinosoft.akinoimages;

import org.akinosoft.ballicon.BallIcon;

import javax.swing.*;
import java.awt.*;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AkinoImages {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AkinoImages().startup());
    }


    public void startup() {

        //Icon icon01 = new ImageIcon("c:/users/d_ida/tmp/cuernos_small.png");
        //Icon icon02 = new ImageIcon("c:/users/d_ida/tmp/cuernos_does not exist.png");
        Icon icon03 = null;

        try {
            icon03 = new ImageIcon(new URL("http://www.lemniscata.com/img_0119.jpg"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        Icon icon04 = new ImageIcon(getImageFromInternetURL());

        //Icon icon05 = new ImageIcon(getClass().getResource("cuernos_small.png"));
        Icon icon05 = new ImageIcon(ClassLoader.getSystemResource("cuernos_small_resource.png"));
        //Icon icon05 = new ImageIcon(ClassLoader.getSystemResource("org/akinosoft/akinoimages/cuernos_small_resource.png"));

        Icon icon06 = new BallIcon(160, Color.RED);


        JLabel greeting = new JLabel("Hello, Akino!!!", icon06, JLabel.CENTER);
        greeting.setFont(new Font("serif", Font.PLAIN, 32));
        greeting.setForeground(Color.BLUE);

        JFrame frame = new JFrame("AkinoFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(greeting);
        frame.setSize(320, 240);
        frame.setVisible(true);
    }

    public URL getImageFromInternetURL() {
        try {
            return new URL("http://www.lemniscata.com/img_0119.jpg");
        } catch (MalformedURLException mue) {
            // re-throw as a RuntimeException
            throw new UncheckedIOException(mue);
        }
    }
}
