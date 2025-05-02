package org.example;
import java.io.*;
public class NhapChuoi {
    public static String nhapChuoi() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    public static void main(String[] args) throws IOException {
        System.out.println("Nhap chuoi: ");
        String s = nhapChuoi();
        System.out.println("Chuoi vua nhap: " + s);

    }
}
