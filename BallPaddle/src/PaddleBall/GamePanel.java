package PaddleBall;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.Rectangle;




public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private boolean play = false;
    private int score = 0;

    private int totalBricks = 21;

    private Timer timer; 
    private int delay = 8;


    private int startPlpos = 310;
     
    private int ballXpos = 120;
    private int ballYpos = 550;

    private int XD = -1;
    private int YD = -2;

    public GamePanel() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g){
        //background
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);

        //borders
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);

        //the paddle
        g.setColor(Color.blue);
        g.fillRect(startPlpos, 550, 100, 8);

        //the ball
        g.setColor(Color.white);
        g.fillOval(ballXpos, ballYpos, 20, 20);

        g.dispose();
    
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(startPlpos >= 600){
                startPlpos = 600;
            }else{
                moveRight();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(startPlpos < 10){
                startPlpos = 10;
            }else{
                moveLeft();
            }
        }


    }

    public void moveRight(){
        play = true;
        startPlpos += 20;
    }

    public void moveLeft(){
        play = true;
        startPlpos -= 20;
    }



    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
        timer.start();
        if(play){

            if(new Rectangle(ballXpos, ballYpos, 20, 20).intersects(new Rectangle(startPlpos, 550, 100, 8))){
                YD = -YD;
            }

            ballXpos += XD;
            ballYpos += YD;
            if(ballXpos < 0){
                XD = -XD;
            }
            if(ballYpos < 0){
                YD = -YD;
            }
            if(ballXpos > 670){
                XD = -XD;
            } 
        }


        repaint();
    }

    
}
    
