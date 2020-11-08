package com.example.study.repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Repository란, 따른 쿼리문 딱히 안쓰고 자동으로 CRUD 하게 해주는 것! 레파지토리 @ 하면됨.
    // JpaRepository <어떠한 타입의 객체 들어갈건지, 기본키(식별자) 어떤 타입으로 할건지>
    // 우리는 User클래스를 객체로 하고, id를 Long타입으로 했으므로 Long을 넣어줌.


    // 핸드폰으로 검색하기. 가장 최근것 리턴. Id 역순
    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);








//    // Select * from user where account = ?? 이거랑 같은 것! test03, test04... 아이디!
//    Optional<User> findByAccount(String account);       // 우리는 account로 찾겟다!
//
//    Optional<User> findByEmail(String email);           // 이메일로 찾겟다!
//
//    // Select * from uwer where account = ? and email = ?
//    Optional<User> findByAccountAndEmail(String account, String email);
}
