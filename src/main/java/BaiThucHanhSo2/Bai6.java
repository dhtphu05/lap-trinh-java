package BaiThucHanhSo2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Bai6 extends Frame implements ActionListener{
    JButton btnOk;
    JTextField txtString;
    List animalList;
    JPanel panelAllInput, panelButton, panelString, panelList;
    JLabel lbDisplay;

    public Bai6(){
        setTitle("Action Event Test");
        setSize(500, 400);
        setLayout(new GridLayout(2, 1));

        btnOk = new JButton("OK");
        btnOk.addActionListener(this);

        txtString = new JTextField(10);
        txtString.addActionListener(this);

        animalList = new List();
        animalList.add("Tiger");
        animalList.add("Lion");
        animalList.add("Elephant");
        animalList.add("Cat");
        animalList.add("Dog");
        animalList.add("Mouse");
        animalList.addActionListener(this);


        panelButton = new JPanel(new FlowLayout());
        panelButton.add(btnOk);

        panelString = new JPanel(new FlowLayout());
        panelString.add(txtString);

        panelList = new JPanel(new FlowLayout());
        panelList.add(animalList);

        lbDisplay = new JLabel("The event is displayed here");
        lbDisplay.setHorizontalAlignment(JLabel.CENTER);

        panelAllInput= new JPanel(new GridLayout(1, 3));
        panelAllInput.add(panelButton);
        panelAllInput.add(panelString);
        panelAllInput.add(panelList);
        add(panelAllInput);
        add(lbDisplay);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if(e.getSource() == btnOk){
            lbDisplay.setText("Button is clicked");
        }
        if(e.getSource() == txtString){
            lbDisplay.setText("TextField is written: " + txtString.getText());
        }
        if(e.getSource() == animalList){
            lbDisplay.setText("List is selected:  " + animalList.getSelectedItem());
        }
        //
    }
    public static void main(String[] args) {
         new Bai6();

    }

}
