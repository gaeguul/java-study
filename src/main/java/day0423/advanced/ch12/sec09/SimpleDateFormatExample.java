package day0423.advanced.ch12.sec09;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SimpleDateFormatExample {
    public static void main(String[] args) {
        Date now = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(now));

        dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
        System.out.println(dateFormat.format(now));

        dateFormat = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss", Locale.KOREA);
        System.out.println(dateFormat.format(now));

        dateFormat = new SimpleDateFormat("오늘은 E요일", Locale.KOREA);
        System.out.println(dateFormat.format(now));
    }
}
