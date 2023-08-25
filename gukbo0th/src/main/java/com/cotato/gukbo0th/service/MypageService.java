package com.cotato.gukbo0th.service;

import com.cotato.gukbo0th.domain.Members;
import com.cotato.gukbo0th.domain.MembersRepository;
import com.cotato.gukbo0th.domain.Purchases;
import com.cotato.gukbo0th.domain.PurchasesRepotiroy;
import com.cotato.gukbo0th.dto.MyPageResponseDto;
import com.cotato.gukbo0th.dto.MypagePurchasesInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MypageService {

    private final MembersRepository membersRepository;
    private final PurchasesRepotiroy purchasesRepotiroy;

    public MyPageResponseDto getMemberInfo(String email) {
        // 이메일 기반 회원 정보 DB 조회
        Members members = membersRepository.findByEmail(email);
        // 구매 상품 DB 조회
        List<Purchases> purchasesList = purchasesRepotiroy.findAllByMembers(members);
        List<MypagePurchasesInfo> mypagePurchasesInfos = new ArrayList<>();

        for (Purchases p : purchasesList) {
            MypagePurchasesInfo info = MypagePurchasesInfo.builder()
                    .title(p.getFundings().getTitle())
                    .quantity(p.getQuantity())
                    .amount(p.getAmount())
                    .person(p.getPerson())
                    .purchases_at(p.getPurchasesAt()).build();
            mypagePurchasesInfos.add(info);
        }

        MyPageResponseDto myPageResponseDto = MyPageResponseDto.builder()
                .email(members.getEmail())
                .name(members.getName())
                .purchasesInfo(mypagePurchasesInfos)
                .build();

        return myPageResponseDto;

    }
}
