package io.github.lcsheerdt.infra.jpa;

import io.github.lcsheerdt.domain.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    Optional<PersonEntity> findByNameIgnoreCase(String nome);
}
