package com.cotato.gukbo0th.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
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

    @Builder
    public Persons(String name, String achieve, Fundings fundings) {
        this.name = name;
        this.achieve = achieve;
        this.fundings = fundings;
    }
}
