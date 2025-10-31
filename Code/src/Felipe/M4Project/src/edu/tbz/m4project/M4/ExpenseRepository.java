package edu.tbz.m4project.M4;

import edu.tbz.m4project.M4.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    List<Expense> findByUser(User user);

    List<Expense> findByCategory(Category category);
    
    List<Expense> findByUserAndCategory(User user, Category category);

    List<Expense> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    
    List<Expense> findByUserAndDateBetween(User user, LocalDateTime startDate, LocalDateTime endDate);

    List<Expense> findByAmountGreaterThanEqual(BigDecimal amount);

    List<Expense> findByDescriptionContainingIgnoreCase(String description);
}