package BaiThucHanhSo1;

public class Bai12 {
    public static int sumDigit(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
    public static int multiplyDigit(int n){
        int mul=1;
        while(n>0){
            mul*=n%10;
            n/=10;
        }
        return mul;
    }
    public static void main(String[] args){
        System.out.println("Tong cac chu so cua 1234 la: "+ sumDigit(1234));
        System.out.println("Tich cac chu so cua 1234 la: "+ multiplyDigit(1234));
    }
}
