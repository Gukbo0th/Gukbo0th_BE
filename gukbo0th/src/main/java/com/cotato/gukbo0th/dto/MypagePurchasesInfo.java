package com.cotato.gukbo0th.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class MypagePurchasesInfo {
    LocalDateTime purchases_at;
    String person;
    Long amount;
    Long quantity;
    String title;

}
