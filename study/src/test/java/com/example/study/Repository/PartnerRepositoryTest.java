package com.example.study.Repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Partner;
import com.example.study.repository.PartnerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.Part;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
public class PartnerRepositoryTest extends StudyApplicationTests {
    
    @Autowired
    private PartnerRepository partnerRepository;
    
    @Test
    public void create(){
        String name = "Partner01";
        String status = "REGISTERED";
        String address = "서울시 강남구";
        String callCenter = "070-1111-1111";
        String partnerNumber = "010-1111-1111";
        String businessNumber = "1234567890123";
        String ceoName = "홍길동";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";
        Long categoryId = 1L;


        Partner partner = new Partner();
        partner.setName(name);
        partner.setStatus(status);
        partner.setAddress(address);
        partner.setCallCenter(callCenter);
        partner.setPartnerNumber(partnerNumber);
        partner.setBusinessNumber(businessNumber);
        partner.setCeoName(ceoName);
        partner.setRegisteredAt(registeredAt);
        partner.setCreatedAt(createdAt);
        partner.setCreatedBy(createdBy);
        partner.setCategoryId(categoryId);


        Partner newPartner = partnerRepository.save(partner);
        Assert.assertNotNull(newPartner);
        Assert.assertEquals(newPartner.getName(), name);



    }// create end
    
    public void read(){
        
        
    }// read end
}// class end 
