package BaiThucHanhSo3_LuongVaoRa;
import java.io.*;
public class Bai2 {
    public int nhapso() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return Integer.parseInt(s);
    }
    public int TongCacChuSo(int n){
        int t = 0;
        while(n > 0){
            int d = n % 10;
            t += d;
            n /= 10;
        }
        return t;
    }
    public int SoDao(int n){
        int d = 0;
        while(n > 0){
            d = d * 10 + n % 10;
            n /= 10;
        }
        return d;
    }
    public boolean KiemTraSoFibonacci(int n){
        int a = 0;
        int b = 1;
        while(b < n){
            int c = a + b;
            a = b;
            b = c;
        }
        return (b == n);
    }
    public static void main(String[] args) throws IOException {
        Bai2 b = new Bai2();
        int n = 0;
        try {
            do {
                System.out.println("Nhap so nguyen duong: ");
                n = b.nhapso();
            }
            while (n <= 0);
        } catch (Exception e) {
            System.out.println("Nhap sai, vui long nhap lai");
        }
        System.out.println("Tong cac chu so: " + b.TongCacChuSo(n));
        System.out.println("So dao: " + b.SoDao(n));
        if(b.KiemTraSoFibonacci(n)){
            System.out.println(n + " la so Fibonacci");
        } else {
            System.out.println(n + " khong la so Fibonacci");
        }
    }

}
