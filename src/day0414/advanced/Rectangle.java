package day0414.advanced;

public class Rectangle {
    public static void main(String[] args) {
        int height = 7;
        int upperWidth = 5;
        int lowerWidth = 10;

        double area = (double) height * (upperWidth + lowerWidth) / 2;

        System.out.println(area);
    }
}
