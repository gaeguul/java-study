package day0430.advanced.ch15.sec05.exam03;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Person implements Comparable<Person> {
    public String name;
    public int age;

    @Override
    public int compareTo(Person other) {
        if (age > other.age) {
            return 1;
        } else if (age == other.age) {
            return 0;
        } else {
            return -1;
        }
    }
}
