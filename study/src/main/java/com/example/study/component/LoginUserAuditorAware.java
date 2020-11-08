package com.example.study.component;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginUserAuditorAware implements AuditorAware<String> {

    // Config를 쓰려면 컴포넌트 클래스를 만들어줘야 하나봄..로그인 시스템에서.
    // 상속받아야 하는 메소드가 아래거!
    // createdBy, updatedBy 변수에서 @createdBy, @LstModifiedBy 써주면 리턴값 자동으로 받음
    // 리턴값은 Optional.of("~~~)
    // 그리고 저 어노테이션 써주는 엔티티들에는
    // @EntityListeners(AuditingEntityListener.class) 어노테이션 추가해줘야 함.

    // 그럼 수정이 일어나면 이제 따로 수정 안해줘도 자동으로 수정됨!

    @Override
    public Optional<String> getCurrentAuditor() {   // 감시자 주는 것/
        return Optional.of("AdminServer");  // 지금 로그인시스템 없어서 임시로지정.
    }
}
