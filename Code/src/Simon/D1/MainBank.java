package Simon.D1;

import java.math.BigDecimal;

public class MainBank {
    public static void main(String[] args) {
        Customer alice = new Customer("Alice", "Meyer");
        Customer bob = new Customer("Bob", "Schmidt");

        Account a1 = new Account("CH93-0000-AL1", alice, new BigDecimal("500.00"));
        Account a2 = new Account("CH93-0000-BB2", bob, new BigDecimal("120.00"));

        System.out.println("Start:");
        System.out.println(a1.getOwner().getDisplayName() + " " + a1.getIban() + " " + a1.getBalance());
        System.out.println(a2.getOwner().getDisplayName() + " " + a2.getIban() + " " + a2.getBalance());
        System.out.println("\n");

        if (a1.deposit(new BigDecimal("50.00"))){
        System.out.println("Nach Deposite:");
        System.out.println(a1.getOwner().getDisplayName() + " " + a1.getIban() + " " + a1.getBalance());
        System.out.println(a2.getOwner().getDisplayName() + " " + a2.getIban() + " " + a2.getBalance());
        System.out.println("\n");
        } else {
            System.out.println("Fehler");
        }

        if (a2.withdraw(new BigDecimal("20.00"))){
        System.out.println("Nach Withdraw:");
        System.out.println(a1.getOwner().getDisplayName() + " " + a1.getIban() + " " + a1.getBalance());
        System.out.println(a2.getOwner().getDisplayName() + " " + a2.getIban() + " " + a2.getBalance());
        System.out.println("\n");
        } else {
            System.out.println("Fehler");
        }

        if (a1.transferTo(a2, new BigDecimal("100.00"))) {
            System.out.println("Nach Transer:");
            System.out.println(a1.getOwner().getDisplayName() + " " + a1.getIban() + " " + a1.getBalance());
            System.out.println(a2.getOwner().getDisplayName() + " " + a2.getIban() + " " + a2.getBalance());
        } else {
            System.out.println("Fehler");
        }
    }
}