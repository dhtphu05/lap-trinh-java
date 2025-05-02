package BaiThucHanhSo1;

import com.sun.tools.jconsole.JConsoleContext;

import java.util.Scanner;

public class Bai1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a,b,c;
        System.out.println("Nhập a: ");
        a = scanner.nextInt();
        System.out.println("Nhập b: ");
        b = scanner.nextInt();
        System.out.println("Nhập c: ");
        c = scanner.nextInt();
        int max = a;
        //
        if( max >= b){
            if(max >=c) {
                max = a;
            }
            else{
                max = c;
            }
        }
        else{
            if(b >= c){
                max = b;
            }
            else{
                max = c;
            }
        }
        System.out.println("Max = " + max);
    }
}
