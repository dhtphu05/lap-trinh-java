package BaiThucHanhSo1;

public class Bai13 {
    public static int UCLN(int a, int b){
        while(a!=b){
            if(a>b){
                a-=b;
            }
            else{
                b-=a;
            }
        }
        return a;
    }
    public static int BCNN(int a, int b){
        return a*b/UCLN(a,b);
    }
    public static void main(String[] args){
        System.out.println("UCLN: "+ UCLN(10,15));
        System.out.println("BCNN: "+ BCNN(10,15));
    }
}
