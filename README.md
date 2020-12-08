# Admin Project

SpringBoot 를 이용하여 만든 물품 주문 Admin 사이트의 Back-end 부분 구현 코드입니다.
사용자 정보, 주문 정보, 주문 아이템의 상세, 상품 아이템의 파트너사 정보 등을 구현하였습니다.

localhost:8080/pages 
위의 페이지를 통해 구현한 화면을 확인하실 수 있습니다. 

# Technologies
 - Java
 - SpringBoot
 - Rest API
 - JPA
 - MySql
 
# Features

## 1. ERD 관계도

### User, OrderGroup, OrderDetail, Item, Partner, Category의 관계도

  ![image](https://user-images.githubusercontent.com/65394344/101451736-fdf86680-396f-11eb-9dbe-37cee8367984.png)


## 2. Http Method를 이용한 CRUD 

GET, POST, PUT, DELETE 메소드를 이용해 사용자, 주문 정보, 아이템 카테고리 등의 정보 CRUD 


## 3. Pagination을 활용한 페이징

  - Pagination을 통해 한 페이지당 사용자 정보수 제한

  ![image](https://user-images.githubusercontent.com/65394344/101453964-89bfc200-3973-11eb-8311-f70789b79161.png)
