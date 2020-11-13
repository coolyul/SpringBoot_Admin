package com.example.study.model.network.response;

import com.example.study.model.entity.OrderGroup;
import com.example.study.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class UserOrderInfoApiResponse { // 사용자 주문 정보 한번에 조회하는 Api!

    private UserApiResponse userApiResponse;

}
