package BaiThucHanhSo3_LuongVaoRa;
import java.io.*;
public class Bai1 {
    public String nhapChuoi() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    // In ra chuoi dao nguoc cua chuoi da cho
    public String chuoiDaoNguoc(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    // Doi chuoi da cho thanh chu hoa
    public String inHoa(String s){
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (Character.isLowerCase(c)) {
                sb.setCharAt(i, Character.toUpperCase(c));
            }
        }
        return sb.toString();
    }
    // Doi chuoi da cho thanh chu thuong
    public String inThuong(String s){
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.setCharAt(i, Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
    // Doi chuoi da cho thanh chu hoa thuong
    public String daoHoaThuong(String s){
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (Character.isLowerCase(c)) {
                sb.setCharAt(i, Character.toUpperCase(c));
            } else if (Character.isUpperCase(c)) {
                sb.setCharAt(i, Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
    // dem so ky tu trong chuoi
    public int getLength(String s){
        return s.length();
    }
    // xuat bang tan so cua ky tu trong chuoi
    public void xuatBangTanSo(String s){
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        System.out.println("Tan so xuat hien cua cac ky tu trong chuoi: ");
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                System.out.println((char)i + ": " + count[i]);
            }
        }
    }
    public static void main(String[] args){
        Bai1 b = new Bai1();
        String s = "";
        try {
            System.out.println("Nhap chuoi: ");
            s = b.nhapChuoi();
        } catch (IOException e) {
            System.out.println("Nhap sai, vui long nhap lai");
        }
        System.out.println("Chuoi da cho: " + s);
        System.out.println("Chuoi dao nguoc: " + b.chuoiDaoNguoc(s));
        System.out.println("Chuoi in hoa: " + b.inHoa(s));
        System.out.println("Chuoi in thuong: " + b.inThuong(s));
        System.out.println("Chuoi dao hoa thuong: " + b.daoHoaThuong(s));
        System.out.println("Do dai chuoi: " + b.getLength(s));
        b.xuatBangTanSo(s);
    }


}
