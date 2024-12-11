package com.dpertsin.security.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
    * This interface is used to interact with the database.
    * It extends JpaRepository to provide basic CRUD operations.
    * It has a method to find a user by email.
 */

public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * The main class for the SecurityApplication.
     * This class is responsible for bootstrapping the Spring Boot application.
     */
    Optional<User> findByEmail(String email); // We use email because it is unique
}
