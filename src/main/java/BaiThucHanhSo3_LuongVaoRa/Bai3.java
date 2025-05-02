package BaiThucHanhSo3_LuongVaoRa;
import java.io.*;
public class Bai3 {
    public int nhapso() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return Integer.parseInt(s);
    }
    public void nhapMang(int[] a, int n) throws IOException{
        Bai3 b = new Bai3();

        System.out.println("Nhap mang: ");
        for (int i = 0; i < n; i++){
            a[i] = b.nhapso();
        }
    }
    public int TongSoDuongLe(int[] a, int n){
        int t = 0;
        for (int i = 0; i < n; i++){
            if (a[i] > 0 && a[i] % 2 != 0){
                t += a[i];
            }
        }
        return t;
    }
    public void TimSoK (int[] a, int n, int k){
        int d = 0;
        for (int i = 0; i < n; i++){
            if (a[i] == k){
                d=i;
            }
        }
        if (d > 0){
            System.out.println("So " + k + " xuat hien trong mang tai vi tri " + d);
        } else {
            System.out.println("So " + k + " khong xuat hien trong mang");
        }
    }
    public void SapXepTangDan(int[] a, int n){
        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++){
                if (a[i] > a[j]){
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
    }
    public void ChenPhanTuPVao(int []a, int n, int k){
        int[] b = new int[n + 1];
        for (int i = 0; i < n; i++){
            b[i] = a[i];
        }
        b[n] = k;
        int[] newA = new int[n + 1];
        for (int i = 0; i < n + 1; i++){
            newA[i] = b[i];
        }
        a= newA;
        SapXepTangDan(a, n + 1);
        System.out.println("Mang sau khi chen phan tu " + k + " la: ");
        for (int i = 0; i < n + 1; i++){
            System.out.print(a[i] + " ");
        }
    }
    public static void main(String[] args) throws IOException {
        Bai3 b = new Bai3();
        int n = 0;
        try {
            do {
                System.out.println("Nhap so phan tu mang: ");
                n = b.nhapso();
            }
            while (n <= 0);
        } catch (Exception e) {
            System.out.println("Nhap sai, vui long nhap lai");
        }
        int[] a = new int[n];
        b.nhapMang(a, n);
        System.out.println("Tong cac so duong le trong mang: " + b.TongSoDuongLe(a, n));
        System.out.println("Nhap so can tim: ");
        int k = b.nhapso();
        b.TimSoK(a, n, k);
        System.out.println("Mang sau khi sap xep tang dan la: ");
        b.SapXepTangDan(a, n);
        for (int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println("\nNhap phan tu can chen: ");
        int p = b.nhapso();
        b.ChenPhanTuPVao(a, n, p);
    }

}
