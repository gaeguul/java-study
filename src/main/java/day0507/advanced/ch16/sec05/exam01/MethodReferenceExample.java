package day0507.advanced.ch16.sec05.exam01;

public class MethodReferenceExample {
    public static void main(String[] args) {
        Person person = new Person();

        // 정적 메소드
        person.action(Computer::staticMethod);

        // 인스턴스 메서드
        Computer computer = new Computer();
        person.action(computer::instanceMethod);


    }
}
