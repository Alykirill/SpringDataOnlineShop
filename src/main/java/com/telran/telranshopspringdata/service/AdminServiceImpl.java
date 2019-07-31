package com.telran.telranshopspringdata.service;

import com.telran.telranshopspringdata.data.AdminRepository;
import com.telran.telranshopspringdata.data.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED)
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public String addCategory(String categoryName) {
        return null;
    }

    @Override
    public String addProduct(String productName, BigDecimal price, String categoryId) {
        return null;
    }

    @Override
    public boolean removeProduct(String productId) {
        return false;
    }

    @Override
    public boolean removeCategory(String categoryId) {
        return false;
    }

    @Override
    public boolean updateCategory(String categoryId, String categoryName) {
        return false;
    }

    @Override
    public boolean changeProductPrice(String productId, BigDecimal price) {
        return false;
    }

    @Override
    public boolean addBalance(String userEmail, BigDecimal balance) {
        return false;
    }
}
