package org.example.foroalura.Repository;

import org.example.foroalura.Entitys.TopicsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicsRepository extends JpaRepository<TopicsEntity, Integer> {

    boolean existsByMessage(String message);
    boolean existsByTitle(String title);
    TopicsEntity findByTitle(String title);
}
