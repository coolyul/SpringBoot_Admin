package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor      // Data부터 세 줄은 기본으로 가져가는 어노테이션!
@Entity
public class Item {     // mysql에서 만들었던 컬럼과 똑같이 만들어주면 됨.

    @Id         // 기본키니까 해주기
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // mysql의 strategy!
    private Long id;

    private String name;

    private Integer price;

    private String content;
}
