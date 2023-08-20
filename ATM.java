import java.util.List;
import java.util.Scanner;

public class ATM {
    private User user;

    public ATM(User user) {
        this.user = user;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your PIN: ");
        String pin = scanner.nextLine();

        if (user.authenticate(pin)) {
            System.out.println("Authentication successful. Welcome, " + user.getAccount().getAccountNumber() + "!");

            boolean quit = false;
            while (!quit) {
                System.out.println("\nATM Menu:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Transfer");
                System.out.println("4. Transaction History");
                System.out.println("5. Quit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        user.getAccount().deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        user.getAccount().withdraw(withdrawalAmount);
                        break;
                    case 3:
                        System.out.print("Enter recipient's account number: ");
                        String recipientAccountNumber = scanner.nextLine();
                        Account recipientAccount = findRecipientAccount(recipientAccountNumber);
                        if (recipientAccount != null) {
                            System.out.print("Enter transfer amount: ");
                            double transferAmount = scanner.nextDouble();
                            user.getAccount().transfer(recipientAccount, transferAmount);
                        } else {
                            System.out.println("Recipient's account not found.");
                        }
                        break;
                    case 4:
                        displayTransactionHistory(user.getAccount().getTransactionHistory());
                        break;
                    case 5:
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }

            System.out.println("Thank you for using the ATM!");
        } else {
            System.out.println("Authentication failed. Exiting...");
        }
    }

    private Account findRecipientAccount(String accountNumber) {
        // Implement account lookup based on accountNumber
        // For this example, we'll assume a predefined recipient account
        if (accountNumber.equals("987654321")) {
            return new Account("987654321", 0.0);
        }
        return null;
    }

    private void displayTransactionHistory(List<Transaction> transactions) {
        System.out.println("\nTransaction History:");
        for (Transaction transaction : transactions) {
            System.out.println(
                transaction.getType() + " - " +
                transaction.getAmount() + " - " +
                transaction.getTimestamp()
            );
        }
    }
}
