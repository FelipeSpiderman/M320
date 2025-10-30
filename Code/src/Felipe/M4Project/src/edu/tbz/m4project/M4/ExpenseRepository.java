package edu.tbz.m4project.M4;

import edu.tbz.m4project.M4.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    
    /**
     * Find expenses by user
     * 
     * @param user the user to search for
     * @return a list of expenses for the given user
     */
    List<Expense> findByUser(User user);
    
    /**
     * Find expenses by category
     * 
     * @param category the category to search for
     * @return a list of expenses for the given category
     */
    List<Expense> findByCategory(Category category);
    
    /**
     * Find expenses by user and category
     * 
     * @param user the user to search for
     * @param category the category to search for
     * @return a list of expenses for the given user and category
     */
    List<Expense> findByUserAndCategory(User user, Category category);
    
    /**
     * Find expenses by date range
     * 
     * @param startDate the start date
     * @param endDate the end date
     * @return a list of expenses within the given date range
     */
    List<Expense> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    
    /**
     * Find expenses by user and date range
     * 
     * @param user the user to search for
     * @param startDate the start date
     * @param endDate the end date
     * @return a list of expenses for the given user within the given date range
     */
    List<Expense> findByUserAndDateBetween(User user, LocalDateTime startDate, LocalDateTime endDate);
    
    /**
     * Find expenses by amount greater than or equal to the given amount
     * 
     * @param amount the minimum amount
     * @return a list of expenses with amounts greater than or equal to the given amount
     */
    List<Expense> findByAmountGreaterThanEqual(BigDecimal amount);
    
    /**
     * Find expenses by description containing the given string (case-insensitive)
     * 
     * @param description the description substring to search for
     * @return a list of expenses with descriptions containing the given string
     */
    List<Expense> findByDescriptionContainingIgnoreCase(String description);
}