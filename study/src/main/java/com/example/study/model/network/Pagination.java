package com.example.study.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Pagination {

    // 이거는 프론트엔트에 넘겨줘야 하는 정보. 페이지 몇페이지로 나눌건지 정하기 위해 알려주는 정보들

    private Integer totalPages;
    private Long totalElements;     // 총 유저 수
    private Integer currentPage;
    private Integer currentElements;
}
