package com.cotato.gukbo0th.domain;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "Members")
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "members_id")
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "members", fetch = FetchType.LAZY)
    private Purchases purchases; // 양방향 매핑

    @Builder
    public Members(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

}
