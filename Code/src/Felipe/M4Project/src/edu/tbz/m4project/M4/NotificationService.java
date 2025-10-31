package edu.tbz.m4project.M4;

import edu.tbz.m4project.M4.User.User;

public interface NotificationService {

    Notification sendNotification(User user, String message);

    Notification sendBudgetAlert(Budget budget, double percentageUsed);

    Notification sendBudgetExceededAlert(Budget budget);
}
