import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class MovingBall extends JPanel implements ActionListener{

    /*
     * Location coordinates
     */
    int x,y;

    /*
     * direction for ball to move
     */
    int xd = 4;
    int yd = 3;
    Timer t;

    public MovingBall(){
        t = new Timer(1,this);
        t.start();

        x=20;
        y=50;
        
    }
    public static void main (String[] args){
        JFrame frame = new JFrame("Moving Ball");
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MovingBall());
    }

    public void paint(Graphics g){
        super.paint(g);
        g.fillOval(x, y, 20, 20);

    }
    public void move(){
        x += xd;
        y += yd;

        if(x <= 0){
            xd = (-1)*xd;
        }
        if(x>=380){
            xd = (-1)*xd;
        }
        if(y<=0){
            yd = (-1)*yd;
        }
        if(y>=380){
            yd = (-1)*yd;
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        * TODO Auto-generated method stub
        */
        
        move();

        repaint();
        
    }
}