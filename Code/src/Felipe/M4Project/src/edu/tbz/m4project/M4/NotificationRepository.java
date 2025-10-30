package edu.tbz.m4project.M4;

import edu.tbz.m4project.M4.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    
    /**
     * Find notifications by user
     * 
     * @param user the user to search for
     * @return a list of notifications for the given user
     */
    List<Notification> findByUser(User user);
    
    /**
     * Find notifications by user ordered by creation date (descending)
     * 
     * @param user the user to search for
     * @return a list of notifications for the given user ordered by creation date (newest first)
     */
    List<Notification> findByUserOrderByCreatedAtDesc(User user);
    
    /**
     * Find notifications by creation date range
     * 
     * @param startDate the start date
     * @param endDate the end date
     * @return a list of notifications within the given date range
     */
    List<Notification> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
    
    /**
     * Find notifications by user and creation date range
     * 
     * @param user the user to search for
     * @param startDate the start date
     * @param endDate the end date
     * @return a list of notifications for the given user within the given date range
     */
    List<Notification> findByUserAndCreatedAtBetween(User user, LocalDateTime startDate, LocalDateTime endDate);
    
    /**
     * Find notifications by message containing the given string (case-insensitive)
     * 
     * @param message the message substring to search for
     * @return a list of notifications with messages containing the given string
     */
    List<Notification> findByMessageContainingIgnoreCase(String message);
    
    /**
     * Delete notifications older than the given date
     * 
     * @param date the cutoff date
     */
    void deleteByCreatedAtBefore(LocalDateTime date);
}