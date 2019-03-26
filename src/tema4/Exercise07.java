/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author dani
 */
public class Exercise07 {
    
    public static void main(String[] args) {
        JFrame main;
        
        main = new MainFrame();
        main.addWindowListener(new Trigger());
        System.out.println("point 1");
        
    }
}

class MainFrame extends JFrame {
    
    public MainFrame() {
        setTitle("Main");
        setSize(500, 300);
        setVisible(true);
    }
    
}

class Trigger extends WindowAdapter {
    
    @Override
    public void windowClosing(WindowEvent we) {
        JFrame secondary_1, secondary_2;
        secondary_1 = new SecondaryFrame();
        System.out.println("point 2");
        secondary_2 = new SecondaryFrame();
        System.out.println("point 3");
        
    }
}

class SecondaryFrame extends JFrame {

    static int n_secondaries = 0;
    
    public SecondaryFrame() {
        n_secondaries++;
        setTitle("Secondary");
        setSize(500, 300);
        setLocation((int) (Math.random() * 1900), (int) (Math.random() * 1000));
        this.addWindowListener(new Closer());
        setVisible(true);
    }
    
    public static int minusOne() {
        n_secondaries--;
        return n_secondaries;
    }
}

class Closer extends WindowAdapter {
    
    @Override
    public void windowClosing(WindowEvent we) {
        int n_secs = SecondaryFrame.minusOne();
        if (n_secs == 0) {
            System.exit(0);
        }
        
    }
}
