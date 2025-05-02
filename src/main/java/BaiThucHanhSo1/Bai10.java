package BaiThucHanhSo1;
//calculate: S= 1+ 1/3! + 1/5! +.... + 1/(2n-1)!
public class Bai10 {
    public static double calculate(int n){
        double result=1;
        double preEle=1;
        for(int i=1;i<=n;i++){
            preEle*=preEle*1/(double)(2*i-1);
            result+=preEle;
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println("Ket qua la: "+ calculate(10));
    }
}
