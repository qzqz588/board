package com.example.demo.lmpl;

import com.example.demo.DTO.MemberFormDTO;
import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;

@Service //내가 서비스다
@RequiredArgsConstructor //밑에 MemberRepository의 생성자를 쓰지 않기 위해서

public class MemberServicelmpl implements MemberService {


    private final MemberRepository memberRepository;

    @Override
    public Long join(MemberFormDTO memberFormDTO) {
        Member member = Member.builder()
                .email(memberFormDTO.getEmail())
                .username(memberFormDTO.getUsername())
                .password(memberFormDTO.getPassword())
                .build();
        return memberRepository.save(member).getId();
    }
}
