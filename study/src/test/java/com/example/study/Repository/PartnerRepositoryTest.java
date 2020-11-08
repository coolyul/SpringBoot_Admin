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
import java.util.Optional;

@RunWith(SpringRunner.class)
public class PartnerRepositoryTest extends StudyApplicationTests {
    
    @Autowired
    private PartnerRepository partnerRepository;
    
    @Test
    public void create(){
        String name = "Partner02";
        String status = "REGISTERED";
        String address = "뉴욕 캘리포니아";
        String callCenter = "070-1111-2222";
        String partnerNumber = "010-1111-2222";
        String businessNumber = "2234567890321";
        String ceoName = "스티브잡스";
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
//        partner.setCategoryId(categoryId);


        Partner newPartner = partnerRepository.save(partner);
        Assert.assertNotNull(newPartner);
        Assert.assertEquals(newPartner.getName(), name);



    }// create end

    @Test
    public void read(){

        Optional<Partner> partner = partnerRepository.findById(1L);
        Assert.assertNotNull(partner);
        
    }// read end
}// class end 
