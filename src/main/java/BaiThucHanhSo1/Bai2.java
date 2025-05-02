package BaiThucHanhSo1;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a,b;
        System.out.println("Nhập a: ");
        a = scanner.nextDouble();
        System.out.println("Nhập b: ");
        b = scanner.nextDouble();

        //code
        if(a==0){
            if(b==0){
                System.out.println("Phuong trinh co vo so nghiem");
            }
            else{
                System.out.println("Phuong trinh vo nghiem");
            }
        }
        else{
                double x = -b / a;
                System.out.println("Phuong trinh co nghiem x = " + x);
        }

    }
}
