package day0430.basic.ch15.sec03.exam01;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        set.add("Java");
        set.add("JDBC");
        set.add("Servlet/JSP");
        set.add("Java"); // 저장되지 않음
        set.add("iBATIS");

        int size = set.size();
        System.out.println("총 객체 수: " + size);  // 4
    }
}
