package com.telran.telranshopspringdata.service;

import com.telran.telranshopspringdata.controller.dto.*;
import com.telran.telranshopspringdata.data.entity.ProductEntity;
import com.telran.telranshopspringdata.data.entity.ProductOrderEntity;
import com.telran.telranshopspringdata.data.entity.ShoppingCartEntity;
import com.telran.telranshopspringdata.data.entity.UserEntity;
import com.telran.telranshopspringdata.data.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static com.telran.telranshopspringdata.service.Mapper.map;
import static java.util.stream.Collectors.toList;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED)
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    @Autowired
    ProductOrderRepository productOrderRepository;
    @Autowired
    OrderRepository orderRepository;


    @Override
    public Optional<UserDto> addUserInfo(String email, String name, String phone) {
        if (!userRepository.existsById(email)) {
            UserEntity entity = new UserEntity(email, name, phone, BigDecimal.ZERO, null, null);
            userRepository.save(entity);
            return Optional.of(map(entity));
        }
        return Optional.empty();
    }

    @Override
    public Optional<UserDto> getUserInfo(String email) {
        UserEntity entity = userRepository.findById(email).orElseThrow();
        return Optional.of(map(entity));
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .map(Mapper::map)
                .collect(toList());
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return StreamSupport.stream(categoryRepository.findAll().spliterator(), false)
                .map(Mapper::map)
                .collect(toList());
    }

    @Override
    public List<ProductDto> getProductsByCategory(String categoryId) {
        return productRepository.findAllByCategory_Id(categoryId)
                .map(Mapper::map)
                .collect(toList());
    }

    @Override
    public Optional<ShoppingCartDto> addProductToCart(String userEmail, String productId, int count) {
        Optional<ProductEntity> product = productRepository.findById(productId);
        Optional<UserEntity> user = userRepository.findById(userEmail);
        if (user.isEmpty() || product.isEmpty()) {
            throw new RuntimeException(String.format("User %s or %s product not found", userEmail, productId));
        }
        ShoppingCartEntity sce = shoppingCartRepository.findShoppingCartEntitiesByOwner_Email(userEmail);
        if (sce == null) {
            sce = shoppingCartRepository.save(ShoppingCartEntity.builder().date(Timestamp.valueOf(LocalDateTime.now())).owner(user.get())
                    .build());
        }
        ProductOrderEntity poe = productOrderRepository.findProductOrderEntitiesByProductIdAndShoppingCart(productId, sce);
        if (poe != null) {
            poe.setCount(poe.getCount() + count);
            poe.setPrice(product.get().getPrice());
        } else {
            poe = ProductOrderEntity.builder().productId(productId).name(product.get().getName()).price(product.get().getPrice())
                    .category(product.get().getCategory()).count(count).shoppingCart(sce).build();
            productOrderRepository.save(poe);
        }

        return Optional.of(map(shoppingCartRepository.findById(sce.getId()).get()));
    }

    @Override
    public Optional<ShoppingCartDto> removeProductFromCart(String userEmail, String productId, int count) {
        return Optional.empty();
    }

    @Override
    public Optional<ShoppingCartDto> getShoppingCart(String userEmail) {

        return Optional.empty();
    }

    @Override
    public boolean clearShoppingCart(String userEmail) {
        return false;
    }

    @Override
    public List<OrderDto> getOrders(String userEmail) {
        return null;
    }

    @Override
    public Optional<OrderDto> checkout(String userEmail) {
        return Optional.empty();
    }
}
