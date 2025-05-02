package BaiThucHanhSo1;

import java.util.Scanner;

public class Bai16 {
    public static boolean isSoDoiXung(int n){
        int temp=n;
        int soDaoNguoc=0;
        while(temp>0){
            soDaoNguoc=soDaoNguoc*10+temp%10;
            temp/=10;
        }
        return soDaoNguoc==n;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap n: ");
        int n=sc.nextInt();
        if(isSoDoiXung(n)){
            System.out.println(n+" la so doi xung");
        }
        else{
            System.out.println(n+" khong phai la so doi xung");
        }
    }
}
