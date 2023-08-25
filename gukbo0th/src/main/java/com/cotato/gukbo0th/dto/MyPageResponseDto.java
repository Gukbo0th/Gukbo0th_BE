package com.cotato.gukbo0th.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class MyPageResponseDto {

    String email;
    String name;
    List<MypagePurchasesInfo> purchasesInfo;

}
