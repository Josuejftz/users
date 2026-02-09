package org.example.users.repository;

import org.example.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // No necesitas escribir código aquí, JPA ya sabe qué hacer.
}