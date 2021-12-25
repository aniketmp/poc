package org.learning.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.learning.entities.Role;

@Data
@JsonNaming(PropertyNamingStrategy.KebabCaseStrategy.class)
public class CreateUserDto {
    private String userName;
    private String password;
    private Role role;
}
