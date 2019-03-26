/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

import java.awt.BorderLayout;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author dani
 */
public class Exercise09 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.getContentPane().add(new MyScrollPanel(new JTextField("Scroll to see")));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
}
class MyScrollPanel extends JPanel {
    JTextField textField;
    JScrollBar verticalBar;
    
        public MyScrollPanel(JTextField textField) {
            this.textField = textField;
            this.setLayout(new BorderLayout(5,5));
                    
            this.add(this.textField, BorderLayout.CENTER);
            this.verticalBar = new JScrollBar();
            this.add(this.verticalBar, BorderLayout.EAST);
            verticalBar.setMaximum(1000);
            verticalBar.setMinimum(0);
            verticalBar.setValue(500);        
            // Handle events
            Handler handler = new Handler(this.verticalBar, this.textField);
            verticalBar.addAdjustmentListener(handler);
            this.textField.addActionListener(handler);
            
        }
    }


class Handler implements AdjustmentListener, ActionListener {
    JScrollBar bar;
    JTextField field;
    
    public Handler(JScrollBar bar, JTextField field) {
        this.bar = bar;
        this.field = field;
    }
    
    
    
    @Override
    public void adjustmentValueChanged(AdjustmentEvent ae) {
        this.bar.setValue(ae.getValue());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}