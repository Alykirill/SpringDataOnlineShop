package com.telran.telranshopspringdata.data.repositories;

import com.telran.telranshopspringdata.data.entity.UserDetailsEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository extends CrudRepository <UserDetailsEntity,String> {
}
