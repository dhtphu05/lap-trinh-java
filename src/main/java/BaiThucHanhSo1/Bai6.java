package BaiThucHanhSo1;

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int start, end;
        System.out.println("Nhập thời gian bắt đầu: ");
        start = scanner.nextInt();
        System.out.println("Nhập thời gian kết thúc: ");
        end = scanner.nextInt();
        int time = end - start;
        int totalPrice = 0;
        if(end <= 18 ){
            totalPrice= time * 45000;
        }
        else{
            if(start <= 18){
                totalPrice= (18-start)*45000 + (end-18)*60000;
            }
            else {
                totalPrice=time*60000;
            }
        }
        System.out.println("Gia tien la: " + totalPrice);

    }
}
