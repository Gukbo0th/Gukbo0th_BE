package com.cotato.gukbo0th.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonsRepository extends JpaRepository<Persons, Long> {
    List<Persons> findByFundings(Fundings fundings);
}
