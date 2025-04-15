package day0415.advanced;

import java.util.Scanner;

public class Deposit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int myDeposit = 0;

        while (true) {
            System.out.println("----------------------------------");
            System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
            System.out.println("----------------------------------");

            System.out.print("선택> ");
            int number = scanner.nextInt();

            if (number == 1) {
                System.out.print("예금액> ");
                int amount = scanner.nextInt();
                myDeposit += amount;
            } else if (number == 2) {
                System.out.print("출금액> ");
                int amount = scanner.nextInt();
                myDeposit -= amount;
            } else if (number == 3) {
                System.out.print("잔고> " + myDeposit + "\n");
            } else if (number == 4) {
                break;
            }
        }
    }
}
