package BreakoutBall;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

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

    private MapGen map;

    public GamePanel() {
        map = new MapGen(5,5);
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

        //drawing map
        map.draw((Graphics2D)g);

        //borders
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);

        //score 
        g.setColor(Color.red);
        g.setFont(new Font("roman", Font.BOLD, 25));
        g.drawString("Score: " + score, 580, 30);

        //the paddle
        g.setColor(Color.blue);
        g.fillRect(startPlpos, 550, 100, 8);

        //the ball
        g.setColor(Color.white);
        g.fillOval(ballXpos, ballYpos, 20, 20);
        
        if(ballYpos > 570){
            play = false;
            XD = 0;
            YD = 0;
            g.setColor(Color.red);
            g.setFont(new Font("roman", Font.BOLD, 30));
            g.drawString("Game Over, Score: " + score, 190, 300);

            g.setFont(new Font("roman", Font.BOLD, 20));
            g.drawString("Press Enter to Restart", 230, 350);

        }

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

        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if(!play){
                play = true;
                ballXpos = 120;
                ballYpos = 350;
                startPlpos = 310;
                XD = -1;
                YD = -2;
                score = 0;
                totalBricks = 21;
                map = new MapGen(5,5);

                repaint();
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
            A: for(int i = 0; i < map.map.length; i++){
                for(int j = 0; j < map.map[0].length; j++)
                if(map.map[i][j] > 0 ){
                    int brickX = j * map.brickWidth + 80;
                    int brickY = i * map.brickHeight + 50;
                    int brickWidth = map.brickWidth;
                    int brickHeight = map.brickHeight;

                    Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                    Rectangle ballRect = new Rectangle(ballXpos, ballYpos, 20, 20);
                    Rectangle brickRect = rect; 

                    if(ballRect.intersects(brickRect)){
                        map.setBrickValue(0, i, j);
                        totalBricks--;
                        score += 5;

                        if(ballXpos + 19 <= brickRect.x || ballXpos + 1 >= brickRect.x + brickRect.width){
                            XD = -XD;
                        }else{
                            YD = -YD;
                        }
                        break A;
                    } 
                }

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
    
