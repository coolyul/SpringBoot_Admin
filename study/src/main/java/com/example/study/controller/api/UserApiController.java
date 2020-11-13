package com.example.study.controller.api;


import com.example.study.controller.CrudController;
import com.example.study.model.entity.User;
import com.example.study.model.network.Header;
import com.example.study.model.network.requst.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.model.network.response.UserOrderInfoApiResponse;
import com.example.study.service.UserApiLogicService;
import jdk.javadoc.internal.doclets.formats.html.markup.Head;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j      // 로깅 테스트하는 롬복 어노테이션!system.out 이랑 비슷한거
@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse, User> {
    // User 정보를 가져오는 컨트롤러를 먼저 만들어주자..! CRUD 컨트롤러 할거임
    // 요 메소드는 너가 반드시 재정의해야해!! 하는 강제 메소드를 인터페이스로 하나 만들어주기.
    // 그런 다음 그 인터페이스를 implement 해주면 바로바로 메소드들 불러옴!!


    @Autowired
    private UserApiLogicService userApiLogicService;

    @GetMapping("/{id}/orderInfo")
    public Header<UserOrderInfoApiResponse> orderInfo(@PathVariable Long id){
        return userApiLogicService.orderInfo(id);
    }

    @GetMapping("")
    public Header<List<UserApiResponse>> search (@PageableDefault(sort = "id",
            direction = Sort.Direction.DESC, size = 10) Pageable pageable){
        log.info("{}", pageable);
        return userApiLogicService.search(pageable);

    }

}
