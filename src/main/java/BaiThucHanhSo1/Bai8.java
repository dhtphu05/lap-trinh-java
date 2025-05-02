package BaiThucHanhSo1;

//calculate: S= 1 +1/2 +1/3 +.... + 1/n
public class Bai8 {
    public static double calculate(int n){
        double sum=0;
        for(int i=1;i<=n;i++){
            sum+=1/(double)i;
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println("ket qua la: "+ calculate(10));
    }
}
