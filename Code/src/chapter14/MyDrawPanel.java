package chapter14;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Random rnd = new Random();
        int red = rnd.nextInt(256);
        int green = rnd.nextInt(256);
        int blue = rnd.nextInt(256);
        Color startColor = new Color(red, green, blue);

        red = rnd.nextInt(256);
        green = rnd.nextInt(256);
        blue = rnd.nextInt(256);
        Color endColor = new Color(red, green, blue);

        GradientPaint gp = new GradientPaint(70, 70, startColor,150, 150, endColor);
        g2d.setPaint(gp);

        g2d.fillOval(70,70, 100, 100);
    }
}
