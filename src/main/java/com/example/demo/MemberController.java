package com.example.demo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //해당 클래스가 Controller임을 알리기위함
@RequiredArgsConstructor //나중에 의존관계에 필요한 어노테이션


public class MemberController {

    @GetMapping
    public String home(){
        return "home";
    }
}
