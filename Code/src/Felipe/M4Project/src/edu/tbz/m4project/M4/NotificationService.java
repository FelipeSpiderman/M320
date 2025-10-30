package edu.tbz.m4project.M4;

import edu.tbz.m4project.M4.User.User;

/**
 * Interface for notification services
 */
public interface NotificationService {

    /**
     * Send a notification to a user
     * 
     * @param user the user to notify
     * @param message the notification message
     * @return the created notification
     */
    Notification sendNotification(User user, String message);

    /**
     * Send a budget alert notification when a user is approaching their budget limit
     * 
     * @param budget the budget that is approaching its limit
     * @param percentageUsed the percentage of the budget that has been used
     * @return the created notification
     */
    Notification sendBudgetAlert(Budget budget, double percentageUsed);

    /**
     * Send a budget exceeded notification when a user has exceeded their budget limit
     * 
     * @param budget the budget that has been exceeded
     * @return the created notification
     */
    Notification sendBudgetExceededAlert(Budget budget);
}
