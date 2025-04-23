package day0423.advanced.ch11.sec06;

public class Account {
    private long balance;

    public Account() {
    }

    public long getBalance() {
        return balance;

    }

    public void deposit(int money) {
        balance += money;
    }

    public void withdraw(int money) throws InsufficientException {
        if (balance < money) {
            throw new InsufficientException((money - balance) + "원의 잔액이 부족합니다");
        }
        balance -= money;
    }
}
