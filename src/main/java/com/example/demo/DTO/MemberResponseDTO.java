package com.example.demo.DTO;

import com.example.demo.domain.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MemberResponseDTO {

    @NotBlank(message = "이메일을 입력해주세요")
    @Email(message = "올바른 이메일 주소를 입력해주세요")
    private String email;

    @NotBlank(message = "닉네임을 입력해 주세요")
    @Size(min=2,max=15,message = "닉네임은 2~ 15글자로 설정해주세요")
    private String username;

    @NotBlank(message = "비밀번호를 입력해 주세요")
    private String password;
    @Builder
    public MemberResponseDTO(Member member){
        this.email=member.getEmail();
        this.username = member.getUsername();
    }
}
