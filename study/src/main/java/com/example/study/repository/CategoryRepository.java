package com.example.study.repository;

import com.example.study.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    // select * from category where type = ?? 이런 쿼리문 추가! 
    Optional<Category> findByType(String type);

}
