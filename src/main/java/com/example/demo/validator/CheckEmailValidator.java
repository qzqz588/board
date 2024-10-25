package com.example.demo.validator;


import com.example.demo.DTO.MemberResponseDTO;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
@RequiredArgsConstructor
public class CheckEmailValidator extends AbstractValidator<MemberResponseDTO> {

    private final MemberRepository memberRepository;

    @Override
    protected void doValidate(MemberResponseDTO dto, Errors errors) {
        if (memberRepository.existsByEmail(dto.getEmail())) {
            errors.rejectValue("email,","이메일 중복 오류","이미 사용중인 이메일 입니다.");
        }
    }
}
