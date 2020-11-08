package com.example.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration          // 여기는 설정파일에 대한 것이 들어갑니다~ 하고 선언
@EnableJpaAuditing      // JPA 에 대해 감시를 활성화시키겠다!
public class JpaConfig {
    // 이 클래스는, 엔티티들의 공통된 값을 굳이 모든 엔티티마다 쓰는 게 아니라 편하게 하기 위해 만듦.
    // 예를들면 createdAt, createdBy, updatedAt, updatedBy 같은거!

}
