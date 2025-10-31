package edu.tbz.m4project.M4;

import edu.tbz.m4project.M4.User.User;

public class RegularUser extends User {

    public RegularUser() {
        super();
        setAdmin(false);
    }

    public RegularUser(String name, String email) {
        super(name, email, false);
    }
}
