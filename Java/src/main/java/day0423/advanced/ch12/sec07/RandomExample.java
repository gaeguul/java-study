package day0423.advanced.ch12.sec07;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {

    public static void main(String[] args) {

        Random random = new Random();
        int[] selectedNumbers = new int[6];
        int[] winningNumbers = new int[6];

        System.out.print("선택한 번호: ");
        for (int i = 0; i < 6; i++) {
            selectedNumbers[i] = random.nextInt(45) + 1;
            System.out.print(selectedNumbers[i] + " ");
        }

        System.out.print("\n당첨 번호: ");
        for (int i = 0; i < 6; i++) {
            winningNumbers[i] = random.nextInt(45) + 1;
            System.out.print(winningNumbers[i] + " ");
        }
        System.out.println();

        Arrays.sort(selectedNumbers);
        Arrays.sort(winningNumbers);

        boolean result = Arrays.equals(selectedNumbers, winningNumbers);

        if (result) {
            System.out.println("1등 당첨!");
        } else {
            System.out.println("당첨되지 않았어요.");
        }
    }

}
