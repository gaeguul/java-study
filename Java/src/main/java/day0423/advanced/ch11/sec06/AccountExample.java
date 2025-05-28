package day0423.advanced.ch11.sec06;

public class AccountExample {
    public static void main(String[] args) {

        Account account = new Account();

        account.deposit(10000);
        System.out.println("예금액: " + account.getBalance());

        try {
            account.withdraw(5000);
            System.out.println("인출액: " + account.getBalance());

            account.withdraw(7000);
            System.out.println("인출액: " + account.getBalance());

        } catch (InsufficientException e) {
            System.out.println(e.getMessage());
        }
    }
}
