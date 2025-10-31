package edu.tbz.m4project.M4;

import edu.tbz.m4project.M4.User.User;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "budgets", schema = "financetracker")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "budgetid")
    private Integer budgetId;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    @Column(name = "income")
    private BigDecimal income = BigDecimal.ZERO;

    @Column(name = "limit_amount", nullable = false)
    private BigDecimal limitAmount;

    @Column(name = "spent")
    private BigDecimal spent = BigDecimal.ZERO;


    public Budget() {}

    public Budget(User user, Category category, BigDecimal limitAmount) {
        this.user = user;
        this.category = category;
        this.limitAmount = limitAmount;
    }

    public Budget(User user, Category category, BigDecimal income, BigDecimal limitAmount, BigDecimal spent) {
        this.user = user;
        this.category = category;
        this.income = income != null ? income : BigDecimal.ZERO;
        this.limitAmount = limitAmount;
        this.spent = spent != null ? spent : BigDecimal.ZERO;
    }


    public Integer getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(Integer budgetId) {
        this.budgetId = budgetId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income != null ? income : BigDecimal.ZERO;
    }

    public BigDecimal getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(BigDecimal limitAmount) {
        this.limitAmount = limitAmount;
    }

    public BigDecimal getSpent() {
        return spent;
    }

    public void setSpent(BigDecimal spent) {
        this.spent = spent != null ? spent : BigDecimal.ZERO;
    }


    public boolean isOverBudget() {
        return spent.compareTo(limitAmount) > 0;
    }

    public BigDecimal getRemainingBudget() {
        return limitAmount.subtract(spent);
    }

    public BigDecimal getPercentageUsed() {
        if (limitAmount.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        return spent.multiply(new BigDecimal("100")).divide(limitAmount, 2, BigDecimal.ROUND_HALF_UP);
    }
}
