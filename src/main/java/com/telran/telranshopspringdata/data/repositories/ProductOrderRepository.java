package com.telran.telranshopspringdata.data.repositories;

import com.telran.telranshopspringdata.controller.dto.ProductOrderDto;
import com.telran.telranshopspringdata.data.entity.ProductOrderEntity;
import com.telran.telranshopspringdata.data.entity.ShoppingCartEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductOrderRepository extends CrudRepository <ProductOrderEntity,String> {
    ProductOrderEntity findProductOrderEntitiesByProductIdAndShoppingCart(String productId, ShoppingCartEntity shoppingCartEntity);
    void deleteByShoppingCart(ShoppingCartEntity shoppingCartEntity);

    List<ProductOrderEntity> findProductOrderEntitiesByShoppingCart(ShoppingCartEntity shoppingCartEntity);
}
