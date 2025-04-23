package day0423.basic.ch12.sec04;

public class MeasureRunTimeExample {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int sum = 0;
        for (int i = 1; i <= 1000000; i++) {
            sum += i;
        }

        long endTime = System.nanoTime();

        System.out.println("1부터 1000000까지의 합: " + sum);
        System.out.println("계산에 소요된 시간(nanoseconds): " + (endTime - startTime));
    }
}
