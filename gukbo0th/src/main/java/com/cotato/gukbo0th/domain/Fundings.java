package com.cotato.gukbo0th.domain;

import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Fundings")
public class Fundings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fundings_id")
    private Long id; // 펀딩 ID

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt; // 펀딩 등록 날짜

    @Column(nullable = false)
    private String title; // 펀딩 제목

    @Column(name = "goal_amount", nullable = false)
    private Long goalAmount; // 목표 펀딩 금액

    @Column(name = "prod_amount", nullable = false)
    private Long prodAmount; // 개별 상품 금액

    @Column(nullable = false)
    private String details; // 상세 설명
    
    @Column(nullable = false)
    private State state; // 펀딩 상태
    
    @Column(nullable = false)
    private Long remain; // 잔여 수량

    @Column(name = "main_img_url")
    private String mainImg; // 대표 이미지 URL

    @Column(name = "prod_img_url")
    private String prodImg; // 상세 이미지 URL

    @OneToMany(mappedBy = "members", fetch = FetchType.LAZY)
    private Purchases purchases; // 양방향 매핑

    @OneToMany(mappedBy = "members", fetch = FetchType.LAZY)
    private Persons persons; // 양방향 매핑
    
    @Builder
    public Fundings(String title, Long goalAmount, Long prodAmount, String details, State state, Long remain,
                    String mainImg, String prodImg) {
        this.title = title;
        this.goalAmount = goalAmount;
        this.prodAmount = prodAmount;
        this.details = details;
        this.state = state;
        this.remain = remain;
        this.mainImg = mainImg;
        this.prodImg = prodImg;
    }

}
