package day0422.basic.ch09.sec03.exam02;

public class A {

    static class B {
        static int field2 = 2;
        int field1 = 1;

        B() {
            System.out.println("B-생성자 실행");
        }

        static void method2() {
            System.out.println("B-method2 실행");
        }

        void method1() {
            System.out.println("B-method1 실행");
        }
    }

}
