public class BankAccount {

    private double balance = 5000;

    public void withdraw(double amount)
            throws InsufficientBalanceException {

        if (amount > balance) {

            throw new InsufficientBalanceException(
                    "Insufficient Balance");

        }

        balance -= amount;

        System.out.println(
                "Remaining Balance = " + balance);

    }

}