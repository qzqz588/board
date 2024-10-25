package com.example.demo.controller;

import com.example.demo.DTO.MemberResponseDTO;
import com.example.demo.service.MemberService;
import com.example.demo.validator.CheckEmailValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final CheckEmailValidator checkEmailValidator;

    @GetMapping("/")
    public String home() {
        return "main";
    }


    @GetMapping("/members")
    public String createMember(MemberResponseDTO memberResponseDTO) {
        return "members/new";
    }

    /**
     * 회원 가입 post
     *
     * @param memberResponseDTO 회원 정보
     * @return 홈페이지
     */
    @PostMapping("/members/new")
    public String createMember(@Valid MemberResponseDTO memberResponseDTO, Errors errors, Model model) {
        /* 검증 */
        if (errors.hasErrors()) {
            /* 회원가입 실패 시 입력 데이터 유지 */
            model.addAttribute("dto", memberResponseDTO);

            /* 유효성 검사를 통과하지 못한 필드와 메세지 핸들링 */
            Map<String, String> validatorResult = memberService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }

            /* 회원가입 페이지로 리턴 */
            return "/members/new";

        }
        Long memberId = memberService.join(memberResponseDTO);
        return "login";
    }
}
