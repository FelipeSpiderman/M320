package edu.tbz.m4project.M4;

import edu.tbz.m4project.M4.User.User;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications", schema = "financetracker")
public class Notification {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notificationid")
    private Integer notificationId;
    
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;
    
    @Column(name = "message", nullable = false)
    private String message;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    public Notification() {}
    
    public Notification(User user, String message) {
        this.user = user;
        this.message = message;
    }

    public Integer getNotificationId() {
        return notificationId;
    }
    
    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}