package org.example.foroalura.Repository;

import org.example.foroalura.Entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    boolean existsByEmail(String email);
    UserDetails findByName(String user);
}
