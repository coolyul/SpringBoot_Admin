package com.example.study.Repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.repository.ItemRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Optional;


public class ItemRepositoryTest extends StudyApplicationTests {

    @Autowired
    private ItemRepository itemRepository;
    
    @Test
    public void create(){

        Item item = new Item();
        item.setStatus("UNREGISTERED");
        item.setName("애플 노트북");
        item.setTitle("애플 노트북 2020");
        item.setContent("2020년형 노트북 입니다");
        item.setPrice(12000000);
        item.setBrandName("애플");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("Partner02");
//        item.setPartnerId(2L);

        Item newItem = itemRepository.save(item);
        Assert.assertNotNull(newItem);





//        Item item = new Item();
//        item.setName("노트북");
//        item.setPrice(3000000);
//        item.setContent("애플 노트북");



    }


    @Test
    public void read(){

        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);      // 이 아이디가 있을 수도 있고 없을 수도 있으니까 옵셔널

        Assert.assertTrue(item.isPresent());        // 아이템이 있느냐가 트루여야 함.

        item.ifPresent(i -> {
            System.out.println(i);
        });

    } // read end

    @Test
    public void update(){

        Long id = 3L;

        Optional<Item> item = itemRepository.findById(id);

        Assert.assertTrue(item.isPresent());

        item.ifPresent(selectItem -> {
            selectItem.setName("ASUS");

            itemRepository.save(selectItem);
        });

    } // update end


    @Test
    public void delete(){

        Long id = 3L;

        Optional<Item> item = itemRepository.findById(id);

        item.ifPresent(selectItem -> {
            itemRepository.delete(selectItem);

        });
    }
}
