package day0508.basic.ch17.sec04.exam03;

import java.util.stream.IntStream;

public class StreamExample {

    public static int sum; // 합계

    public static void main(String[] args) {

        IntStream intStream = IntStream.rangeClosed(1, 100);
        intStream.forEach(i -> sum += i);
        System.out.println("총합: " + sum);

    }
}
