package day0508.advanced.ch17.sec06.exam02;

import java.util.Arrays;

public class MapExample {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};

        Arrays.stream(intArray)
                .asDoubleStream()
                .forEach(d -> System.out.println(d));

        System.out.println();

        Arrays.stream(intArray)
                .boxed()
                .forEach(obj -> System.out.println(obj.intValue()));
    }
}
