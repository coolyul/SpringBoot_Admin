package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")     // localhost:8080/api   메소드끼리는 매핑주소 중복x 클래스끼리는 중복o
public class PostController {

    // post는 HTML <Form> 태그에 사용, 혹은 ajax 검색에 사용됨
    // http통신할 때 post의 body에 데이터를 집어넣어 보내겠다! -> @RequestBody에 searchparam 값들을 넣어주세요
    // requestBody 할 때 포스트방식 - json, xml, multipart-form , text-plain 형태 등등 지원
    // JSON 형태로 들어온 데이터를 처리할 때! POST를 씀. 혹은 주소창에 사용자 요청 안나오게 함

    // @RequestMapping(method = requestMethod.Post, path = "/postMethod") 이게 결국 @PostMapping("/postMethod"))
    @PostMapping(value = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){

        // 개발하면서 테스트하기 위해서는 RestClient로 Request요청하고 Test하는 방법이 있음.
        // Test 개발하는 툴은 크롬-설정-도구더보기-확장프로그램.
        // 크롬 웹스토어 - Rest Client 제일 위에꺼

        
        // RequestBody에 들어온 내용을 리턴시켜주기
        return searchParam;
    }

    @PutMapping("/putMethod")     // 데이터베이스의 특정 자원을 업데이트 시킬 때 해당 데이터를 넣어서 업데이트 요청하는 것
    public void put(){

    }

    @PatchMapping("/patchMethod")
    public void patch(){

    }


}
