package com.example.study.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data                   // 객체로 사용해줄거기때문에 (엔티티) 써줌
@AllArgsConstructor     // 모든 생성자 만들어줄수있는 어노테이션
@NoArgsConstructor      // 위 세줄은 기본 생성자들 생성
@Entity                 // = table임을 나타내줌!
@ToString(exclude = {"orderGroupList"})     // ToString 할 때 orderGroup 제외하겠다
@EntityListeners(AuditingEntityListener.class)
@Builder                  // 이걸 적용하면 생성자 패턴으로 적용됨! userTest에서 확인!
@Accessors(chain = true)                    // 체이닝된 형태로 객체를 수정하거나 만들수있다! test에서 확인
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

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    // User : OrderGroup = 1 : N 유저는 한명이지만 오더는 여러개일 수 잇음!
    // 서로 상호참조하게 되면 Lombok에서 toString에서 계속 찍어서 overflow 일어남!
    // oneToMany 걸어준 대상에 대해 ToString(exclude = {"orderGroup"}) 해야함!
    // 연관관계 설정해주기
    // 리스트로 받아와야 하기 때문에 리스트로 해줌. 여러개니깐!

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderGroup> orderGroupList;





//      연습용
//    // 유저 입장에서 자신은 1, 주문내역은 N ( 1:N )
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")       // 여기서 user는 Orderdetail 변수 이름과 같아야함
//
//    // USer라는 클래스에서는 OrderDetail 안의 User라는 변수 안에 매칭시키겠다
//    private List<OrderDetail> orderDetailList;
}
