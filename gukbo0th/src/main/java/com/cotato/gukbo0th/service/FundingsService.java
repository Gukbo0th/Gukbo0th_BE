package com.cotato.gukbo0th.service;

import com.cotato.gukbo0th.domain.*;
import com.cotato.gukbo0th.dto.CreditRequestDto;
import com.cotato.gukbo0th.dto.FundingsDetailResponseDto;
import com.cotato.gukbo0th.dto.FundingsListResponseDto;
import com.cotato.gukbo0th.dto.PersonsInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FundingsService {

    private final MembersRepository membersRepository;
    private final FundingsRepository fundingsRepository;
    private final PersonsRepository personsRepository;
    public List<FundingsListResponseDto> getList() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<Fundings> fundings = fundingsRepository.findAll(sort);
        List<FundingsListResponseDto> responseFundings = new ArrayList<>();

        for(Fundings f : fundings) {
            responseFundings.add(FundingsListResponseDto.builder().fundings(f).build());
        }

        return responseFundings;
    }

<<<<<<< Updated upstream
//    public FundingsDetailResponseDto getDetail(Long id) {
//    }
//
//    public FundingsDetailResponseDto credit(CreditRequestDto creditRequestDto) {
//    }
=======
    public FundingsDetailResponseDto getDetail(Long id) throws Exception {
        try {
            Fundings fundings = fundingsRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 펀딩 고유 번호"));
            List<Persons> persons = personsRepository.findByFundings(fundings);
            List<PersonsInfo> personsInfoList = new ArrayList<>();
            for(Persons p : persons) {
                personsInfoList.add(PersonsInfo.builder()
                        .name(p.getName())
                        .achieve(p.getAchieve())
                        .build());
            }
            return new FundingsDetailResponseDto(fundings,personsInfoList);
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public FundingsDetailResponseDto credit(CreditRequestDto creditRequestDto) {
    }
>>>>>>> Stashed changes
}
