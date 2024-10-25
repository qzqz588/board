package com.example.demo.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 추상 클래스: 특정 DTO나 엔티티의 검증 로직을 정의하기 위한 기본 구조를 제공.
 * 실제 검증 로직은 이 클래스를 상속받은 클래스에서 구현해야 함.
 * Validator 인터페이스를 구현하여 스프링에서 유효성 검증을 지원.
 */
@Slf4j // 로그 객체(log)를 자동으로 생성하여, 로깅을 위한 편의성을 제공하는 Lombok 어노테이션
public abstract class AbstractValidator<T> implements Validator {

    /**
     * supports() 메서드는 현재 Validator가 특정 클래스에서 사용할 수 있는지를 판단하는 메서드.
     * 여기서는 기본적으로 모든 클래스에 대해 검증을 지원하도록 설정 (항상 true 반환).
     *
     * @param clazz 검증하려는 클래스 타입
     * @return 항상 true 반환 (모든 클래스 검증 가능)
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }


    @SuppressWarnings("unchecked") // 제네릭 타입 캐스팅과 관련된 컴파일 경고를 억제
    @Override
    public void validate(Object target, Errors errors) {
        try {
            // target 객체를 제네릭 타입 T로 캐스팅 후, doValidate 메서드를 통해 검증 로직 실행
            doValidate((T) target, errors);
        } catch (RuntimeException e) {
            // 검증 중 예외 발생 시, 로그에 에러 메시지와 스택 트레이스 기록
            log.error("중복 검증 에러", e);
            // 예외를 다시 던져 상위에서 처리하도록 함
            throw e;
        }
    }
    protected abstract void doValidate(final T dto, final Errors errors);
}

