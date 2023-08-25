package com.cotato.gukbo0th.dto;

import com.cotato.gukbo0th.domain.Fundings;
import com.cotato.gukbo0th.domain.State;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FundingsDetailResponseDto {
    private Long fundings_id; // 펀딩 고유 번호
    private String main_img_url; // 대표 이미지 URL
    private String title; // 펀딩 제목
    private Long amount; // 개별 상품 금액
    private State state; // 펀딩 상태
    private String prod_img_url; // 상세 이미지 URL
    private String details; // 상세 설명
    private Long funds; // 누적 펀딩 금액
    private Long goal_amount; // 목표 금액
    private List<PersonsInfo> personsInfoList = new ArrayList<>();

    @Builder
    public FundingsDetailResponseDto(Fundings fundings, List<PersonsInfo> personsInfoList) {
        this.fundings_id = fundings.getId();
        this.main_img_url = fundings.getMainImg();
        this.title = fundings.getTitle();
        this.amount = fundings.getProdAmount();
        this.state = fundings.getState();
        this.prod_img_url = fundings.getProdImg();
        this.details = fundings.getDetails();
        this.funds = fundings.getFundsAmount();
        this.goal_amount = fundings.getGoalAmount();
        this.personsInfoList = personsInfoList;
    }
}
