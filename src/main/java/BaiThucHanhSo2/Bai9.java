package BaiThucHanhSo2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Bai9 extends Frame implements MouseListener {
    JFrame mainFrame;

    public Bai9() {
        mainFrame = new JFrame("Mouse Event");
        mainFrame.setSize(300, 250);
        mainFrame.setLayout(new FlowLayout());
        mainFrame.addMouseListener(this);
        mainFrame.setVisible(true);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void mouseExited(MouseEvent e) {
        System.out.println("You exit the window at " + e.getX() + " " + e.getY());
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            System.out.println("You left click the mouse at " + e.getX() + " " + e.getY());
        if (e.getButton() == MouseEvent.BUTTON3)
            System.out.println("You right click the mouse at " + e.getX() + " " + e.getY());
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("You release the mouse at " + e.getX() + " " + e.getY());
    }

    public void mouseEntered(MouseEvent e) {
        System.out.println("You enter the window at " + e.getX() + " " + e.getY());
    }

    public void mousePressed(MouseEvent e) {
        System.out.println("You press the mouse at " + e.getX() + " " + e.getY());
    }

    public static void main(String[] args) {
        new Bai9();
    }

}
