package com.telran.telranshopspringdata.data;

import com.telran.telranshopspringdata.data.entity.CategoryEntity;
import com.telran.telranshopspringdata.data.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository <CategoryEntity,String> {
}
