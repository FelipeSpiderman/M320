package edu.tbz.m4project.M4.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Find a user by email
     * 
     * @param email the email to search for
     * @return an Optional containing the user if found
     */
    Optional<User> findByEmail(String email);

    /**
     * Find users by name
     * 
     * @param name the name to search for
     * @return a list of users with the given name
     */
    List<User> findByName(String name);

    /**
     * Find users by admin status
     * 
     * @param admin the admin status to search for
     * @return a list of users with the given admin status
     */
    List<User> findByAdmin(Boolean admin);
}
