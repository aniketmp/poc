package org.learning.dtos;

import lombok.Data;
import org.learning.entities.Role;


@Data
public class UserDto {
    private String userName;
    private String password;
    private Role role;
    public UserDto(String userName, String password, Role role){
        this.userName=userName;
        this.password=password;
        this.role=role;
    }

}
