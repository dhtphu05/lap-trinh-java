package BaiThucHanhSo2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Bai4 extends JFrame {
    JLabel lbEnterString, lbToUpper, lbToLower, lbToLowerUpper, lbLength;
    JTextField txtEnterString, txtToUpper, txtToLower, txtToLowerUpper, txtLength;
    JButton btnOk, btnReset, btnExit;
    JPanel panelAll, panelAnswer, panelButton;
    public Bai4() {
        setTitle("Xử lý chuỗi");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelAll = new JPanel(new BorderLayout());
        panelAnswer = new JPanel(new GridLayout(5, 2));
        panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 10));


        setContentPane(panelAll);




        lbEnterString = new JLabel("Nhập chuỗi: ");
        txtEnterString = new JTextField(20);
        lbToUpper = new JLabel("Chữ hoa: ");
        txtToUpper = new JTextField(20);
        lbToLower = new JLabel("Chữ thường: ");
        txtToLower = new JTextField(20);
        lbToLowerUpper = new JLabel("Chữ hoa và thường: ");
        txtToLowerUpper = new JTextField(20);
        lbLength = new JLabel("Độ dài: ");
        txtLength = new JTextField(20);

        btnOk = new JButton("OK");
        btnReset = new JButton("Reset");
        btnExit = new JButton("Thoát");

        panelAnswer.add(lbEnterString);
        panelAnswer.add(txtEnterString);
        panelAnswer.add(lbToUpper);
        panelAnswer.add(txtToUpper);
        panelAnswer.add(lbToLower);
        panelAnswer.add(txtToLower);
        panelAnswer.add(lbToLowerUpper);
        panelAnswer.add(txtToLowerUpper);
        panelAnswer.add(lbLength);
        panelAnswer.add(txtLength);

        panelButton.add(btnOk);
        panelButton.add(btnReset);
        panelButton.add(btnExit);

        txtToUpper.setEditable(false);
        txtToLower.setEditable(false);
        txtToLowerUpper.setEditable(false);
//        txtLength.setEditable(false);

        panelAll.add(panelAnswer, BorderLayout.CENTER);
        panelAll.add(panelButton, BorderLayout.SOUTH);


        btnOk.addActionListener(e -> processString());
        btnReset.addActionListener(e -> resetFields());
        btnExit.addActionListener(e -> System.exit(0));
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

                                                                     }
    public void processString() {
        String input = txtEnterString.getText();
        txtToUpper.setText(input.toUpperCase());
        txtToLower.setText(input.toLowerCase());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            if(Character.isUpperCase(input.charAt(i))){
                sb.append(Character.toLowerCase(input.charAt(i)));
            } else {
                sb.append(Character.toUpperCase(input.charAt(i)));
            }
        }
        txtToLowerUpper.setText(sb.toString());
        txtLength.setText(String.valueOf(input.length()));
    }
    public void resetFields() {
        txtEnterString.setText("");
        txtToUpper.setText("");
        txtToLower.setText("");
        txtToLowerUpper.setText("");
        txtLength.setText("");
    }
    public static void main(String[] args) {
        new Bai4();

    }



}
