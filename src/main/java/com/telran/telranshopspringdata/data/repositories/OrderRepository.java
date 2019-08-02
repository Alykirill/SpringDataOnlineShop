package com.telran.telranshopspringdata.data.repositories;

import com.telran.telranshopspringdata.data.entity.CategoryEntity;
import com.telran.telranshopspringdata.data.entity.OrderEntity;
import com.telran.telranshopspringdata.data.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository <OrderEntity,String> {
    List<OrderEntity> findByOwner_Email(String userEmail);
}
