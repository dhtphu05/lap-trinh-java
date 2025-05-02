package BaiThucHanhSo1;

public class Bai19 {
    public static void printFibonacci(int n){
        int a=1,b=1,c;
        System.out.print(a+" "+b+" ");
        for(int i=2;i<n;i++){
            c=a+b;
            System.out.print(c+" ");
            a=b;
            b=c;
        }
    }
    public static void main(String[] args){
        printFibonacci(10);
    }
}
