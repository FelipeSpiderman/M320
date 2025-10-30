package edu.tbz.m4project.M4.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Create a new user
     * 
     * @param user the user to create
     * @return the created user
     */
    public User createUser(User user) {
        // Check if email already exists
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Set default values if needed
        if (user.getAdmin() == null) {
            user.setAdmin(false);
        }

        return userRepository.save(user);
    }

    /**
     * Get a user by ID
     * 
     * @param id the user ID
     * @return the user
     * @throws RuntimeException if the user is not found
     */
    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    /**
     * Get a user by email
     * 
     * @param email the user email
     * @return the user
     * @throws RuntimeException if the user is not found
     */
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    /**
     * Get all users
     * 
     * @return a list of all users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Get users by name
     * 
     * @param name the name to search for
     * @return a list of users with the given name
     */
    public List<User> getUsersByName(String name) {
        return userRepository.findByName(name);
    }

    /**
     * Get admin users
     * 
     * @return a list of admin users
     */
    public List<User> getAdminUsers() {
        return userRepository.findByAdmin(true);
    }

    /**
     * Update a user
     * 
     * @param id the user ID
     * @param updatedUser the updated user data
     * @return the updated user
     * @throws RuntimeException if the user is not found
     */
    public User updateUser(Integer id, User updatedUser) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check if email is being changed and if it already exists
        if (!existingUser.getEmail().equals(updatedUser.getEmail())) {
            Optional<User> userWithEmail = userRepository.findByEmail(updatedUser.getEmail());
            if (userWithEmail.isPresent() && !userWithEmail.get().getUserId().equals(id)) {
                throw new IllegalArgumentException("Email already exists");
            }
        }

        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setAdmin(updatedUser.getAdmin());

        return userRepository.save(existingUser);
    }

    /**
     * Delete a user
     * 
     * @param id the user ID
     */
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
