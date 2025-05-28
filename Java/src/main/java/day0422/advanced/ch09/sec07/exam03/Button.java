package day0422.advanced.ch09.sec07.exam03;

public class Button {
    private ClickListener clickListener;

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void click() {
        this.clickListener.onClick();
    }

    public static interface ClickListener {
        void onClick();
    }
}
