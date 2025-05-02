package org.example;
import java.awt.*;
import javax.swing.*;
public class DemoSwing extends JFrame {
    public static void main(String []args){
        DemoSwing f= new DemoSwing();
        f.setTitle("Chao ban!");
        f.setBounds(200, 500, 700, 700);
        f.setLayout(new FlowLayout());
        f.add(new JButton("OK"));
        f.add(new JButton("Cancel"));

        f.add(new JLabel("Day la Label"));
        f.add(new JTextField("Nhap vao day: "));
        f.add(new JTextArea(5,30));

        f.add(new Checkbox("Sports"));
        f.add(new Checkbox("Music"));
        f.add(new Checkbox("Travel"));

        CheckboxGroup cg= new CheckboxGroup();
        f.add(new Checkbox("Female", cg, true));
        f.add(new Checkbox("Male", cg, true));

        Choice ch=new Choice();
        ch.addItem("Sports");
        ch.addItem("Music");
        ch.addItem("Travel");
        f.add(ch);

        List list= new List(3,false);
        list.add("Music");
        list.add("Travel");
        list.add("Game");
        f.add(list);
        f.setVisible(true);




    }
}
