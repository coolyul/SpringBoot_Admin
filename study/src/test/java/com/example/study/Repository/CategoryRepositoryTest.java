package com.example.study.Repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Category;
import com.example.study.repository.CategoryRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends StudyApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;


    @Test
    public void create(){       // 카테고리 생성. createdAt, createdBy notnull!
        String type = "PHONE";
        String title = "핸드폰";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);

        Assert.assertNotNull(newCategory);
        Assert.assertEquals(newCategory.getType(),type);
        Assert.assertEquals(newCategory.getTitle(),title);



    }


    @Test
    public void read(){

        // Select * from category where type = 'COMPUTER' 이런 식을 많이 씀
        String type = "COMPUTER";
        Optional<Category> optionalCategory = categoryRepository.findByType(type);
        
//        Optional<Category> optionalCategory = categoryRepository.findById(1L); 이건 그냥 간단히 아이디로 검색

        

        optionalCategory.ifPresent(c -> {

            // c의 타입은 우리의 타입과 같아야 한다!
            Assert.assertEquals(c.getType(), type);

            System.out.println(c.getId());
            System.out.println(c.getType());
            System.out.println(c.getTitle());

        });




    }

}
