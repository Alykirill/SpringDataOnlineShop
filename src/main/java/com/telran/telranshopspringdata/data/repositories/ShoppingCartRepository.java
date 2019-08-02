package com.telran.telranshopspringdata.data.repositories;

import com.telran.telranshopspringdata.data.entity.ShoppingCartEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCartEntity,String> {
    ShoppingCartEntity findShoppingCartEntitiesByOwner_Email(String email);
}
