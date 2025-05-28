package day0414.advanced.ch02;

import java.util.Scanner;

public class ScannerExample2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.print("입력 문자열: ");
            String str = sc.nextLine();

            if (str.equals("q")) {
                System.out.println("종료");
                break;
            }

            System.out.println("출력 문자열: " + str);
            System.out.println();
        }
    }
}
