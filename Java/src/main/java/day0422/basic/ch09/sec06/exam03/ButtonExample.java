package day0422.basic.ch09.sec06.exam03;

import day0422.basic.ch09.sec06.exam01.Button;

public class ButtonExample {
    public static void main(String[] args) {

        Button button = new Button();

        class OkClickListener implements Button.ClickListener {

            @Override
            public void onClick() {
                System.out.println("Ok 버튼을 클릭했습니다.");
            }
        }


    }
}
