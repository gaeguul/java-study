package day0510.basic.ch18.sec11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileExample {
    public static void main(String[] args) {
        try {
            String pathname = "/Users/jiham/Desktop/file1.txt";
            File file1 = new File(pathname);
            Path path = Paths.get(pathname);

            if (file1.exists() == false) {
                System.out.println("해당 파일은 없는 파일입니다.");
            } else if (file1.isFile()) {
                System.out.println("파일 경로: " + file1.getAbsolutePath());
                System.out.println("파일 크기: " + Files.size(path) + " bytes");
            } else if (file1.isDirectory()) {
                System.out.println("<dir> " + file1.getAbsolutePath());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
