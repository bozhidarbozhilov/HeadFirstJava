package chapter14;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class FirstAnimation {
    private static final int INITIAL_X = 5;
    private static final int INITIAL_Y = 20;
    private static final int ANIMATION_STEP = 1;
    private int x = INITIAL_X;
    private int y = INITIAL_Y;
    JFrame frame;

    public static void main(String[] args){
        FirstAnimation fa = new FirstAnimation();
        fa.go();
    }
    void go(){
        frame = new JFrame("My First Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AnimationDraw ad = new AnimationDraw();
        frame.getContentPane().add(ad);
        frame.setSize(400,400);
        frame.setVisible(true);
        while(x<=100){
            frame.repaint();
            //ad.repaint();
            x += ANIMATION_STEP;
            y += ANIMATION_STEP;
            try{
                TimeUnit.MILLISECONDS.sleep(50);
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }

    class AnimationDraw extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(0,0, this.getWidth(),this.getHeight());
            g.setColor(Color.BLUE);
            g.fillOval(x,y,30,30);
        }
    }
}
