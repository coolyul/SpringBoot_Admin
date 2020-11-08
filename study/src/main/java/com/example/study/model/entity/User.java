package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data       // 객체로 사용해줄거기때문에 (엔티티) 써줌
@AllArgsConstructor     // 모든 생성자 만들어줄수있는 어노테이션
@NoArgsConstructor      // 위 세줄은 기본 생성자들 생성

@Entity  // = table임을 나타내줌!

public class User {

    @Id     // 기본키이기때문에 붙여줌. 식별자
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // mysql은 Identity 타입으로 해줌. 관리 전략!
    private Long id;

//    @Column(name = "account") 컬럼 이름이 내가 만들어준것과 다르면 이거 해주면 됨.
    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;




//      연습용
//    // 유저 입장에서 자신은 1, 주문내역은 N ( 1:N )
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")       // 여기서 user는 Orderdetail 변수 이름과 같아야함
//
//    // USer라는 클래스에서는 OrderDetail 안의 User라는 변수 안에 매칭시키겠ㄷ
//    private List<OrderDetail> orderDetailList;
}
