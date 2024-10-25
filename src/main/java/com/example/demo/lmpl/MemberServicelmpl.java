package com.example.demo.lmpl;

import com.example.demo.DTO.MemberResponseDTO;
import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service //내가 서비스다
@RequiredArgsConstructor //밑에 MemberRepository의 생성자를 쓰지 않기 위해서

public class MemberServicelmpl implements MemberService {
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }

    @Override
    public Long join(MemberResponseDTO memberResponseDTO) {
        Member member = Member.builder()
                .email(memberResponseDTO.getEmail())
                .username(memberResponseDTO.getUsername())
                .password(passwordEncoder.encode(memberResponseDTO.getPassword()))
                .build();
        return memberRepository.save(member).getId();
    }

    @Override
    public List<MemberResponseDTO> findMembers() {
        List<Member>all = memberRepository.findAll();
        List<MemberResponseDTO> members = new ArrayList<>();

        for(Member member :all){
            MemberResponseDTO build = MemberResponseDTO.builder()
                    .member(member)
                    .build();
                     members.add(build);


        }
    return members;
    }

}
