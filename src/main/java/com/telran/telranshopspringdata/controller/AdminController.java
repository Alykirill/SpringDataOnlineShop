package com.telran.telranshopspringdata.controller;

import com.telran.telranshopspringdata.controller.dto.AddUnitResponseDto;
import com.telran.telranshopspringdata.controller.dto.CategoryDto;
import com.telran.telranshopspringdata.controller.dto.ProductDto;
import com.telran.telranshopspringdata.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdminController {
    @Autowired
    AdminService service;

    @PostMapping("category")
    public AddUnitResponseDto addCategory(@RequestBody CategoryDto dto){
        String id = service.addCategory(dto.getName());
        return AddUnitResponseDto.builder().id(id).build();
    }

    @PostMapping("product")
    public AddUnitResponseDto addProduct(@RequestBody ProductDto dto){
        String id = service.addProduct(dto.getName(), dto.getPrice(),dto.getCategory().getId());
        return AddUnitResponseDto.builder().id(id).build();
    }
}
