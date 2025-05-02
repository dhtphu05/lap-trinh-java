package BaiThucHanhSo2;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import javax.swing.*;
public class Bai8 extends Frame implements KeyListener {
    JLabel lbDisplay;
    public Bai8(){
        setTitle("Key Event Test");
        setSize(350, 300);
        setLayout(new FlowLayout());
        lbDisplay = new JLabel("");
//        lbDisplay.setAlignment(Label.CENTER);
        add(lbDisplay);
        addKeyListener(this);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void keyPressed(KeyEvent e) {
        // Do nothing
    }
    public void keyReleased(KeyEvent e) {
        // Do nothing
    }
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() != KeyEvent.VK_SHIFT && e.getKeyCode() != KeyEvent.VK_ENTER &&
                e.getKeyCode() != KeyEvent.VK_CONTROL) {
            char c = e.getKeyChar();
            lbDisplay.setText(String.valueOf(c));
        }
    }
    public static void main(String[] args) {
        new Bai8();
    }

}
