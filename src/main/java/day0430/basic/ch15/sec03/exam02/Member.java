package day0430.basic.ch15.sec03.exam02;

public class Member {

    public String name;
    public int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member target) {
            // 이름 동일하고 나이 동일하면 같은 객체로 판단
            return target.name.equals(name) && target.age == age;
        }
        return false;

    }
}
