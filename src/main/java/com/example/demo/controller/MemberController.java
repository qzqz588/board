package com.example.demo.controller;

import com.example.demo.DTO.MemberFormDTO;
import com.example.demo.lmpl.MemberServicelmpl;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/")
    public String home(){
        return "main";
    }

    @PostMapping ("/members/new")
    public String CreateMember(MemberFormDTO memberFormDTO) {
        Long memberId = memberService.join(memberFormDTO);
        return "home";
    }


}
