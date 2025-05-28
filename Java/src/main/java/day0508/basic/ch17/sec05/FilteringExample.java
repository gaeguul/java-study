package day0508.basic.ch17.sec05;

import java.util.ArrayList;
import java.util.List;

public class FilteringExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("홍길동");
        list.add("신용권");
        list.add("감자바");
        list.add("신용권");
        list.add("신민철");


        // 중복 요소 제거
        list.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println();

        // 신으로 시작하는 요소만 필터링
        list.stream()
                .filter(s -> s.startsWith("신"))
                .forEach(System.out::println);

        System.out.println();

        // 중복 요소 제거 -> 신으로 시작하는 요소만 필터링
        list.stream()
                .distinct()
                .filter(s -> s.startsWith("신"))
                .forEach(System.out::println);

    }
}
