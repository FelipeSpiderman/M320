package edu.tbz.m4project.M4.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users", schema = "financetracker")
public class User {

    @Id
    @Column(name = "userid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;    

    @Column(nullable = false)
    private Boolean admin = false;

    // Constructors
    public User() {}

    public User(String name, String email, Boolean admin) {
        this.name = name;
        this.email = email;
        this.admin = admin != null ? admin : false;
    }

    // Getters and Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
