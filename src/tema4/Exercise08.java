/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dani
 */
public class Exercise08 {

    public static void main(String[] args) {

        JFrame frame = new MainFrame08();
    }
}

class MainFrame08 extends JFrame {

    public MainFrame08() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setTitle("Mouse me!");
        setSize(screenSize);
        this.getContentPane().add(new MouserPanel());
        this.addWindowListener(new Closer08());
        setVisible(true);
    }
}

class Closer08 extends WindowAdapter {

    public void WindowClosing(WindowEvent we) {
        System.exit(0);
    }

}

class MouserPanel extends JPanel implements MouseMotionListener {

    JPanel x, y;
    JLabel xLabel, yLabel;

    public MouserPanel() {
        this.addMouseMotionListener(this);
        x = new JPanel();
        x.setSize(200, 50);
        x.setLocation(10, 10);
        xLabel = new JLabel("X: 0");
        x.add(xLabel);
        this.add(x);
        y = new JPanel();
        yLabel = new JLabel("Y: 0");
        y.add(yLabel);
        y.setSize(200, 50);
        y.setLocation(10, 70);
        this.add(y);
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        event.getLocationOnScreen();
        update(event.getX(), event.getY());

    }

    @Override
    public void mouseDragged(MouseEvent event) {

    }

    public void update(int x, int y) {
        this.xLabel.setText("X: " + x);
        this.yLabel.setText("Y: " + y);
    }
}
