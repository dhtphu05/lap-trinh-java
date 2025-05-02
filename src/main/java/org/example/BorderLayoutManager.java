package org.example;
import java.awt.*;
import javax.swing.*;
import java.applet.*;
public class BorderLayoutManager extends Applet {
    public void init(){
        JTextField msg= new JTextField("Hien thi thong bao");
        msg.setEditable(false);
        JButton nutVe= new JButton("Ve");
        Canvas vungVe= new Canvas();
        vungVe.setSize(150,150);
        vungVe.setBackground(Color.WHITE);
        Scrollbar sb1= new Scrollbar(Scrollbar.VERTICAL, 0,10,30,100);
        Scrollbar sb2= new Scrollbar(Scrollbar.VERTICAL, 0,10,30,100);
        setLayout(new BorderLayout());
        add(nutVe, BorderLayout.NORTH);
        add(msg,BorderLayout.SOUTH);
        add(vungVe, BorderLayout.CENTER);
        add(sb1, BorderLayout.WEST);
        add(sb2, BorderLayout.EAST);


    }
    public static void main(String []args){
        BorderLayoutManager b= new BorderLayoutManager();
        b.init();
    }
}
