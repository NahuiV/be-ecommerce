package com.be.ecommerce.repositories;

import com.be.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByFirstNameEquals(String name);
    Optional<User> findUserByEmail(String name);
}
