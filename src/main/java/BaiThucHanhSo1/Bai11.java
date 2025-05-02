package BaiThucHanhSo1;
//cal n!!
public class Bai11 {
    public static long calculate(int n){
        long result=1;
        if(n%2==0) {
            for (int i = 2; i <= n; i += 2) {
                result *= i;
            }
        }
        else {
            for (int i = 1; i <= n; i += 2) {
                result *= i;
            }
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println("Ket qua la: "+ calculate(10));
    }
}
