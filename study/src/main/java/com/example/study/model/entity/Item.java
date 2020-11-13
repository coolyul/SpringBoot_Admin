package com.example.study.model.entity;

import com.example.study.model.enumclass.ItemStatus;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor      // Data부터 세 줄은 기본으로 가져가는 어노테이션!
@Entity
@ToString(exclude = {"orderDetailList", "partner"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class Item {     // mysql에서 만들었던 컬럼과 똑같이 만들어주면 됨.

    @Id         // 기본키니까 해주기
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // mysql의 strategy!
    private Long id;

    @Enumerated(EnumType.STRING)
    private ItemStatus status;

    private String name;

    private String title;

    private String content;

    private BigDecimal price;

    private String brandName;     // NotNull 아니어도 됨. 부가설명!

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


    // item N : Partner 1
    @ManyToOne
    private Partner partner;
//    private Long partnerId;


    // item 1 : OrderDetail N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")       // orderDetail의 item
    private List<OrderDetail> orderDetailList;










//    private int itemId;

//    // 아이템 입장에서 orderDetail은 많고 자신은 1 ( 1:N )
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")       // OrderDetail에 있는 Item item 변수에 매칭시키겠다!
//    private List<OrderDetail> orderDetailList;

    /*
    * fetch 타입 - Lazy, Eager 타입 두 개가 잇음
    * LAZY = 지연 로딩, EAGER = 즉시 로딩
    * LAZY = SELECT * FROM item where id = ? 이런 식으로 찾아오는 반면
    * EAGER = SELECT * FROM item_id = order_detail.item_id user_id = order.....~`
    *
    * LAZY - 우리가 메소드를 따로 호출하지 않는 이상 연관관계가 설정된 테이블에 대해 셀렉트를 하지 않겠다
    * EAGER - 즉시 모든걸 다 로딩. 연관관계 설정된 모든 테이블에 대해 조인이 일어남
    * 데이터가 많은 테이블에 대해 EAGER 타입으로 fetch 하면 모든 관련 데이터 다 가져와버림
    * 그래서 성능 저하, 오류 등의 위험이 있기 때문에 데이터가 많으면 LAZY로 해야함
    *
    * EAGER = 1:1 방식!
    * LAZY = 1:N, N:1, N:N
    *
    *
    * */
}
