package com.telran.telranshopspringdata.data.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name= "roles")
@Builder
public class UserRoleEntity {
    @Id
    private String role;
    @ManyToMany(mappedBy = "roles")
    private List<UserDetailsEntity> users;


}
