package com.example.study.model.network.requst;

import com.example.study.model.enumclass.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserApiRequest {
    // user의 요청이 오는걸 처리하는 클래스!!
    // 이메일 폰넘버 등등.. 헤더 부분과는 달리 공통이 아니라 다 다른 요청!
    // 변수에 대해서는 카멜케이스~
    // Create Request 먼저!
    // 해당 데이터를 처리하고 이런 정보들을 내려주겠다 하는 식.

    private Long id;

    private String account;

    private String password;

    private UserStatus status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;
}
