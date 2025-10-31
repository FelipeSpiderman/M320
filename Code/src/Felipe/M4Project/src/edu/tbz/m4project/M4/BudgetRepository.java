package edu.tbz.m4project.M4;

import edu.tbz.m4project.M4.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Integer> {

    List<Budget> findByUser(User user);

    List<Budget> findByCategory(Category category);

    Optional<Budget> findByUserAndCategory(User user, Category category);

    @org.springframework.data.jpa.repository.Query("SELECT b FROM Budget b WHERE b.spent > b.limitAmount")
    List<Budget> findOverBudget();

    @org.springframework.data.jpa.repository.Query("SELECT b FROM Budget b WHERE b.user = ?1 AND b.spent > b.limitAmount")
    List<Budget> findOverBudgetByUser(User user);

    List<Budget> findByLimitAmountGreaterThanEqual(BigDecimal amount);

    List<Budget> findByIncomeGreaterThanEqual(BigDecimal amount);
}
