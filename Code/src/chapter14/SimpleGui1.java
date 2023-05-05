package chapter14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SimpleGui1 extends JPanel implements ActionListener {
    private JButton btn;
    public static void main(String[] args){
        SimpleGui1 gui = new SimpleGui1();
        gui.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        btn = new JButton("click me");
        btn.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(this);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        btn.setText("I've been clicked");
    }


    @Override
    protected void paintComponent(Graphics g) {
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
