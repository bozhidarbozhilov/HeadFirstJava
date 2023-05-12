package chapter14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui3 implements ActionListener {
    private JFrame frame;
    private JButton colorButton;
    private JButton labelButton;
    private JLabel label;
    public static void main(String[] args){
        SimpleGui3 gui = new SimpleGui3();
        gui.go();
    }

    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colorButton = new JButton("Change colors");
        labelButton = new JButton("Change label");
        label = new JLabel("I'm a label");

        colorButton.addActionListener(this);
        labelButton.addActionListener(this);
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == colorButton){
            frame.repaint();
        }else {
            if(label.getText() == "That hurt!"){
                label.setText("I'm a label");
            }else {
                label.setText("That hurt!");
            }
        }
    }
}
