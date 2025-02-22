public class BankAccount {
    private double balance;

    public BankAccount(){
        this.balance = 0.0;
    }
    public void deposit(double amount){
        if(amount > 0){
            this.balance += amount;
            System.out.println("Deposit successful! Your new balance is: $\" + balance");
        }
        else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    public void withdraw(double amount){
        if(amount > 0 && amount <= this.balance){
            balance -= amount;
            System.out.println("Withdrawal successful! Your new balance is: $" + balance);
        } else if (amount > balance) {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a negative value.");
        }
    }

    public void checkBalance(){
        System.out.println("your new balance is: $" + balance);
    }
}
