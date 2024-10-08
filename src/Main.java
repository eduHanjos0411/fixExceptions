import models.Entities.Account;
import models.Exceptions.DomainExceptions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter account data:");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Holder: ");
        String holder = sc.next();
        System.out.print("Initial balance: ");
        double initialBalance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();
        Account acc = new Account(number, holder, initialBalance, withdrawLimit);

        System.out.print("Enter amount for withdraw: ");
        double amount = sc.nextDouble();

    try {
        acc.withdraw(amount);
    }
    catch (DomainExceptions e) {
        System.out.println(e.getMessage());
    }

    }
}