package BaiThucHanhSo2;
import java.awt.*;
import java.awt.event.ActionListener;

class Bai1 extends Frame implements ActionListener {
   Label lbHeader, lbNhapA, lbNhapB, lbKQ;
   TextField txtNhapA, txtNhapB, txtKQ;
   Button btnGiai, btnXoa, btnThoat;
   Panel pnAll, pnHeader, pnNhap, pnButton;
   public void GUI(){
       lbHeader = new Label("Giải phương trình bậc 1");
       lbNhapA = new Label("Nhập a: ");
       lbNhapB = new Label("Nhập b: ");
       lbKQ = new Label("Kết quả: ");

       txtNhapA= new TextField(10);
       txtNhapB= new TextField(10);
       txtKQ= new TextField(10);
       txtKQ.setEditable(true);

       btnGiai = new Button("Giải");
       btnXoa = new Button("Xóa");
       btnThoat= new Button("Thoát");
       btnGiai.addActionListener(this);
       btnXoa.addActionListener(this);
       btnThoat.addActionListener(this);

       pnAll= new Panel(new GridLayout(3,1));
       pnHeader= new Panel(new FlowLayout(FlowLayout.CENTER));
       pnNhap= new Panel(new GridLayout(3,2));
       pnButton= new Panel(new GridLayout(1,3));
       pnAll.add(pnHeader);
       pnAll.add(pnNhap);
       pnAll.add(pnButton);

       pnHeader.add(lbHeader);
       pnNhap.add(lbNhapA);
       pnNhap.add(txtNhapA);
       pnNhap.add(lbNhapB);
       pnNhap.add(txtNhapB);
       pnNhap.add(lbKQ);
       pnNhap.add(txtKQ);
       pnButton.add(btnGiai);
       pnButton.add(btnXoa);
       pnButton.add(btnThoat);

       add(pnAll);
       setSize(400, 200);
       setTitle("Giải phương trình bậc 1");
       setVisible(true);

   }
   public void actionPerformed(java.awt.event.ActionEvent e) {
       if(e.getSource()==btnGiai){
              double a= Double.parseDouble(txtNhapA.getText());
              double b= Double.parseDouble(txtNhapB.getText());
              if(a==0){
                if(b==0){
                     txtKQ.setText("Phương trình có vô số nghiệm");
                }else{
                     txtKQ.setText("Phương trình vô nghiệm");
                }
              }else{
                double x= -b/a;
                txtKQ.setText(Double.toString(x));
              }
       }
       if(e.getSource()==btnXoa){
              txtNhapA.setText("");
              txtNhapB.setText("");
              txtKQ.setText("");
       }
       if(e.getSource()==btnThoat){
                  System.exit(0);
       }
   }
    public static void main(String[] args) {
         Bai1 gptb1= new Bai1();
         gptb1.GUI();
    }
}
