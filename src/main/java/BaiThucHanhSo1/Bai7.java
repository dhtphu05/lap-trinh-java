package BaiThucHanhSo1;
import java.util.Scanner;
public class Bai7 {
    static boolean namNhuan(int year) {
        return year%400==0 || (year%100!=0 && year%4==0);
    }
    static int countDay(int m, int y) {
        int d = 0;
        switch(m) {
            case 2:
                if (namNhuan(y)) d = 29;
                else d = 28;
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                d = 31;
                break;
            default:
                d = 30;
        }

        return d;
    }
    public static void main (String[] args){
        Scanner scanner= new Scanner(System.in);
        int month, year;
        System.out.println("Nhap thang: ");
        month=scanner.nextInt();
        System.out.println("Nhap nam: ");
        year=scanner.nextInt();

        //code
        System.out.println("Thang "+ month + " trong nam "+ year + " co "+ countDay(month,year) +" ngay");
    }
}
