package BaiThucHanhSo1;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        double a,b,c;
        System.out.println("Nhập a: ");
        a = scanner.nextDouble();
        System.out.println("Nhập b: ");
        b = scanner.nextDouble();
        System.out.println("Nhập c: ");
        c = scanner.nextDouble();
        if(a==0){
            if(b==0){
                if(c==0){
                    System.out.println("Phuong trinh co vo so nghiem");
                }
                else{
                    System.out.println("Phuong trinh vo nghiem");
                }
            }
            else{
                double x = -c / b;
                System.out.println("Phuong trinh co nghiem x = " + x);
            }
        }
        else{
            double delta = b*b - 4*a*c;
            if(delta < 0){
                System.out.println("Phuong trinh vo nghiem");
            }
            else if(delta == 0){
                double x = -b / (2*a);
                System.out.println("Phuong trinh co nghiem kep x=" + x);
            }
            else{
                double x1 = (-b + Math.sqrt(delta)) / (2*a);
                double x2 = (-b - Math.sqrt(delta)) / (2*a);
                System.out.println("Phuong trinh co 2 nghiem phan biet x1 = " + x1 + " va x2 = " + x2);
            }
        }
    }
}
