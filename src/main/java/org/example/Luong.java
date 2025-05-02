package org.example;

import java.io.IOException;
import java.io.*;
public class Luong {
    public int nhapso() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return Integer.parseInt(s);
    }
    public void TongTichCacChuSo(int n){
        int t = 0;
        int p = 1;
        while(n > 0){
            int d = n % 10;
            t += d;
            p *= d;
            n /= 10;
        }
        System.out.println("Tong cac chu so: " + t);
        System.out.println("Tich cac chu so: " + p);
    }
    public static void main(String[] args) throws IOException {
        Luong l = new Luong();
        int n = 0;
        try {
            do {
                System.out.println("Nhap so nguyen duong: ");
                n = l.nhapso();
            }
            while (n <= 0);
        } catch (Exception e) {
            System.out.println("Nhap sai, vui long nhap lai");
        }

        l.TongTichCacChuSo(n);
    }
}
