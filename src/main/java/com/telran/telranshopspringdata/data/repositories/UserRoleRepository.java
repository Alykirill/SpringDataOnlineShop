package com.telran.telranshopspringdata.data.repositories;

import com.telran.telranshopspringdata.data.entity.UserRoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRoleEntity,String> {
}
