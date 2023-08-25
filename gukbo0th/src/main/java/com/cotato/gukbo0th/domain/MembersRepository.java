package com.cotato.gukbo0th.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<Members, Long> {
    Members findByEmail(String email);
//    Optional<Members> findByEmail(String email);
    boolean existsByEmail(String email);

}
