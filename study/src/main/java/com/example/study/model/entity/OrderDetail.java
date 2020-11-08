package com.example.study.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {"orderGroup", "item"})
@EntityListeners(AuditingEntityListener.class)
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;


    // OrderDetail N : item 1    아이템 하나마다 주문이 여러개 있을 수 있음
    @ManyToOne
    private Item item;
//    private Long itemId;



    // OrderDetail N : OrderGroup 1
    @ManyToOne
    private OrderGroup orderGroup;      // orderDetail의 MappedBy와 일치!
//    private Long orderGroupId;

















//    // orderDetail 의 입장에서, 자신은 N이고 상대방이 1 (주문한 물건은 많고 주문자는 1명) ( N:1 )
//    @ManyToOne
//    private User user;      //  객체 타입으로 만들어줘야 함. 원래 user_id
//
//    // 자신은 N이고 아이템은 1
//    @ManyToOne
//    private Item item;      // 원래 item_id

}
