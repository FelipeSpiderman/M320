package edu.tbz.m4project.M4;

import edu.tbz.m4project.M4.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Integer> {

    /**
     * Find budgets by user
     * 
     * @param user the user to search for
     * @return a list of budgets for the given user
     */
    List<Budget> findByUser(User user);

    /**
     * Find budgets by category
     * 
     * @param category the category to search for
     * @return a list of budgets for the given category
     */
    List<Budget> findByCategory(Category category);

    /**
     * Find a budget by user and category
     * 
     * @param user the user to search for
     * @param category the category to search for
     * @return an Optional containing the budget if found
     */
    Optional<Budget> findByUserAndCategory(User user, Category category);

    /**
     * Find budgets where spent amount is greater than limit amount (over budget)
     * 
     * @return a list of budgets that are over their limit
     */
    @org.springframework.data.jpa.repository.Query("SELECT b FROM Budget b WHERE b.spent > b.limitAmount")
    List<Budget> findOverBudget();

    /**
     * Find budgets by user where spent amount is greater than limit amount (over budget)
     * 
     * @param user the user to search for
     * @return a list of budgets for the given user that are over their limit
     */
    @org.springframework.data.jpa.repository.Query("SELECT b FROM Budget b WHERE b.user = ?1 AND b.spent > b.limitAmount")
    List<Budget> findOverBudgetByUser(User user);

    /**
     * Find budgets by limit amount greater than or equal to the given amount
     * 
     * @param amount the minimum limit amount
     * @return a list of budgets with limit amounts greater than or equal to the given amount
     */
    List<Budget> findByLimitAmountGreaterThanEqual(BigDecimal amount);

    /**
     * Find budgets by income greater than or equal to the given amount
     * 
     * @param amount the minimum income amount
     * @return a list of budgets with incomes greater than or equal to the given amount
     */
    List<Budget> findByIncomeGreaterThanEqual(BigDecimal amount);
}
