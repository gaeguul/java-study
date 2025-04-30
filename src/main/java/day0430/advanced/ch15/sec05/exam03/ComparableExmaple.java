package day0430.advanced.ch15.sec05.exam03;

import java.util.TreeSet;

public class ComparableExmaple {
    public static void main(String[] args) {
        TreeSet<Person> set = new TreeSet<>();

        set.add(new Person("홍길동", 35));
        set.add(new Person("김자바", 25));
        set.add(new Person("박지원", 31));

        for (Person person : set) {
            System.out.println(person.name + ": " + person.age);
        }
    }
}
