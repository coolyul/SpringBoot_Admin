package com.example.study.Repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import com.example.study.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {
    // 자동으로 생성된 StudyApplicationTests를 extends해줘야함
    // CRUD 테스트할거기때문에 선언해줌

    @Autowired      // 레파지토리를 이용해 테스트할거기때문에 요 두 줄을 써줘야 함.
    private UserRepository userRepository;      // 이건 하나만 생성해두고 Autowired 붙이는곳에 다 같이 쓰겠다! 싱글톤
    /*
    * 원래같으면 UserRepository userRepository = new UserRepository(); 로 객체를 만들어서 사용해주는게 일반적.
    * 근데 의존성 주입!!
    * 직접 객체를 만들지 않고 스프링이 직접 주입을 해주겠다 하는게 Autowired
    * = Dependency Injection(DI)
    * */


    @Test       // 우리 이거 테스트해보려고 만든 메소드다!
    public void create(){
        // String sql = insert into user( %s, %d, ..) value ( account, email ...) 원래 이런 쿼리문 써야함
        // JPA 장점은 쿼리문 안쓰고 오브젝트로 관리할 수 있게끔 해준다!

        User user = new User();     // 사용자의 정보가 다 다를 수 있기 때문에 Autowired로 안하고 직접 생성
//        user.setId();     // d이건 mysql에서 AI (자동으로 번호 생성) 체크해줬기 때문에 필요없음.
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-1111-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("yuri");


        // save라는 메소드가 있음. user를 ()안에 넘기고 새 newUser로 나옴.
        User newUser = userRepository.save(user);
        System.out.println("newUser:" + newUser);

        
    }

    @Test
    public void read(){
        Optional<User> user = userRepository.findById(2L);  // id타입 2L인거 찾아줘

        user.ifPresent(selectUser ->{       // 만약 유저 값이 있으면 꺼내달라. 이름은 selectUser로 하겠다 
            System.out.println("user : " + selectUser);
            System.out.println("email : " + selectUser.getEmail());
        });
    }



    @Test
    public void update(){
        // update를 하려면 먼저 Select부터 해야함.
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser ->{       // 유저가 잇어야 업데이트를 하기 때문에 또 넣어줌.
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            // 우리가 이미 있는 findById(2L)로 아이디를 지정해줬으므로 save 메소드로 업데이트가 됨.
            // selectUser.setId(3L) 이렇게 하면 id = 3인 것의 정보가 바뀌게 됨,
            userRepository.save(selectUser);

        });

    }


    @Test
    @Transactional      // 이거 쓰고선 테스트 돌리면 데이터베이스 삭제 되었다가 롤백해줌. 그니까 DB는 변동없게됨!
    public void delete(){
        Optional<User> user = userRepository.findById(3L);

        Assertions.assertTrue(user.isPresent());        // isPresent가 트루일때만 실행해야해! 정보있어야 삭제가능


        user.ifPresent(selectUser ->{       // 만약 이 user가 있으면 지워줘
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(6L);

        Assertions.assertFalse(deleteUser.isPresent()); // isPresent가 반드시 false! 삭제돼서 없어야하니까
    }

}
