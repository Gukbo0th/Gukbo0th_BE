package com.cotato.gukbo0th.service;

import com.cotato.gukbo0th.domain.Members;
import com.cotato.gukbo0th.domain.MembersRepository;
import com.cotato.gukbo0th.dto.MemberJoinRequest;
import com.cotato.gukbo0th.dto.MemberLoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MembersRepository membersRepository;
    private final Members members;

    public MemberResponse join(MemberJoinRequest memberJoinRequest) {
        //중복 체크
        if (membersRepository.existsByEmail(memberJoinRequest.getEmail())) {
            return null;
        }else {
            Members members = new Members(memberJoinRequest.getName(), memberJoinRequest.getEmail(), memberJoinRequest.getPassword());
            return membersRepository.save(members);
        }
    }

    public Members login(MemberLoginRequest memberLoginRequest) {
        if (!membersRepository.existsByEmail(memberLoginRequest.getEmail())) {
            return null;
        } else {
            Long memberId = membersRepository.findByEmail(memberLoginRequest.getEmail()).getId();
            if (membersRepository.findById(memberId).getPassword() != memberLoginRequest.getPassword()) {
                return null;
            }
    }
}
