package edu.tbz.m4project.M4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.tbz.m4project.M4.User.User;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ExpenseManager {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private StrategyCategorizer strategyCategorizer;

    public Expense addExpense(Expense expense) {
        Expense savedExpense = expenseRepository.save(expense);

        Budget budget = budgetRepository.findByUserAndCategory(expense.getUser(), expense.getCategory())
                .orElse(null);

        if (budget != null) {
            budget.setSpent(budget.getSpent().add(expense.getAmount()));
            budgetRepository.save(budget);

            if (budget.isOverBudget()) {
                notificationService.sendBudgetExceededAlert(budget);
            } else {
                BigDecimal percentageUsed = budget.getPercentageUsed();
                if (percentageUsed.compareTo(new BigDecimal("80")) >= 0) {
                    notificationService.sendBudgetAlert(budget, percentageUsed.doubleValue());
                }
            }
        }

        return savedExpense;
    }

    public List<Expense> getUserExpenses(User user) {
        return expenseRepository.findByUser(user);
    }

    public List<Expense> getUserExpensesByCategory(User user, Category category) {
        return expenseRepository.findByUserAndCategory(user, category);
    }
}
