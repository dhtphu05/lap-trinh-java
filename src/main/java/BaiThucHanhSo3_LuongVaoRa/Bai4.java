package BaiThucHanhSo3_LuongVaoRa;
import java.io.*;
public class Bai4 {
    public int nhapso() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return Integer.parseInt(s);
    }
    public void nhapMaTran(int[][] a, int n, int m) throws IOException{
        Bai4 b = new Bai4();
        System.out.println("Nhap ma tran: ");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                a[i][j] = b.nhapso();
            }
        }
    }
    public void inMaTran(int[][] a, int n, int m){
        System.out.println("Ma tran vua nhap: ");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public int tichBoi3TrenDongDau(int[][] a, int n, int m){
        int t = 1;
        for (int j = 0; j < m; j++){
            if (a[0][j] % 3 == 0){
                t *= a[0][j];
            }
        }
        return t;
    }
    public void xuatMaTranMaxDong(int[][] a, int n, int m, int[]maxRow){
        for (int i = 0; i < n; i++){
            int max = a[i][0];
            for (int j = 1; j < m; j++){
                if (a[i][j] > max){
                    max = a[i][j];
                }
            }
            maxRow[i] = max;
        }
        System.out.println("Ma tran co gia tri max tren tung dong: ");
        for (int i = 0; i < n; i++){
            System.out.print(maxRow[i] + "\t");
        }
    }
    public void xoaPhanTuDauTienCuaMang(int[] a, int n){
        for (int i = 0; i < n - 1; i++) {
            a[i] = a[i + 1];
        }
        System.out.println("Mang sau khi xoa phan tu dau tien: ");
        for (int i = 0; i < n - 1; i++){
            System.out.print(a[i] + "\t");
        }
    }
    public static void main(String []args) throws IOException {
        Bai4 b = new Bai4();
        int n = 0;
        int m = 0;
        try {
            do {
                System.out.println("Nhap so hang: ");
                n = b.nhapso();
            }
            while (n <= 0);
            do {
                System.out.println("Nhap so cot: ");
                m = b.nhapso();
            }
            while (m <= 0);
        } catch (Exception e) {
            System.out.println("Nhap sai, vui long nhap lai");
        }
        int[][] a = new int[n][m];
        int[] maxRow = new int[n];
        b.nhapMaTran(a, n, m);
        b.inMaTran(a, n, m);
        System.out.println("Tich cac phan tu boi 3 tren dong dau: " + b.tichBoi3TrenDongDau(a, n, m));
        b.xuatMaTranMaxDong(a, n, m,maxRow);
        b.xoaPhanTuDauTienCuaMang(maxRow, n);

    }
}
