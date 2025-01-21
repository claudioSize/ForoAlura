package org.example.foroalura.Repository;

import org.example.foroalura.Entitys.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Integer> {
    boolean existsByTopicsEntityId(Integer id);
    void deleteByTopicsEntityId(Integer id);
    List<AnswerEntity> findAnswerEntitiesByTopicsEntityId(Integer id);
}
