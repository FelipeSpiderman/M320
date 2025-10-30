package edu.tbz.m4project.M4;

import edu.tbz.m4project.M4.User.User;

/**
 * Admin user class - extends User with admin privileges
 */
public class Admin extends User {

    public Admin() {
        super();
        setAdmin(true);
    }

    public Admin(String name, String email) {
        super(name, email, true);
    }
}
