/*
 * Second Class To create a window titled "Hello World" 
 * 
 * Create an Instance variable JFrame, 
 * JFrame is the top level container or tyhe window in javaSwing
 * 
 */
package javacodejunkie.com.codejunkie;

import javax.swing.JFrame;

public class MainWindow {

    private JFrame window;

    public MainWindow(){
       
        window = new JFrame();
        window.setTitle("Hello World");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(600 , 500);
        window.setLocationRelativeTo(null);

    }

    public void show(){
        window.setVisible(true);

    }
    
}
