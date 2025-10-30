package edu.tbz.m4project.M4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
    /**
     * Find a category by name
     * 
     * @param name the name to search for
     * @return an Optional containing the category if found
     */
    Optional<Category> findByName(String name);
    
    /**
     * Find categories by name containing the given string (case-insensitive)
     * 
     * @param name the name substring to search for
     * @return a list of categories with names containing the given string
     */
    List<Category> findByNameContainingIgnoreCase(String name);
}