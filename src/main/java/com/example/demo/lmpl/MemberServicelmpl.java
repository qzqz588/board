package com.example.demo.lmpl;

import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


public class MemberServicelmpl implements MemberService {

    @Service //내가 서비스다
    @RequiredArgsConstructor //밑에 MemberRepository의 생성자를 쓰지 않기 위해서
}
