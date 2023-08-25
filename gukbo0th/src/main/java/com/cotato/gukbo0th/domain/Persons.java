package com.cotato.gukbo0th.domain;

import javax.persistence.*;

@Entity
@Table(name = "Persons")
public class Persons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persons_id")
    private Long id; // 위인ID

    @Column(nullable = false)
    private String name; // 위인 이름

    @Column(nullable = false)
    private String achieve; // 업적

    @ManyToOne
    @JoinColumn(name = "fundings_id")
    private Fundings fundings; // 연관관계 주인

    // 빌더 패턴 작성해주세요
}
