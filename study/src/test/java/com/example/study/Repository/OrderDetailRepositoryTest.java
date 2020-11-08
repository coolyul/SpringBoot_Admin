package com.example.study.Repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderDetail;
import com.example.study.repository.OrderDetailRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.DateTimeException;
import java.time.LocalDateTime;

import static org.junit.Assert.assertNotNull;

public class OrderDetailRepositoryTest extends StudyApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Test
    public void create(){
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setOrderAt(LocalDateTime.now());

        // 누가 주문?
//        orderDetail.setUserId(1L);

        // 어떤거 주문??
//        orderDetail.setItemId(1L);

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);

    }
}
