package day0423.basic.ch12.sec08;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataExample {
    public static void main(String[] args) {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        System.out.println(sdf.format(now));
    }
}
