package day0510.basic.ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {
    public static void main(String[] args) {
        String originalFileName = "/Users/jiham/Desktop/test1.db";
        String targetFileName = "/Users/jiham/Desktop/test1_copy.db";
        try (
                InputStream is = new FileInputStream(originalFileName);
                OutputStream os = new FileOutputStream(targetFileName);
        ) {
            byte[] data = new byte[1024];
            while (true) {
                int num = is.read(data);
                if (num == -1) break;
                os.write(data, 0, num);
            }
            os.flush();
            System.out.println("복사 성공!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
