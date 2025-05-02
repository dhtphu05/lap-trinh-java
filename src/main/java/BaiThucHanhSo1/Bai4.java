package BaiThucHanhSo1;
import java.util.Scanner;
public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        double a1,b1,c1,a2,b2,c2;
        System.out.println("Nhập a1: ");
        a1 = scanner.nextDouble();
        System.out.println("Nhập b1: ");
        b1 = scanner.nextDouble();
        System.out.println("Nhập c1: ");
        c1 = scanner.nextDouble();
        System.out.println("Nhập a2: ");
        a2 = scanner.nextDouble();
        System.out.println("Nhập b2: ");
        b2 = scanner.nextDouble();
        System.out.println("Nhập c2: ");
        c2 = scanner.nextDouble();


        //code
        double dinhthuc = a1*b2 - a2*b1;
        double dinhthucx = c1*b2 - c2*b1;
        double dinhthucy = a1*c2 - a2*c1;
        if(dinhthuc == 0){
            if(dinhthucx == dinhthucy && dinhthucy == 0){
                System.out.println("Phuong trinh co vo so nghiem");
            }
            else{
                System.out.println("Phuong trinh vo nghiem");
            }
        }
        else{
            double x = dinhthucx / dinhthuc;
            double y = dinhthucy / dinhthuc;
            System.out.println("Phuong trinh co nghiem x = " + x + " va y = " + y);
        }
    }
}
