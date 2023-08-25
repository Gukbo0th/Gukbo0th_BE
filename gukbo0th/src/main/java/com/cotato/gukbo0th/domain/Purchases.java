package com.cotato.gukbo0th.domain;

import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Purchases")
public class Purchases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchases_id")
    private Long id; // 구매ID

    @CreatedDate
    @Column(name = "purchases_at", nullable = false)
    private LocalDateTime purchasesAt; // 구매 날짜

    @Column(nullable = false)
    private String person; // 선택한 위인 이름

    @Column(nullable = false)
    private Long amount; // 펀딩 금액

    @Column(nullable = false)
    private Long quantity; // 펀딩 수량

    @ManyToOne
    @JoinColumn(name = "members_id")
    private Members members; // 연관관계 주인

    @ManyToOne
    @JoinColumn(name = "fundings_id")
    private Fundings fundings; // 연관관계 주인

    @Builder
    public Purchases(String person, Long amount, Long quantity, Members members, Fundings fundings) {
        this.person = person;
        this.amount = amount;
        this.quantity = quantity;
        this.members = members;
        this.fundings = fundings;
    }
}
