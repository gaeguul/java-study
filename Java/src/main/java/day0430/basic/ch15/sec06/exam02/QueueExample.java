package day0430.basic.ch15.sec06.exam02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Message> messageQueue = new LinkedList<>();

        messageQueue.offer(new Message("sendMail", "홍길동"));
        messageQueue.offer(new Message("sendSMS", "신용권"));
        messageQueue.offer(new Message("sendKakaoTalk", "김자바"));

        while (!messageQueue.isEmpty()) {
            Message message = messageQueue.poll();

            switch (message.getCommand()) {
                case "sendMail":
                    System.out.println(message.getTo() + "님에게 메일을 보냅니다.");
                    break;
                case "sendSMS":
                    System.out.println(message.getTo() + "님에게 SMS를 보냅니다.");
                    break;
                case "sendKakaoTalk":
                    System.out.println(message.getTo() + "님에게 카카오톡을 보냅니다.");
                    break;
            }
        }
    }
}
