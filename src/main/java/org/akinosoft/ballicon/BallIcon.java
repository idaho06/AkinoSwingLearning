package org.akinosoft.ballicon;

import javax.swing.*;
import java.awt.*;

public class BallIcon implements Icon {

    private int sizex;
    private int sizey;
    private Color[] colors = new Color[2];
    private float fractions[] = {0, 1};

    public BallIcon(int sizex, int sizey, Color color) {
        this.sizex = sizex;
        this.sizey = sizey;
        this.colors[0] = color;
        this.colors[1] = color.darker().darker();
    }

    public BallIcon(int size, Color color) {
        this.sizex = size;
        this.sizey = size;
        this.colors[0] = color;
        this.colors[1] = color.darker().darker();
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Color oldColor = g.getColor(); // save old color...

        if (g instanceof Graphics2D) { // If we have fancy graphics...
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int radius = ((sizex + sizey) / 2) / 2;
            RadialGradientPaint rgrad = new RadialGradientPaint(x + radius, y + radius, radius * 3 / 2, fractions, colors);
            ((Graphics2D) g).setPaint(rgrad); // We set fancy gradient
        } else {
            g.setColor(colors[0]); // good old setColor if not
        }
        g.fillOval(x, y, sizex - 1, sizey - 1);
        g.setColor(oldColor);
    }

    @Override
    public int getIconWidth() {
        return sizex;
    }

    @Override
    public int getIconHeight() {
        return sizey;
    }
}
