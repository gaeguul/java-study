package day0421.basic.ch08.sec04;

public interface RemoteControl {
    int MAX_VOLUE = 10;
    int MIN_VOLUME = 0;

    void turnOn();

    void turnOff();

    void setVolume(int volume);
}
