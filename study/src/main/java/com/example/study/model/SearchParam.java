package com.example.study.model;

public class SearchParam {
    // RequestParam의 값을 지정해주기 위한 클래스

    private String account;
    private String email;
    private int page;

    // { "account" : "", "email" : "", "page" : 0 }     JSON 형태!

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
}
