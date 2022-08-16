/*
 * First class of the project Swing-01 named Launcher just to start the program
 * 
 * Methods used :
   Invoke Later will ensure that all the swing realted code is executed on the event dispatching thread
 * 
 *  runnable is an interface that contains a single method called run
 * 
 */
package javacodejunkie.com.codejunkie;

import javax.swing.SwingUtilities;

public class Launcher {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MainWindow main = new MainWindow();
                main.show();
        
            }
        });
    }
    
}
