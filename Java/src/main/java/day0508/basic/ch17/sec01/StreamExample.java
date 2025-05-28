package day0508.basic.ch17.sec01;

import java.util.HashSet;
import java.util.Set;

public class StreamExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("신용권");
        set.add("김자바");

        set.stream().forEach(name -> System.out.println(name));
    }
}
