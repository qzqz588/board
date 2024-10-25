package com.example.demo.service;
import com.example.demo.DTO.MemberResponseDTO;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.Map;

public interface MemberService {
    /**
     * 회원가입 시, 유효성 및 중복 검사
//     * @param errors
     * @return
     */
    Map<String, String> validateHandling(Errors errors);
    Long join(MemberResponseDTO memberResponseDTO);
    List<MemberResponseDTO> findMembers();
}
