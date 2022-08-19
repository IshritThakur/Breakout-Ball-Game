package BreakoutBall;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Breakout Ball");
        GamePanel GamePanel = new GamePanel();
        frame.setBounds (10, 10, 700, 600);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(GamePanel);
    }
    
}
