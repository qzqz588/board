package com.example.demo.domain;


import groovy.transform.builder.Builder;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data //Getter&Setter
@Builder //Dto -> column화
@AllArgsConstructor //모든 컬럼 생성자 생성
@NoArgsConstructor //기본 생성자
@Table(name = "member")

public class Member {
    @Id // 내가 pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 id 생성
    private Long id;

    @Column(nullable = false,unique = true)
    private String email;

    @Column
    private String name;

    @Column(nullable = false)
    private String password;
}
