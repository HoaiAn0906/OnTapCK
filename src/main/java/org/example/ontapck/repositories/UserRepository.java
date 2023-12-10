package org.example.ontapck.repositories;

import org.example.ontapck.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
