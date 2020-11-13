package com.example.study.service;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.entity.OrderGroup;
import com.example.study.model.entity.User;
import com.example.study.model.enumclass.UserStatus;
import com.example.study.model.network.Header;
import com.example.study.model.network.Pagination;
import com.example.study.model.network.requst.UserApiRequest;
import com.example.study.model.network.response.ItemApiResponse;
import com.example.study.model.network.response.OrderGroupApiResponse;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.model.network.response.UserOrderInfoApiResponse;
import com.example.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service        // 이 클래스는 서비스로 동작하게 됨!
public class UserApiLogicService extends BaseService<UserApiRequest, UserApiResponse, User> {
//
//    @Autowired
//    private UserRepository userRepository;      //이것도 따로 등록해줘야함

    // 1. Request Data 가져오기
    // 2. User 생성해주기
    // 3. 생성된 데이터를 UserApiResponse로 리턴


    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        // 1. Request Data 가져오기
        UserApiRequest userApiRequest = request.getData();

        // 2. 유저생성
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status(UserStatus.REGISTERED)
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();
        User newUser = baseRepository.save(user);

        // 3. UserApiResponse 를 Return. 근데 유저 객체를 가지고 업데이트 등등 할수있기에 따로 메소드 관리
        // 맨밑으로 빼자!


        return Header.OK(response(newUser));       // 이렇게 하면 맨 밑에있는 매소드로 감~연결!
    }

    @Override
    public Header<UserApiResponse> read(Long id) {

        // 1. id를 갖고 Repository 통해서 getOne, getId 해서 얻어오기
        return baseRepository.findById(id)

        // 2. user 가지고 userApiResponse return 해주기

                .map(user -> response(user))
                .map(userApiResponse -> Header.OK(userApiResponse))
                        // ==  .map(Header::OK)
                .orElseGet(
                        () -> Header.ERROR("데이터 없음")
                );
    }


    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {

        // 1. data 가져오고
        UserApiRequest userApiRequest = request.getData();

        // 2. id로 user data 찾고
        Optional<User> optional = baseRepository.findById(userApiRequest.getId());

        return optional.map(user -> {

            // 3. 가져온 data를 가지고 update 시켜주고. 새로운 정보들! map 메소드가 새 정보 리턴해줌
            user.setAccount(userApiRequest.getAccount())
                    .setPassword(userApiRequest.getPassword())
                    .setStatus(userApiRequest.getStatus())
                    .setPhoneNumber(userApiRequest.getPhoneNumber())
                    .setEmail(userApiRequest.getEmail())
                    .setRegisteredAt(userApiRequest.getRegisteredAt())
                    .setUnregisteredAt(userApiRequest.getUnregisteredAt())
                    ;

            // 4. userApiResponse return 해주면됨
            return user;

        })
                .map(user -> baseRepository.save(user))       // update된 newUser객체 반환!
                .map(user -> response(user))      // user api 만들어짐
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음"));     // 한가지라도 정보 빠지면 에러

    }

    @Override
    public Header delete(Long id) {

        // 1. id 를 가지고 repository 통해 user 찾고

        Optional<User> optional = baseRepository.findById(id);

        // 2. repository에서 delete 해주고
        // 3. response 를 return 해줌
        return optional.map(user -> {
            baseRepository.delete(user);

            return Header.OK();
        })
                .orElseGet(() -> Header.ERROR("데이터 없음"));



    }



    private UserApiResponse response(User user){
        // user 객체를 갖고 UserApiResponse 를 만들어 리턴해주는 메소드!
        // 업데이트 딜리트에도 쓰이므로 따로 빼줌.

        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())       // todo 암호화, 길이
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        // Header에 위 데이터 합쳐서 리턴! 헤더 OK 부분에 데이터 넣어줘보자
        return userApiResponse;
    }


    public Header<List<UserApiResponse>> search(Pageable pageable) {

        Page<User> users = baseRepository.findAll(pageable);

        List<UserApiResponse> userApiResponseList = users.stream()
                .map(user -> response(user))
                .collect(Collectors.toList());

        Pagination pagination = Pagination.builder()
                .totalPages(users.getTotalPages())
                .totalElements(users.getTotalElements())
                .currentPage(users.getNumber())
                .currentElements(users.getNumberOfElements())
                .build();

        return Header.OK(userApiResponseList, pagination);
    }

    public Header<UserOrderInfoApiResponse> orderInfo(Long id) {

        // 1. user 사용자 정보

        User user = baseRepository.getOne(id);
        UserApiResponse userApiResponse = response(user);


        // 2. orderGroup 주문 내역
        List<OrderGroup> orderGroupList = user.getOrderGroupList();

        List<OrderGroupApiResponse> orderGroupApiResponseList = orderGroupList.stream()
                .map(orderGroup -> {
                    OrderGroupApiResponse orderGroupApiResponse =
                            orderGroupApiLogicService.response(orderGroup).getData();

                    // 3. 해당 오더 리스트의 아이템들을 찾아오기
                    List<ItemApiResponse> itemApiResponsesList = orderGroup.getOrderDetailList().stream()
                            .map(detail -> detail.getItem())
                            .map(item -> itemApiLogicService.response(item).getData())
                            .collect(Collectors.toList());

                    orderGroupApiResponse.setItemApiResponseList(itemApiResponsesList);
                    return orderGroupApiResponse;

                })
                .collect(Collectors.toList());

        userApiResponse.setOrderGroupApiResponsesList(orderGroupApiResponseList);
        UserOrderInfoApiResponse userOrderInfoApiResponse = UserOrderInfoApiResponse.builder()
                .userApiResponse(userApiResponse)
                .build();

        return Header.OK(userOrderInfoApiResponse);
    }
}
