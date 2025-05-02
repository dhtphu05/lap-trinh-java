package BaiThucHanhSo2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Bai7 extends Frame {
    JCheckBox maleCheck, femaleCheck;
    JComboBox<String> osComboBox;
    List animalList;
    JPanel panelAllInput, panelDisplay, panelCheckBox, panelComboBox, panelList;
    JLabel lbDisplay;
    public Bai7(){
        setTitle("Item Event Test");
        setSize(500, 400);
        setLayout(new GridLayout(2, 1));


        maleCheck = new JCheckBox("Male", false);
        femaleCheck= new JCheckBox("Female", false);


        JComboBox<String> osComboBox = new JComboBox<>();
        osComboBox.addItem("Windows");
        osComboBox.addItem("Linux");
        osComboBox.addItem("Mac OS");

        animalList = new List();
        animalList.add("Tiger");
        animalList.add("Lion");
        animalList.add("Elephant");
        animalList.add("Cat");
        animalList.add("Dog");
        animalList.add("Mouse");

        lbDisplay = new JLabel("The event is displayed here");

        panelCheckBox= new JPanel(new FlowLayout());
        panelCheckBox.add(maleCheck);
        panelCheckBox.add(femaleCheck);
        panelComboBox = new JPanel(new FlowLayout());
        panelComboBox.add(osComboBox);
        panelList = new JPanel(new FlowLayout());
        panelList.add(animalList);
        panelAllInput = new JPanel(new GridLayout(1, 3));
        panelAllInput.add(panelCheckBox);
        panelAllInput.add(panelComboBox);
        panelAllInput.add(panelList);

        panelDisplay = new JPanel(new FlowLayout());
        panelDisplay.add(lbDisplay);

        add(panelAllInput);
        add(panelDisplay);

        maleCheck.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String data = "";
                if (e.getStateChange() == 1) {
                    data += "Male";
                    femaleCheck.setSelected(false);
                } else data = "";
                lbDisplay.setText(data );
            }
        });
        femaleCheck.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String data = "";
                if(e.getStateChange()==1){
                    data+="Female";
                    maleCheck.setSelected(false);
                }
                else data="";
                lbDisplay.setText(data);
            }

        });
        osComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                lbDisplay.setText((e.getStateChange() == 1 ? osComboBox.getSelectedItem().toString() : ""));
            }
        });
        animalList.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                lbDisplay.setText(e.getStateChange() == 1 ? animalList.getSelectedItem().toString() : "");
            }
        });
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

    }

    public static void main(String[] args) {
        new Bai7();
    }
}

