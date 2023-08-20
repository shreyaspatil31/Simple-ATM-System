public class User {
    private String userId;
    private String userPin;
    private Account account;

    public User(String userId, String userPin, Account account) {
        this.userId = userId;
        this.userPin = userPin;
        this.account = account;
    }

    public boolean authenticate(String pin) {
        return userPin.equals(pin);
    }

    public Account getAccount() {
        return account;
    }
}
