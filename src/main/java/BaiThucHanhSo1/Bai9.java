package BaiThucHanhSo1;



//calculate: S= 15 - 1 +1/2 -1/3! +.... + (-1)^n/n!
public class Bai9 {
    public static double calculate(int n){
        double result=15;
        double preEle=1;
        for(int i=1;i<=n;i++){
            result+= Math.pow(-1,i)*preEle/(double)i;
            preEle*=preEle*1/(double)i;
        }
        return result;
    }
    public static void main( String [] args){
        System.out.println("Ket qua la: "+ calculate(10));
    }
}
