package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

// 접속을 하려면 주소를 받아와야 하므로 컨트롤러 패키지 안에 겟 컨트롤러 클래스 생성.

// 이것을 컨트롤러로 사용할거야~ 하는 지시자  -> @RestController
// 이것으로 들어올 api 주소를 매핑하는 지시자 -> @RequestMapping
@RestController
@RequestMapping("/api")         // localhost:8080/api   -> 주소는 api로 매핑할거야!
public class GetController {

    // 메소드는 1. 어떤 타입으로 받을건지(겟 타입), 2. 어떤 주소로 받을건지 설정해주기
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")    //localhost:8080/api/getMethod
    public String getRequest(){
        //사용자의 요청에 따라 한가지 메소드로 받을 수 있다.
        return "Hi getMethod";
    }

    // GetMapping은 RequestMapping과는 다르게 메소드 타입을 설정하지 않아도 됨.
    @GetMapping("/getParameter")    // localhost:8080/api/getParameter?id=1234&pw=abcd 주소 뒤 ?로부터 시작
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd){

        // RequestParam은 주소창에서 parameter값 받아올 것을 지정해주는 것.
        // RequestParam(name = "password") 는 리퀘스트 파람은 패스워드라는 이름으로 들어올거야! 라고 알려주는것.
        // 주소창에 id=1234&password=abcd 라고 해도 String pwd라고 알아들음

        System.out.println("id" + id );
        System.out.println("pwd" + pwd );

        // 리턴값은 홈페이지에 리턴되는 값
        return id+pwd;

    }

    // localhost:8080/api/multiParameter?account=abcd&email=study@gmail.com&page=10
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){  // 안에 들어갈 파라미터가 엄청 많아질 때, 객체로 받아올 수 있음. 모델패키지!



        // GetParameter를 받아서 문자열을 리턴하는 것을 공부함.
        // 근데 보통 JSON형태로 함. 밑에가 제이슨 형태
        // {"account" : "", "email" : "", "page" : ""}
        // 그럼 public String getMultiParameter(~~) 가 아니라 public SearchParam getMultiParameter~로 해아함
        // 객체를 리턴! 그러면 자동으로 제이슨 형태로 변환되어서 리턴됨. 제이슨 내장되어있음! 스프링부트

        return searchParam;
    }
}