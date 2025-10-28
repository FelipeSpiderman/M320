package Simon.D1;

import java.math.BigDecimal;

public class Account {
    private final String iban;
    private final Customer owner;
    private BigDecimal balance;

    public Account(String iban, Customer owner, BigDecimal startBalance) {
        this.iban = iban;
        this.owner = owner;
        this.balance = startBalance == null ? BigDecimal.ZERO : startBalance;
    }

    public String getIban() { return iban; }
    public Customer getOwner() { return owner; }
    public BigDecimal getBalance() { return balance; }

    public boolean deposit(BigDecimal amount) {
        if (amount == null) {
            return false;
        } else if (amount.signum() <= 0) {
            return false;
        } else {
            balance = balance.add(amount);
            return true;
        }
    }

    public boolean withdraw(BigDecimal amount) {
        if (amount == null) {
            return false;
        } else if (amount.signum() <= 0) {
            return false;
        } else if (balance.compareTo(amount) < 0) {
            return false;
        } else {
            balance = balance.subtract(amount);
            return true;
        }
    }

    public boolean transferTo(Account target, BigDecimal amount) {
        if (target == null) {
            return false;
        } else if (amount == null) {
            return false;
        } else if (amount.signum() <= 0) {
            return false;
        } else if (balance.compareTo(amount) < 0) {
            return false;
        } else {
            balance = balance.subtract(amount);
            target.balance = target.balance.add(amount);
            return true;
        }
    }
}