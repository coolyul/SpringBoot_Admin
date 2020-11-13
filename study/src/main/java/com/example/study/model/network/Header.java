package com.example.study.model.network;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Header<T> {       // 네트워크 부분에서 항상 공통으로 들어가는 부분 헤더로 지정!

    // Rest API를 작성할 땐 snake 케이스를 사용한다. _ 이용!
    // 근데 여기 선언할 땐 camel 케이스로 작성. 그래서 바뀌도록 해줘야함!
    // 카멜 케이스를 스네이크로 바꾸는 방법은 여러가지.
    // @JsonProperty("transaction_time") 처럼 직접 만들어줄수도 있고.
    // Application.property에 spring.jackson.property-naming-strategy=SNAKE_CASE gowna.


    // api x통신시간. Front와 통신할 땐 보통 String이라 씀
    // ISO, YYYY-MM-DD 로 할 수도 있지만 디폴트는 LocalDateTime
    @JsonProperty("transaction_time")       // snakeCase로 지정해줄수있음.
    private LocalDateTime transactionTime;

    // api 응답 코드
    private String resultCode;

    // api 부가 설명
    private String description;

    // 데이터가 계속 바뀌는 부분을 적용하기 위해서는 제네릭을 생성!!  Header<T> 로 해준다음 아래 선언
    private T data;

    private Pagination pagination;


    // OK 나오게 하는 메소드
    public static <T> Header<T> OK(){
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .build();
    }

    // DATA 들어있는 OK

    public static <T> Header<T> OK(T data){
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .build();
    }

    // 페이지 나누는거 해주는 메소드
    public static <T> Header<T> OK(T data, Pagination pagination){
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .pagination(pagination)
                .build();
    }


    // 데이터 없는 ERROR
    public static <T> Header<T> ERROR(String description){
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description(description)
                .build();
    }

}
