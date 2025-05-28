package day0510.basic.ch18.sec02.exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args) {
        try {
            OutputStream os = new FileOutputStream("/Users/jiham/Desktop/test2.db");
            byte[] array = {1, 2, 3, 4, 5};
            os.write(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
