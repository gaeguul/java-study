package day0415.basic;

public class SumFrom1To100Example2 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        while (i <= 100) {
            sum += i;
            i += 1;
        }

        System.out.println("1~100 합 : " + sum);
    }
}
