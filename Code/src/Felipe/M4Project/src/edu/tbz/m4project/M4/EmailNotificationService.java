package edu.tbz.m4project.M4;

import edu.tbz.m4project.M4.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Service
public class EmailNotificationService implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Notification sendNotification(User user, String message) {
        System.out.println("Sending email to " + user.getEmail() + ": " + message);

        Notification notification = new Notification(user, message);
        return notificationRepository.save(notification);
    }

    @Override
    public Notification sendBudgetAlert(Budget budget, double percentageUsed) {
        User user = budget.getUser();
        String categoryName = budget.getCategory() != null ? budget.getCategory().getName() : "General";
        DecimalFormat df = new DecimalFormat("#.##");

        String message = "ALERT: You have used " + df.format(percentageUsed) + "% of your " + 
                         categoryName + " budget. Limit: " + budget.getLimitAmount() + 
                         ", Spent: " + budget.getSpent();

        return sendNotification(user, message);
    }

    @Override
    public Notification sendBudgetExceededAlert(Budget budget) {
        User user = budget.getUser();
        String categoryName = budget.getCategory() != null ? budget.getCategory().getName() : "General";
        BigDecimal overAmount = budget.getSpent().subtract(budget.getLimitAmount());

        String message = "WARNING: You have exceeded your " + categoryName + " budget by " + 
                         overAmount + ". Limit: " + budget.getLimitAmount() + 
                         ", Spent: " + budget.getSpent();

        return sendNotification(user, message);
    }
}
