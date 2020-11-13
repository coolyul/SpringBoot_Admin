package com.example.study.model.network.response;

import com.example.study.model.enumclass.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserApiResponse {
    // User의 요청이 오면 처리하는 클래스!!
    // UserRequest와 따로 해주는 이유는, 같은 값이라도 다르게 보여주거나 암호화 할 수도 있고...
    private Long id;

    private String account;

    private String password;

    private UserStatus status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    // 유저의 주문 내역 한 번에 가져오기 위해 이거 일단 포함해줌
    private List<OrderGroupApiResponse> orderGroupApiResponsesList;
}
