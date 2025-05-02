package BaiThucHanhSo2;
import java.awt.*;
import java.awt.event.ActionListener;

class Bai2 extends Frame implements ActionListener {
    Label lbHeader, lbNhap1, lbNhap2, lbKQ;
    TextField txtNhap1, txtNhap2, txtKQ;
    Button btnAdd, btnSub, btnMul, btnDiv, btnXoa, btnThoat;
    Panel pnAll, pnHeader, pnNhap, pnButton, pnReset;
    public void GUI(){
        lbHeader = new Label("Basic Arithmetic Operations");
        lbHeader.setFont(new Font("Arial", Font.BOLD, 20));

        lbNhap1 = new Label("Number 1:");
        lbNhap2 = new Label("Number 2: ");
        lbKQ = new Label("Result: ");

        txtNhap1= new TextField(10);
        txtNhap2= new TextField(10);
        txtKQ= new TextField(10);
        txtKQ.setEditable(true);

        txtNhap1.addActionListener(e -> txtNhap2.requestFocusInWindow());


        btnAdd = new Button("Addition");
        btnSub = new Button("Subtraction");
        btnMul = new Button("Multiplication");
        btnDiv = new Button("Division");
        btnXoa = new Button("Reset");
        btnThoat= new Button("Exit");

        btnAdd.setBackground(Color.LIGHT_GRAY);
        btnSub.setBackground(Color.LIGHT_GRAY);
        btnMul.setBackground(Color.LIGHT_GRAY);
        btnDiv.setBackground(Color.LIGHT_GRAY);
        btnXoa.setBackground(Color.LIGHT_GRAY);
        btnThoat.setBackground(Color.LIGHT_GRAY);

        btnAdd.setFont(new Font("Arial", Font.BOLD, 14));
        btnSub.setFont(new Font("Arial", Font.BOLD, 14));
        btnMul.setFont(new Font("Arial", Font.BOLD, 14));
        btnDiv.setFont(new Font("Arial", Font.BOLD, 14));
        btnXoa.setFont(new Font("Arial", Font.BOLD, 14));
        btnThoat.setFont(new Font("Arial", Font.BOLD, 14));


        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);

        btnXoa.addActionListener(this);
        btnThoat.addActionListener(this);

        pnAll= new Panel(new GridLayout(4,1));
        pnHeader= new Panel(new FlowLayout(FlowLayout.CENTER));
        pnNhap= new Panel(new GridLayout(3,2));
        pnButton= new Panel(new FlowLayout(FlowLayout.CENTER));
        pnReset= new Panel(new FlowLayout(FlowLayout.CENTER));

        pnAll.add(pnHeader);
        pnAll.add(pnNhap);
        pnAll.add(pnButton);
        pnAll.add(pnReset);

        pnHeader.add(lbHeader);
        pnNhap.add(lbNhap1);
        pnNhap.add(txtNhap1);
        pnNhap.add(lbNhap2);
        pnNhap.add(txtNhap2);
        pnNhap.add(lbKQ);
        pnNhap.add(txtKQ);

        pnButton.add(btnAdd);
        pnButton.add(btnSub);
        pnButton.add(btnMul);
        pnButton.add(btnDiv);

        pnReset.add(btnXoa);
        pnReset.add(btnThoat);

        add(pnAll);
        setSize(600, 400);
        setTitle("Arithmetic Operations");
        setVisible(true);

    }
    public void actionPerformed(java.awt.event.ActionEvent e) {

        if(e.getSource()==btnAdd){
            double a= Double.parseDouble(txtNhap1.getText());
            double b= Double.parseDouble(txtNhap2.getText());
            double c= a+b;
            if(c == (int)c){
                txtKQ.setText(Integer.toString((int)c));
            }else
                txtKQ.setText(Double.toString(c));
        }
        if(e.getSource()==btnSub){
            double a= Double.parseDouble(txtNhap1.getText());
            double b= Double.parseDouble(txtNhap2.getText());
            double c= a-b;
            if(c == (int)c){
                txtKQ.setText(Integer.toString((int)c));
            }else
                txtKQ.setText(Double.toString(c));
        }
        if(e.getSource()==btnMul){
            double a= Double.parseDouble(txtNhap1.getText());
            double b= Double.parseDouble(txtNhap2.getText());
            double c= a*b;
            if(c == (int)c){
                txtKQ.setText(Integer.toString((int)c));
            }else
                txtKQ.setText(Double.toString(c));
        }
        if(e.getSource()==btnDiv){
            double a= Double.parseDouble(txtNhap1.getText());
            double b= Double.parseDouble(txtNhap2.getText());
            if(b==0){
                txtKQ.setText("Cannot divide by zero");
            }else{
                double c= a/b;
                if(c == (int)c){
                    txtKQ.setText(Integer.toString((int)c));
                }else
                    txtKQ.setText(Double.toString(c));
            }
        }
        if(e.getSource()==btnXoa){
            txtNhap1.setText("");
            txtNhap2.setText("");
            txtKQ.setText("");
        }
        if(e.getSource()==btnThoat){
            System.exit(0);
        }

    }
    public static void main(String[] args) {
        Bai2 cptsh= new Bai2();
        cptsh.GUI();
    }
}
