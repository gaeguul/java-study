package day0429.iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);

        bookShelf.appendBook(new Book("책1"));
        bookShelf.appendBook(new Book("책2"));
        bookShelf.appendBook(new Book("책3"));
        bookShelf.appendBook(new Book("책4"));

        // 1. 명시적으로 iterator 사용하는 방법 (일회용)
        Iterator<Book> iter = bookShelf.iterator();
        while (iter.hasNext()) {
            Book book = iter.next();
            System.out.println("책 이름: " + book.getName());
        }
        System.out.println();

        // 2. 확장 for문 사용하는 방법
        for (Book book : bookShelf) {
            System.out.println("책 이름: " + book.getName());
        }
    }
}
