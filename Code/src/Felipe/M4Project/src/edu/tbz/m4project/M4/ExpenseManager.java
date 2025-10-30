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

    // Using strategy pattern for expense categorization
    @Autowired
    private StrategyCategorizer strategyCategorizer;

    /**
     * Add a new expense
     * 
     * @param expense the expense to add
     * @return the saved expense
     */
    public Expense addExpense(Expense expense) {
        // Save the expense
        Expense savedExpense = expenseRepository.save(expense);

        // Update budget if exists
        Budget budget = budgetRepository.findByUserAndCategory(expense.getUser(), expense.getCategory())
                .orElse(null);

        if (budget != null) {
            // Update spent amount
            budget.setSpent(budget.getSpent().add(expense.getAmount()));
            budgetRepository.save(budget);

            // Check if budget is exceeded
            if (budget.isOverBudget()) {
                notificationService.sendBudgetExceededAlert(budget);
            } else {
                // Check if approaching budget limit (e.g., 80%)
                BigDecimal percentageUsed = budget.getPercentageUsed();
                if (percentageUsed.compareTo(new BigDecimal("80")) >= 0) {
                    notificationService.sendBudgetAlert(budget, percentageUsed.doubleValue());
                }
            }
        }

        return savedExpense;
    }

    /**
     * Get all expenses for a user
     * 
     * @param user the user
     * @return a list of expenses
     */
    public List<Expense> getUserExpenses(User user) {
        return expenseRepository.findByUser(user);
    }

    /**
     * Get expenses for a user in a specific category
     * 
     * @param user the user
     * @param category the category
     * @return a list of expenses
     */
    public List<Expense> getUserExpensesByCategory(User user, Category category) {
        return expenseRepository.findByUserAndCategory(user, category);
    }
}
