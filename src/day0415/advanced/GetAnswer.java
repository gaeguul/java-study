package day0415.advanced;

public class GetAnswer {
    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                int result = i * 4 + j * 5;
                if (result == 60) {
                    System.out.printf("(%d, %d)\n", i, j);
                }
            }
        }
    }
}
