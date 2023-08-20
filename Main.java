public class Main {
    public static void main(String[] args) {
        Account account = new Account("123456789", 1000.0);
        User user = new User("user123", "1234", account);
        ATM atm = new ATM(user);
        atm.run();
    }
}
