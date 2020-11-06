package com.example.study.Repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.repository.ItemRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ItemRepositoryTest extends StudyApplicationTests {

    @Autowired
    private ItemRepository itemRepository;
    
    @Test
    public void create(){
        
        Item item = new Item();
        item.setName("노트북");
        item.setPrice(1000000);
        item.setContent("삼성 노트북");

        Item newItem = itemRepository.save(item);
        Assert.assertNotNull(newItem);
    }


    @Test
    public void read(){

        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);

        Assert.assertTrue(item.isPresent());        // 아이템이 있느냐가 트루여야 함.

        item.ifPresent(i -> {
            System.out.println(i);
        });

    }
}
