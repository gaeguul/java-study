package day0415.advanced;

import java.util.Scanner;

public class GradeAnalysis {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int studentLen = 0;
        int[] scores = new int[100];

        while (true) {
            System.out.println("---------------------------------------------------");
            System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
            System.out.println("---------------------------------------------------");

            System.out.print("선택> ");
            int number = scanner.nextInt();

            if (number == 1) {
                System.out.print("학생수> ");
                studentLen = scanner.nextInt();
            } else if (number == 2) {
                for (int i = 0; i < studentLen; i++) {
                    System.out.printf("scores[%d]> ", i);
                    int score = scanner.nextInt();
                    scores[i] = score;
                }
            } else if (number == 3) {
                for (int i = 0; i < studentLen; i++) {
                    System.out.printf("scores[%d]: %d\n", i, scores[i]);
                }
            } else if (number == 4) {
                int highestScore = 0;
                int sum = 0;
                for (int i = 0; i < studentLen; i++) {
                    if (scores[i] > highestScore) {
                        highestScore = scores[i];
                    }
                    sum += scores[i];
                }
                double averageScore = (double) sum / studentLen;
                System.out.println("최고 점수: " + highestScore);
                System.out.println("평균 점수: " + averageScore);

            } else if (number == 5) {
                System.out.println("프로그램 종료");
                break;
            }
        }
    }
}
