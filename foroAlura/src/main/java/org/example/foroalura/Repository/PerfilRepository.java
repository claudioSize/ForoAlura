package org.example.foroalura.Repository;

import org.example.foroalura.Entitys.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<PerfilEntity, Integer> {
    boolean existsByName(String name);
    PerfilEntity findByName(String name);
}
