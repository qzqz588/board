package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

    /**
     * 유효성 검사 - 중복 체크
     * @param email 회원 이메일
     * @return
     */
    boolean existsByEmail(String email);
}
