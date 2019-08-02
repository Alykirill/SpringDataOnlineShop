package com.telran.telranshopspringdata.data.entity;

import lombok.*;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "user_details")
public class UserDetailsEntity {
    @Id
    private String email;
    private String password;
    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name= "user_email", referencedColumnName = "email"
            ),inverseJoinColumns = @JoinColumn(
                    name="user_role",referencedColumnName = "role"
    )
    )
    private List<UserRoleEntity> roles;
}
