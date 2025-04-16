package day0415.advanced;

public class SumAverage {
    public static void main(String[] args) {
        int[][] array = {
                {95, 86},
                {83, 92, 96},
                {78, 83, 93, 87, 88}
        };

        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                cnt += 1;
                sum += array[i][j];
            }
        }

        double average = (double) sum / cnt;

        System.out.printf("합: %d, 평균: %f", sum, average);
    }
}
