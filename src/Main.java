import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount userAccount = new BankAccount();

        System.out.println("\nCash machine\n");
        String text;
        text = """
                Welcome to the ATM!
                before taking any action we need you to provide some data, including full name, CPF, date of birth and account access password.
                """;
        System.out.println(text);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        String cpf;
        do {
            System.out.print("Enter your CPF: ");
            cpf = sc.nextLine();

            if (CPFValidator.validate(cpf)) {
                System.out.println("Invalid CPF! Please enter a valid CPF.");
            }
        } while (CPFValidator.validate(cpf));

        // above, CPF validation and below date of birth

        String date;
        do {
            System.out.print("Enter your date of birth (ddMMyyyy): ");
            date = sc.nextLine();

            if (DateFormatter.isValid(date)) {
                System.out.println("Invalid date format! Please enter a valid date (ddMMyyyy).");
            }
        } while (DateFormatter.isValid(date));

        String formattedDate = DateFormatter.format(date);

        String password;
        while (true){
            System.out.print("Enter your password: ");
            password = sc.nextLine();

            System.out.println("confirm your password: ");
            String confirmPassword = sc.nextLine();

            if (password.equals(confirmPassword)) {
                break;
            } else {
                System.out.println("Invalid password! Please enter a valid password.");
            }
        }

        UserAuthentication.RegisterUser(cpf, password);

        System.out.println("\nData successfully recorded!");
        System.out.println("Name: " + name);
        System.out.println("CPF: " + cpf);
        System.out.println("Date of Birth: " + formattedDate);

        System.out.println("\nNow, please log in to your account.");
        while (true) {
            System.out.println("enter your CPF: ");
            String loginCpf = sc.nextLine();

            System.out.println("enter your password: ");
            String loginPassword = sc.nextLine();

            if (UserAuthentication.Login(loginCpf, loginPassword)) {
                System.out.println("Login successful! Welcome, " + name + "!");
                break;
            } else {
                System.out.println("Invalid CPF or password! Try again.");
            }
        }
        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1 - Deposit");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Check Balance");
            System.out.println("4 - Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    userAccount.withdraw(withdrawAmount);
                    break;
                case 3:
                    userAccount.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM! Have a great day.");
                    sc.close();
                    System.exit(0);
                    break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }

            }

        }
    }