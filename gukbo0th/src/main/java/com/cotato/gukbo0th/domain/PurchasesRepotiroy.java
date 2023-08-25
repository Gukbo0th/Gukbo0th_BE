package com.cotato.gukbo0th.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchasesRepotiroy extends JpaRepository<Purchases, Long> {
    List<Purchases> findAllByMembers(Members members);
}
