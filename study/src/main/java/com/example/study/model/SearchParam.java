package com.example.study.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data       // Lombok Data 어노테이션 - 기본 생성자와 게터세터 메소드를 자동 생성해주고 자동으로 배정해줌.
@AllArgsConstructor     // Lombok AllargsConstructor 어노테이션 - 모든 매개변수를 가지는 생성자가 추가됨.
public class SearchParam {
    // RequestParam의 값을 지정해주기 위한 클래스

    private String account;
    private String email;
    private int page;

    // { "account" : "", "email" : "", "page" : 0 }     JSON 형태!





/*
    이렇게 정해주는 건 Lombok이 없을 때!!

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

 */
}
