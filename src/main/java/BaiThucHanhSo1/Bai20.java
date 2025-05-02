package BaiThucHanhSo1;

import java.util.Scanner;

public class Bai20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int a=1,b=1,c=1;
        int indexOfFibonacci =0 ;

        for(int i=1;i<=K;i++){
            if(K==b){
                indexOfFibonacci=i+1;
                break;
            }
            c=a+b;
            a=b;
            b=c;

        }
        if(indexOfFibonacci>0){
            System.out.println("K nam o vi tri thu "+indexOfFibonacci+" trong day Fibonacci");
        }
        else{
            System.out.println("K khong nam trong day Fibonacci");
        }


    }
}
