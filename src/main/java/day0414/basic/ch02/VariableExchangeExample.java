package day0414.basic.ch02;

public class VariableExchangeExample {
    public static void main(String[] args) {
        int x = 3;
        int y = 5;

        System.out.printf("x:%d, y:%d\n", x, y);

        int tmp = x;
        x = y;
        y = tmp;

        System.out.printf("x:%d, y:%d\n", x, y);
    }
}
