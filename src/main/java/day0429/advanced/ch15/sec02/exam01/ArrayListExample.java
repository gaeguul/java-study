package day0429.advanced.ch15.sec02.exam01;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Board> list = new ArrayList<>();

        list.add(new Board("제목1", "내용1", "글쓴이1"));
        list.add(new Board("제목2", "내용2", "글쓴이2"));
        list.add(new Board("제목3", "내용3", "글쓴이3"));
        list.add(new Board("제목4", "내용4", "글쓴이4"));
        list.add(new Board("제목5", "내용5", "글쓴이5"));

        int size = list.size();
        System.out.println("총 개수: " + size);

        Board board = list.get(3);
        System.out.println("3번째 데이터: " + board.getContent() + ", " + board.getSubject() + ", " + board.getWriter());

        for (int i = 0; i < size; i++) {
            Board b = list.get(i);
            System.out.println(i + "번째 데이터: " + b.getContent() + ", " + b.getSubject() + ", " + b.getWriter());
        }

        list.remove(2);
        list.remove(2);

        for (Board b : list) {
            System.out.println(b.getContent() + ", " + b.getSubject() + ", " + b.getWriter());
        }
    }
}

