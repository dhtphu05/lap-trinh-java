package BaiThucHanhSo1;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int a,b,c;
        System.out.println("Nhap a: ");
        a= scanner.nextInt();
        System.out.println("Nhap b: ");
        b= scanner.nextInt();
        System.out.println("Nhap c: ");
        c= scanner.nextInt();

        //code
        int middle = a;
        if( a>=b ){
            if( a>=c){
                if( b>=c){
                    middle = b;
                }
                else{
                    middle = c;
                }
            }
            else{
                middle = a;
            }
        }
        else{
            if( b>=c){
                if( a>=c){
                    middle = a;
                }
                else{
                    middle = c;
                }
            }
            else{
                middle = b;
            }
        }
        System.out.println("So trung gian la: " + middle);
    }
}
