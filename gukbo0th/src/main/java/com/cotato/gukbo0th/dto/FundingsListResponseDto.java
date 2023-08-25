package com.cotato.gukbo0th.dto;

import com.cotato.gukbo0th.domain.Fundings;
import com.cotato.gukbo0th.domain.State;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FundingsListResponseDto {
    private Long fundingsId; // 펀딩 고유 번호
    private String mainImg; // 대표 이미지 URL
    private String title; // 펀딩 제목
    private Long amount; // 개별 상품 금액
    private State state; // 펀딩 상태

    @Builder
    public FundingsListResponseDto(Fundings fundings) {
        this.fundingsId = fundings.getId();
        this.mainImg = fundings.getMainImg();
        this.title = fundings.getTitle();
        this.amount = fundings.getProdAmount();
        this.state = fundings.getState();
    }
}
