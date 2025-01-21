package org.example.foroalura.Repository;

import org.example.foroalura.Entitys.CurseEntity;
import org.example.foroalura.Entitys.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurseRepository extends JpaRepository<CurseEntity, Integer> {
    boolean existsByName(String name);
    CurseEntity findByName(String name);
}
