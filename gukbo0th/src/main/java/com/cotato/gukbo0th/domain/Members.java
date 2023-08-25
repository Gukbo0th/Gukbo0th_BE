package com.cotato.gukbo0th.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Members")
@NoArgsConstructor
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
    private List<Purchases> purchases; // 양방향 매핑

    @Builder
    public Members(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

}
