package D1;

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

    public void deposit(BigDecimal amount) {
        if (amount.signum() <= 0) throw new IllegalArgumentException("amount > 0 required");
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (amount.signum() <= 0) throw new IllegalArgumentException("amount > 0 required");
        if (balance.compareTo(amount) < 0) throw new IllegalStateException("insufficient funds");
        balance = balance.subtract(amount);
    }

    public void transferTo(Account target, BigDecimal amount) {
        if (target == null) throw new IllegalArgumentException("target required");
        withdraw(amount);
        target.deposit(amount);
    }
}
