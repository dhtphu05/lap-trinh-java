package BaiThucHanhSo1;

public class Bai18 {
    public static boolean isSoHoanHao(int n){
        int sum=0;
        for(int i=1;i<n;i++){
            if(n%i==0){
                sum+=i;
            }
        }
        return sum==n;
    }
    public static void main(String[] args){
        for(int i=1;i<=1000;i++){
            if(isSoHoanHao(i)){
                System.out.print(i+" ");
            }
        }
    }
}
