/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author dani
 */
public class MainFrame extends JFrame {

    public MainFrame() {
        super();
        this.setTitle("Animal House");
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.add(new JButton());
        
        
        
    }
    
}
