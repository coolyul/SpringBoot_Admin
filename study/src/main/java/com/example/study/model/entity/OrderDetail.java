package com.example.study.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@ToString(exclude = {"user", "item"}) =>
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDateTime orderAt;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;





//    // orderDetail 의 입장에서, 자신은 N이고 상대방이 1 (주문한 물건은 많고 주문자는 1명) ( N:1 )
//    @ManyToOne
//    private User user;      //  객체 타입으로 만들어줘야 함. 원래 user_id
//
//    // 자신은 N이고 아이템은 1
//    @ManyToOne
//    private Item item;      // 원래 item_id

}
