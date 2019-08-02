package com.telran.telranshopspringdata.data.repositories;

import com.telran.telranshopspringdata.data.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,String> {
}
