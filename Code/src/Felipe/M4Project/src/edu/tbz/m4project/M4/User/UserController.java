package edu.tbz.m4project.M4.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Create a new user
     * 
     * @param user the user to create
     * @return the created user
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User createdUser = userService.createUser(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Get a user by ID
     * 
     * @param id the user ID
     * @return the user
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        try {
            User user = userService.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Get all users
     * 
     * @param name the name to filter by (optional)
     * @param admin the admin status to filter by (optional)
     * @return a list of users
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Boolean admin) {

        List<User> users;

        if (name != null && !name.isEmpty()) {
            users = userService.getUsersByName(name);
        } else if (admin != null && admin) {
            users = userService.getAdminUsers();
        } else {
            users = userService.getAllUsers();
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * Update a user
     * 
     * @param id the user ID
     * @param user the updated user data
     * @return the updated user
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
        try {
            User updatedUser = userService.updateUser(id, user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (RuntimeException e) {
            if (e instanceof IllegalArgumentException) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete a user
     * 
     * @param id the user ID
     * @return no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
