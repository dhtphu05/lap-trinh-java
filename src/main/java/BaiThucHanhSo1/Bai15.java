package BaiThucHanhSo1;
import java.util.Scanner;
public class Bai15 {
    public static boolean isSoChinhPhuong(int n){
        if(n<0){
            return false;
        }
        for(int i=0;i<=n;i++){
            if(i*i==n){
                return true;
            }
        }
        return false;
    }
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap n: ");
        int n=sc.nextInt();
        if(isSoChinhPhuong(n)){
            System.out.println(n+" la so chinh phuong");
        }
        else{
            System.out.println(n+" khong phai la so chinh phuong");
        }
    }
}
